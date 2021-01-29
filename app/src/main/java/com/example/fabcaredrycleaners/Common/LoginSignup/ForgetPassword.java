package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabcaredrycleaners.Databases.CheckInternet;
import com.example.fabcaredrycleaners.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ForgetPassword extends AppCompatActivity {

    Button btnNextGoToSelection;
    TextInputLayout TILphoneneeded;
    ImageView btnGoBack3;
    RelativeLayout progressBarForgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        btnNextGoToSelection=findViewById(R.id.goToSelection);
        TILphoneneeded=findViewById(R.id.phoneNumberNeededToReset);
        btnGoBack3=findViewById(R.id.goBackImage3);
        progressBarForgotpass=findViewById(R.id.loginProgressbarForgotPass);


        //final String phoneneeded = TILphoneneeded.getEditText().getText().toString().trim();



    }


    private boolean validatePhoneNumber(){
        String val= TILphoneneeded.getEditText().getText().toString().trim();
        String checkPhone = "[0-9]{10}";
        if (val.isEmpty()){
            TILphoneneeded.setError("Field cannot be empty");
            return false;
        }
        else if(!val.matches(checkPhone)){
            TILphoneneeded.setError("Invalid phone number.Enter a valid 10 digit phone number");
            return false;
        }
        else{
            TILphoneneeded.setError(null);
            TILphoneneeded.setErrorEnabled(false);
            return true;
        }
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ForgetPassword.this);
        builder.setMessage("Make sure that you are connected to the internet").setCancelable(false)
                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), LoginPage.class));
                        finish();
                    }
                });


    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void enterPhoneForgotPass(View view){

        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)){
            showCustomDialog();
            return;
        }




        //CHANGE HEREEEEEEEE





        if(validatePhoneNumber()){
            progressBarForgotpass.setVisibility(View.VISIBLE);

            final String phoneString = TILphoneneeded.getEditText().getText().toString();

            //CHECK IF PHONE NUMBER EXISTS IN DATA BASE OR NOT

            Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNumber").equalTo(phoneString);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //IF PHONE NUMBER EXISTS THEN CALL OTP TO VERIFY THAT IT IS CORRECT PHONE NUMBER
                    if(dataSnapshot.exists()){
                        TILphoneneeded.setError(null);
                        TILphoneneeded.setErrorEnabled(false);

                        Intent intent = new Intent(getApplicationContext(), GetOtpForgotPass.class);
                        intent.putExtra("phoneNumber", phoneString);
                        //intent.putExtra("whatToDo", "updateData");
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        finish();

                        progressBarForgotpass.setVisibility(View.GONE);
                    }
                    else{
                        progressBarForgotpass.setVisibility(View.GONE);
                        TILphoneneeded.setError("No such user exists");
                        TILphoneneeded.requestFocus();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        }
        //
        //
        //

    }


//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    private boolean isConnectedToNet(ForgetPassword forgetPassword) {
//
//        ConnectivityManager connectivityManager = (ConnectivityManager) forgetPassword.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())){
//            return true;
//        }
//        else
//            return false;
//    }


    public void goBackMethod(View view){
        Intent intent = new Intent(getApplicationContext(), LoginPage.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }



//    public void callGetOtpScreenForgotPass(View view){
//        if(!validatePhoneNumber()){
//            return;
//        }
//
//
//        String phoneString = TILphoneneeded.getEditText().getText().toString();
//
//        Intent i = new Intent(getApplicationContext(), GetOtpPageForgotPass.class);
//        i.putExtra("phoneNumber", phoneString);
//        startActivity(i);
//    }







}