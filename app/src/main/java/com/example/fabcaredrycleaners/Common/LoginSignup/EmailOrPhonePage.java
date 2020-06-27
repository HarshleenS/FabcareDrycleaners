package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fabcaredrycleaners.Common.LoginSignup.GetOtpPage;
import com.example.fabcaredrycleaners.R;

public class EmailOrPhonePage extends AppCompatActivity {

    ImageView goBack;
    Button btnSelectPhone, btnSelectEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_or_phone_page);

        goBack=findViewById(R.id.goBackImage4);
        btnSelectPhone=findViewById(R.id.btnPhoneForForgetPass);
        btnSelectEmail=findViewById(R.id.btnEmailForForgetPass);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgetPassword.class));
            }
        });

        btnSelectPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Otp for phone selected", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelectEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Otp for Email selected", Toast.LENGTH_SHORT).show();
            }
        });





    }


}