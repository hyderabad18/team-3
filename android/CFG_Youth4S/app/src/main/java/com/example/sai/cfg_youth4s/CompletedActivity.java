package com.example.sai.cfg_youth4s;

/**
 * Created by sai on 14-07-2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by sai on 14-07-2018.
 */
public class CompletedActivity extends AppCompatActivity {

    ListView lv;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<EventDetails> arrayList;
    ArrayList<EventDetails> NewarrayList = new ArrayList<>();
    CompletedAdapter arrayAdapter;
    EventDetails uploadInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "open.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        lv=(ListView)findViewById(R.id.listitem);

        firebaseAuth = FirebaseAuth.getInstance();

        String email = firebaseAuth.getCurrentUser().getEmail();
        email=email.replaceAll("[^\\w\\s]","");

        Toast.makeText(CompletedActivity.this,email, Toast.LENGTH_SHORT).show();

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Users").child(email).child("events");

        String userid = databaseReference.push().getKey();

        arrayList = new ArrayList<>();
        arrayAdapter = new CompletedAdapter(this,uploadInfo);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    uploadInfo = ds.getValue(EventDetails.class);
                    arrayList.add(new EventDetails(uploadInfo.getImageurl(),uploadInfo.getEventname(),uploadInfo.getEventlocation(),uploadInfo.getStartdate(),uploadInfo.getStarttime()));
                }
                if(arrayList.isEmpty())
                    startActivity(new Intent(CompletedActivity.this,MainActivity.class));
                for (EventDetails event : arrayList) {
                    boolean isFound = false;
                    // check if the event name exists in noRepeat
                    for (EventDetails e : NewarrayList) {
                        if ((e.getImageurl()).equals(event.getImageurl())) {
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound) NewarrayList.add(event);
                }

                arrayAdapter = new CompletedAdapter(getApplicationContext(),NewarrayList);
                lv.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}

