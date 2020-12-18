package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.fabcaredrycleaners.Databases.CheckInternet;
import com.example.fabcaredrycleaners.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetNewPassPage extends AppCompatActivity {

    TextInputLayout newPassword, confirmNewPassword;
    Button btnSetNewPass;
    RelativeLayout progressBarSetNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_new_pass_page);

        progressBarSetNew=findViewById(R.id.progressbarSetNew);

        newPassword=findViewById(R.id.newPassword);
        confirmNewPassword=findViewById(R.id.confirmNewPassword);
        btnSetNewPass=findViewById(R.id.btnSetNewPass);
    }

    private boolean validatePassword(){
        String val= newPassword.getEditText().getText().toString().trim();
        if (val.length()>8 || val.length()<4){
            newPassword.setError("Should have 4 to 8 digits");
            return false;
        }
        else{
            newPassword.setError(null);
            newPassword.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateConfirmPassword(){
        String val= confirmNewPassword.getEditText().getText().toString().trim();
        String valOld = newPassword.getEditText().getText().toString().trim();
        if (!val.equals(valOld)){
            confirmNewPassword.setError("Enter correct password again");
            return false;
        }
        else{
            confirmNewPassword.setError(null);
            confirmNewPassword.setErrorEnabled(false);
            return true;
        }
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(SetNewPassPage.this);
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





    public void setNewPasswordBtn(View view){

        //CHECK INTERNET CONNECTIVITY using the class we created inside databases in the common folder
        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)){
            showCustomDialog();
            return;
        }

        if (!validatePassword() | !validateConfirmPassword() ){

            return;

        }

        progressBarSetNew.setVisibility(View.VISIBLE);

        String newPasswordString = newPassword.getEditText().getText().toString().trim();
        String phoneNumberString = getIntent().getStringExtra("phoneNumber");

        //UPDATE DATA IN FIREBASE AND IN SESSIONS

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(phoneNumberString).child("password").setValue(newPasswordString);

        Toast.makeText(this, "Password reset successful. Login again using new password", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getApplicationContext(), LoginPage.class));
        finish();



    }



}