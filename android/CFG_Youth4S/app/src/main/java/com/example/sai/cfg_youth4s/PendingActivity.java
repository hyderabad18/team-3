package com.example.sai.cfg_youth4s;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by sai on 14-07-2018.
 */
public class PendingActivity extends AppCompatActivity{
    ListView lv;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<EventDetails> arrayList;
    ArrayList<EventDetails> NewarrayList = new ArrayList<>();
    PendingAdapter arrayAdapter;
    EventDetails uploadInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "open.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        lv=(ListView)findViewById(R.id.listitem);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Pending/");

        arrayList = new ArrayList<>();
        arrayAdapter = new PendingAdapter(this,uploadInfo);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    uploadInfo = ds.getValue(EventDetails.class);
                    arrayList.add(new EventDetails(uploadInfo.getImageurl(),uploadInfo.getEventname(),uploadInfo.getEventlocation(),uploadInfo.getEventdate(),uploadInfo.getEventtime()));
                }

                for (EventDetails event : arrayList) {
                    boolean isFound = false;
                    // check if the event name exists in noRepeat
                    for (EventDetails e : NewarrayList) {
                        if ((e.getImageurl().equals(event.getImageurl()))) {
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound) NewarrayList.add(event);
                }
                arrayAdapter = new PendingAdapter(getApplicationContext(),NewarrayList);
                lv.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
