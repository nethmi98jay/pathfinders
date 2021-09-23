package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class vegitablelist extends AppCompatActivity {

    private Button button14;
    private ImageButton button17;
    private ImageButton button16;
    private ImageButton button15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegitablelist);


        button14 = (Button) findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vegitablelist.this, Home.class);
                startActivity(intent);
            }




        });



        button16 = (ImageButton) findViewById(R.id.imageButton16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vegitablelist.this, sweets.class);
                startActivity(intent);
            }



        });

        button15 = (ImageButton) findViewById(R.id.imageButton15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vegitablelist.this, sweets.class);
                startActivity(intent);
            }



        });


    }
}