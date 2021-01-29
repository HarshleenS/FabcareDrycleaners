package com.example.fabcaredrycleaners.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fabcaredrycleaners.R;

public class PlaceOrder extends AppCompatActivity {

    Button btn_go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        btn_go_back = findViewById(R.id.btn_back_from_placeorder);
        btn_go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HomePage.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
    }
}
