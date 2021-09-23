package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class sweets extends AppCompatActivity {

    private Button button34;
    private ImageButton button37;
    private ImageButton button36;
    private ImageButton button35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweets);

        button34 = (Button) findViewById(R.id.button34);
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sweets.this, Home.class);
                startActivity(intent);
            }

        });



        button36 = (ImageButton) findViewById(R.id.imageButton36);
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sweets.this, vegitablelist.class);
                startActivity(intent);
            }



        });

        button35 = (ImageButton) findViewById(R.id.imageButton15);
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sweets.this, bakery.class);
                startActivity(intent);
            }

        });


    }
}