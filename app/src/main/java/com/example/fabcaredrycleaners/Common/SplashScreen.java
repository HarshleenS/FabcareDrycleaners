package com.example.fabcaredrycleaners.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.fabcaredrycleaners.Common.LoginSignup.LoginPage;
import com.example.fabcaredrycleaners.R;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN=2500;

    Animation topAnimation, bottomAnimation;
    ImageView imagelogo, imagenamelogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnimation=AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        imagelogo=findViewById(R.id.imageLogo);
        imagenamelogo=findViewById(R.id.imageLogoText);

        imagelogo.setAnimation(topAnimation);
        imagenamelogo.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginPage.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);



    }
}
