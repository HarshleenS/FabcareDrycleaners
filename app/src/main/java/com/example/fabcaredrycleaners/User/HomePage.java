 package com.example.fabcaredrycleaners.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabcaredrycleaners.Common.LoginSignup.LoginPage;
import com.example.fabcaredrycleaners.ImageSliderModel;
import com.example.fabcaredrycleaners.R;
import com.example.fabcaredrycleaners.imageSliderAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

 public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;

    Button buttonGoBack, placeOrder;

    TextView currentDate, kalDate;


    int timeHour, timeMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        imageSliderModelList = new ArrayList<>();
        sliderView = findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideimageone));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideimagetwo));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideimagethree));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideimagefour));

        sliderView.setSliderAdapter(new imageSliderAdapter(HomePage.this, imageSliderModelList));

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.action_home:
                        return true;

                    case R.id.action_rate:
                       startActivity(new Intent(getApplicationContext(), RateCard.class));
                       overridePendingTransition(0,0);
                       return true;

                    case R.id.action_chat:
                        startActivity(new Intent(getApplicationContext(), MyChat.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return true;


            }
        });

        currentDate=findViewById(R.id.currentDate);
        kalDate=findViewById(R.id.kalDate);


        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        currentDate.setText("Today :" + " " + dateTime );

        Calendar calendar2 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM");
        calendar2.add(Calendar.DAY_OF_YEAR, 1);
        String dateTime2 = simpleDateFormat2.format(calendar2.getTime());
        kalDate.setText("Tomorrow :" + " " + dateTime2);

        Calendar calendarTime = Calendar.getInstance();
        SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("kk:mm");
        String theTime = simpleDateFormatTime.format(calendarTime.getTime());
        String timeParse[] = theTime.split(":");
        timeHour = Integer.parseInt(timeParse[0]);
        timeMinute = Integer.parseInt(timeParse[1]);

        currentDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timeHour >= 19){
                    Toast.makeText(getApplicationContext(), "Cannot place order after 7pm", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent i = new Intent(HomePage.this, PlaceOrder.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        kalDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, PlaceOrder.class);
                startActivity(i);
                finish();
            }
        });

        buttonGoBack = findViewById(R.id.goBackToLogin);
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(i);
            }
        });

        placeOrder=findViewById(R.id.buttonPlaceOrder);



    }

    public void placeOrderTesting(View view){
        placeOrder.setBackgroundColor(000000);
    }

}
