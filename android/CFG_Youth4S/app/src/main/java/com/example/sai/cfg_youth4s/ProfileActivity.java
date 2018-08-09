package com.example.sai.cfg_youth4s;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by sai on 15-07-2018.
 */
public class ProfileActivity extends AppCompatActivity {

    private TextView name,dob,gender,location,hrs;
    private Button update;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;
    String key;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView)findViewById(R.id.name);
        dob = (TextView) findViewById(R.id.dob);
        gender = (TextView) findViewById(R.id.gender);
        location = (TextView) findViewById(R.id.loc);
        hrs = (TextView) findViewById(R.id.hrs);

        update = (Button)findViewById(R.id.update);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();

        String email = firebaseAuth.getCurrentUser().getEmail();
        email=email.replaceAll("[^\\w\\s]","");

        databaseReference = firebaseDatabase.getReference("Users").child(email);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //Map<String, User> map = (Map<String, User>) dataSnapshot.getValue();
                    name.setText("hi");
                    dob.setText("hi");
                    gender.setText("hi");
                    location.setText("hi");
                    hrs.setText("hi");
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfileActivity.this);

                View promptsView = getLayoutInflater().inflate(R.layout.dialog_edit_details, null);

                final EditText name = (EditText) promptsView
                        .findViewById(R.id.Name);
                final EditText DOB = (EditText) promptsView.findViewById(R.id.dob);

                final EditText gender = (EditText) promptsView.findViewById(R.id.gender);
                final EditText location = (EditText) promptsView.findViewById(R.id.location);
                final EditText hrs = (EditText) promptsView.findViewById(R.id.hrs);

                // set dialog message
                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        firebaseDatabase = FirebaseDatabase.getInstance();

                        String email = firebaseAuth.getCurrentUser().getEmail();
                        email=email.replaceAll("[^\\w\\s]","");

                        databaseReference = firebaseDatabase.getReference("Users").child(email);

                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                databaseReference.child("name").setValue(name.getText().toString());
                                databaseReference.child("dob").setValue(DOB.getText().toString());
                                databaseReference.child("gender").setValue(gender.getText().toString());
                                databaseReference.child("location").setValue(location.getText().toString());
                                databaseReference.child("hrs").setValue(hrs.getText().toString());
                                startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));

                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
                    }
                })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertDialogBuilder.setView(promptsView);
                AlertDialog dialog = alertDialogBuilder.create();
                dialog.show();
//                dialog.getWindow().setLayout(700, 600);
            }
        });

    }

}
