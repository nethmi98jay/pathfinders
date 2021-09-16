package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Fragment_my_cart extends AppCompatActivity {
    public AppCompatButton placeorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_my_cart);

        placeorder = (AppCompatButton) findViewById(R.id.placeorder);
        placeorder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fragment_my_cart.this, PaymentActivitty.class);
                startActivity(intent);
            }

        });
    }
}