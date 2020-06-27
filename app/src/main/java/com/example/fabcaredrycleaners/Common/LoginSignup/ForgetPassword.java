package com.example.fabcaredrycleaners.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.fabcaredrycleaners.R;

public class ForgetPassword extends AppCompatActivity {

    Button btnNextGoToSelection;
    ImageView btnGoBack3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        btnNextGoToSelection=findViewById(R.id.goToSelection);
        btnGoBack3=findViewById(R.id.goBackImage3);
        btnNextGoToSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EmailOrPhonePage.class));
            }
        });

        btnGoBack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginPage.class));
            }
        });

    }




}