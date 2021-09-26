package com.example.foodmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodmart.Models.DriverDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddDriver extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    Button button;
    DatabaseReference ref;
    Integer bonus = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);

        ref = FirebaseDatabase.getInstance().getReference("DriverDetails");

        editText1 = (EditText)findViewById(R.id.Did);
        editText2 = (EditText)findViewById(R.id.Dname);
        editText3 = (EditText)findViewById(R.id.Dcontact);
        editText4 = (EditText)findViewById(R.id.Dnic);
        editText5 = (EditText)findViewById(R.id.Daddress);
        editText6 = (EditText)findViewById(R.id.Dsalary);
        button = (Button)findViewById(R.id.addbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String id = editText1.getText().toString();
                final String name = editText2.getText().toString();
                final String contact = editText3.getText().toString();
                final String nic = editText4.getText().toString();
                final String address = editText5.getText().toString();
                final String salary = editText6.getText().toString();

                if (id.isEmpty()) {
                    editText1.setError("Driver ID is required");
                }else if (name.isEmpty()) {
                    editText2.setError("Driver Name is required");
                }else if (contact.isEmpty()) {
                    editText3.setError("Driver Contact Number is required");
                }else if (nic.isEmpty()) {
                    editText4.setError("Driver nic is required");
                } else if (address.isEmpty()) {
                    editText5.setError("Driver address is required");
                } else if (salary.isEmpty()) {
                    editText6.setError("Driver Salary is required");
                }else {

                    Integer itemprice = Integer.valueOf(editText6.getText().toString());
                    String total = String.valueOf(itemprice + bonus);

                    DriverDetails driverDetails = new DriverDetails(id,name,contact,nic,address,total);
                    ref.child(id).setValue(driverDetails);

                    Toast.makeText(AddDriver.this, "Successfully added", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(AddDriver.this, ManageEmployeee.class);
                    startActivity(intent);
                }
            }
        });
    }
}