package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class bakery extends AppCompatActivity {

    private Button button24;
    public ImageButton button27;
    public ImageButton button26;
    public ImageButton button25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery);

        button24 = (Button) findViewById(R.id.button24);
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bakery.this, Home.class);
                startActivity(intent);
            }




        });

        button27 = (ImageButton) findViewById(R.id.imageButton27);
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bakery.this, vegitablelist.class);
                startActivity(intent);
            }

        });

        button26 = (ImageButton) findViewById(R.id.imageButton26);
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bakery.this, sweets.class);
                startActivity(intent);
            }

        });

        button25 = (ImageButton) findViewById(R.id.imageButton25);
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bakery.this, fruitlist.class);
                startActivity(intent);
            }

        });
    }
}