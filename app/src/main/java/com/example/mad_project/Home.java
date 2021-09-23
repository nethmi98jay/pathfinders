package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

GridView gridView;

    public ImageButton store;
    public ImageButton cart1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        cart1 = (ImageButton) findViewById(R.id.cart1);
        cart1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Fragment_my_cart.class);
                startActivity(intent);
            }

        });


        store = (ImageButton) findViewById(R.id.store);
        store.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, Items.class);
                startActivity(intent);
            }

        });



    }
}