package com.example.fabcaredrycleaners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fabcaredrycleaners.Common.LoginSignup.LoginPage;
import com.example.fabcaredrycleaners.Common.LoginSignup.RegisterPage;

public class LoginOrRegisterPage extends AppCompatActivity {

    Button loginfirst, registerfirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register_page);

        loginfirst = findViewById(R.id.loginfirstbtn);
        registerfirst = findViewById(R.id.registerfirstbtn);

        loginfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginPage.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

        registerfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterPage.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });



    }

}