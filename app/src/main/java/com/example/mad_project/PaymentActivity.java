package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class PaymentActivity extends AppCompatActivity {
    EditText txtName,txtDate, txtTime,txtContact,txtMobile,txtComments;
    Button btnSub;

    DatabaseReference db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_activitty);

        txtName = findViewById(R.id.name);
        txtDate = findViewById(R.id.date);
        txtContact = findViewById(R.id.contact);
        txtTime = findViewById(R.id.time);
        txtComments=findViewById(R.id.comments);
        btnSub = findViewById(R.id.submitBtn);

        db = FirebaseDatabase.getInstance().getReference().child("Customer");

       btnSub.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {



           }
       });

    }


}