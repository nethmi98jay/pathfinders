package com.example.foodmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodmart.Models.EmployeeDetails;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManageEmployeee extends AppCompatActivity {

    Button button;
    ListView listView;
    List<EmployeeDetails> user;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_employeee);

        button = (Button)findViewById(R.id.addDriver);
        listView = (ListView)findViewById(R.id.listview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageEmployeee.this, AddDriver.class);
                startActivity(intent);
            }
        });

        user = new ArrayList<>();

        ref = FirebaseDatabase.getInstance().getReference("DriverDetails");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user.clear();

                for (DataSnapshot studentDatasnap : dataSnapshot.getChildren()) {

                    EmployeeDetails employeeDetails = studentDatasnap.getValue(EmployeeDetails.class);
                    user.add(employeeDetails);
                }

                MyAdapter adapter = new MyAdapter(ManageEmployeee.this, R.layout.custom_driver_details, (ArrayList<EmployeeDetails>) user);
                listView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    static class ViewHolder {

        TextView COL1;
        TextView COL2;
        TextView COL3;
        TextView COL4;
        Button button1;
        Button button2;
    }

    class MyAdapter extends ArrayAdapter<EmployeeDetails> {
        LayoutInflater inflater;
        Context myContext;
        List<EmployeeDetails> user;


        public MyAdapter(Context context, int resource, ArrayList<EmployeeDetails> objects) {
            super(context, resource, objects);
            myContext = context;
            user = objects;
            inflater = LayoutInflater.from(context);
            int y;
            String barcode;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                holder = new ViewHolder();
                view = inflater.inflate(R.layout.custom_driver_details, null);

                holder.COL1 = (TextView) view.findViewById(R.id.Driverid);
                holder.COL2 = (TextView) view.findViewById(R.id.DriverName);
                holder.COL3 = (TextView) view.findViewById(R.id.Drivercontact);
                holder.COL4 = (TextView) view.findViewById(R.id.DriverPosition);
                holder.button1 = (Button) view.findViewById(R.id.Drivereedit);
                holder.button2 = (Button) view.findViewById(R.id.Driverdelete);


                view.setTag(holder);
            } else {

                holder = (ViewHolder) view.getTag();
            }

            holder.COL1.setText("Code:- "+user.get(position).getId());
            holder.COL2.setText("Name:- "+user.get(position).getName());
            holder.COL3.setText("Contact:- "+user.get(position).getContact());
            holder.COL4.setText("ID NO:- "+user.get(position).getId());
            System.out.println(holder);

            holder.button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                            .setTitle("Do you want to delete this item?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    final String idd = user.get(position).getId();
                                    FirebaseDatabase.getInstance().getReference("DriverDetails").child(idd).removeValue();
                                    //remove function not written
                                    Toast.makeText(myContext, "Employee deleted successfully", Toast.LENGTH_SHORT).show();

                                }
                            })

                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            })
                            .show();
                }
            });

            holder.button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
                    View view1 = inflater.inflate(R.layout.custom_update_driver_details, null);
                    dialogBuilder.setView(view1);

                    final EditText editText1 = (EditText) view1.findViewById(R.id.upEid);
                    final EditText editText2 = (EditText) view1.findViewById(R.id.upEname);
                    final EditText editText3 = (EditText) view1.findViewById(R.id.upEcontact);
                    final EditText editText4 = (EditText) view1.findViewById(R.id.upEnic);
                    final EditText editText5 = (EditText) view1.findViewById(R.id.upEaddress);
                    final EditText editText6 = (EditText) view1.findViewById(R.id.upEsalary);
                    final Button buttonupdate = (Button) view1.findViewById(R.id.upupdatebtn);

                    final AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.show();

                    final String idd = user.get(position).getId();
                    final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("DriverDetails").child(idd);
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String id = (String) snapshot.child("id").getValue();
                            String name = (String) snapshot.child("name").getValue();
                            String contact = (String) snapshot.child("contact").getValue();
                            String nic = (String) snapshot.child("nic").getValue();
                            String address = (String) snapshot.child("address").getValue();
                            String salary = (String) snapshot.child("salary").getValue();

                            editText1.setText(id);
                            editText2.setText(name);
                            editText3.setText(contact);
                            editText4.setText(nic);
                            editText5.setText(address);
                            editText6.setText(salary);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                    buttonupdate.setOnClickListener(new View.OnClickListener() {
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

                                HashMap map = new HashMap();
                                map.put("name", name);
                                map.put("contact", contact);
                                map.put("nic", nic);
                                map.put("address", address);
                                map.put("salary", salary);
                                reference.updateChildren(map);

                                Toast.makeText(ManageEmployeee.this, "Updated successfully", Toast.LENGTH_SHORT).show();

                                alertDialog.dismiss();
                            }
                        }
                    });
                }
            });

            return view;

        }
    }
}
