package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.fabcaredrycleaners.Databases.CheckInternet;
import com.example.fabcaredrycleaners.LoginOrRegisterPage;
import com.example.fabcaredrycleaners.R;
import com.example.fabcaredrycleaners.User.HomePage;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Queue;

public class LoginPage extends AppCompatActivity {

    ImageView logoimage;
    RelativeLayout progressBar;
    Button buttonforgot, buttonlogin, buttonregisternew;
    TextInputLayout phoneNumberLogin, passwordLogin;
    String phoneNo, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        logoimage=findViewById(R.id.logoimage);

        phoneNumberLogin=findViewById(R.id.phoneNumberInLogin);
        passwordLogin=findViewById(R.id.passwordInLogin);
        progressBar=findViewById(R.id.loginProgressbar);

        buttonforgot=findViewById(R.id.buttonforgot);
        buttonlogin=findViewById(R.id.buttonlogin);
        buttonregisternew=findViewById(R.id.buttonregisternew);

        buttonregisternew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(i);
                finish();
            }
        });

        buttonforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgetPassword.class));
                finish();
            }
        });

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letTheUserLogin(v);
            }
        });

    }

    public void letTheUserLogin(View view){

        //check internet connectivity

        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)){
            showCustomDialog();
            return;
        }

//
//        if(!isConnected(this)){
//
//            showCustomDialog();
//
//        }



        if(!validateFields()){
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        phoneNo = phoneNumberLogin.getEditText().getText().toString().trim();
        pass = passwordLogin.getEditText().getText().toString().trim();

        if (phoneNo.charAt(0)=='0'){
            phoneNo = phoneNo.substring(1);
        }

        //DATABASE
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNumber").equalTo(phoneNo);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    phoneNumberLogin.setError(null);
                    phoneNumberLogin.setErrorEnabled(false);

                    String systemPassword = dataSnapshot.child(phoneNo).child("password").getValue(String.class);
                    if (systemPassword.equals(pass)){
                        passwordLogin.setError(null);
                        passwordLogin.setErrorEnabled(false);

                        String userName = dataSnapshot.child(phoneNo).child("userName").getValue(String.class);
                        String phoneNumber = dataSnapshot.child(phoneNo).child("phoneNumber").getValue(String.class);

                        Toast.makeText(LoginPage.this, phoneNumber+"\n"+userName, Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        startActivity(new Intent(getApplicationContext(), HomePage.class));

                    }
                    else{
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(LoginPage.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(LoginPage.this, "User does not exist\n/Wrong credentials entered", Toast.LENGTH_SHORT).show();
                }
                
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(LoginPage.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    //check internet

//    private boolean isConnected(LoginPage loginPage) {
//
//        ConnectivityManager connectivityManager = (ConnectivityManager) loginPage.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo wifiConn= connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        NetworkInfo mobileConn= connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected()) ){
//            return true;
//        }
//        else{
//            return false;
//        }
//    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
        builder.setMessage("Please make sure you have an active internet connection to proceed further")
                .setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), LoginOrRegisterPage.class));
                        finish();
                    }
                });

    }


    private boolean validateFields(){
        String phoneNoVal = phoneNumberLogin.getEditText().getText().toString();
        String passVal= passwordLogin.getEditText().getText().toString();

        if (phoneNoVal.isEmpty()){
            phoneNumberLogin.setError("Field cannot be empty");
            phoneNumberLogin.requestFocus();
            return false;
        }
        else if(passVal.isEmpty()){
            passwordLogin.setError("Password cannot be empty");
            passwordLogin.requestFocus();
            return false;
        }
        else{
            phoneNumberLogin.setError(null);
            phoneNumberLogin.setErrorEnabled(false);
            passwordLogin.setError(null);
            passwordLogin.setErrorEnabled(false);
            return true;
        }
    }


}
