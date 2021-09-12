package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class fruitlist extends AppCompatActivity {

    ListView list;
    public Button button4;
    public ImageButton button7;
    public ImageButton button6;
    public ImageButton button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruitlist);

       list=(ListView)findViewById(R.id.list);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Kiwi");
        arrayList.add("Papaya");
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Kiwi");
        arrayList.add("Papaya");
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Kiwi");
        arrayList.add("Papaya");
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Kiwi");
        arrayList.add("Papaya");
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Kiwi");
        arrayList.add("Papaya");



        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1);

       list.setAdapter(arrayAdapter);

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fruitlist.this, Home.class);
                startActivity(intent);
            }




        });

        button7 = (ImageButton) findViewById(R.id.imageButton7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fruitlist.this, vegitablelist.class);
                startActivity(intent);
            }

        });

        button6 = (ImageButton) findViewById(R.id.imageButton6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fruitlist.this, sweets.class);
                startActivity(intent);
            }

        });

        button5 = (ImageButton) findViewById(R.id.imageButton5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fruitlist.this, bakery.class);
                startActivity(intent);
            }

        });
    }
}