package com.example.fabcaredrycleaners.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.fabcaredrycleaners.Common.LoginSignup.LoginPage;
import com.example.fabcaredrycleaners.LoginOrRegisterPage;
import com.example.fabcaredrycleaners.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN=2500;

    Animation topAnimation;
    ImageView imagelogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation);

        imagelogo=findViewById(R.id.imageLogo);

        imagelogo.setAnimation(topAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginOrRegisterPage.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                finish();
            }
        },SPLASH_SCREEN);



    }
}
