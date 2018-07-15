package com.example.sai.cfg_youth4s;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.Glide.clear;


/**
 * Created by sai on 14-07-2018.
 */
public class CompletedAdapter extends BaseAdapter{
    private Context context;
    private List<EventDetails> imageUploadInfos;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    public CompletedAdapter(Context context, ArrayList<EventDetails> words) {
        this.context=context;
        this.imageUploadInfos=words;
    }


    @Override
    public int getCount() {
        return imageUploadInfos.size();
    }

    @Override
    public Object getItem(int i) {
        return imageUploadInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        final View listitem = View.inflate(context, R.layout.completed_events, null);

        firebaseAuth = FirebaseAuth.getInstance();

        String email = firebaseAuth.getCurrentUser().getEmail();
        email = email.replaceAll("[^\\w\\s]","");

        clear(listitem);

        FirebaseDatabase.getInstance().getReference().child("Users").child(email).child("events").orderByChild("status").equalTo("2").
                addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            EventDetails user = snapshot.getValue(EventDetails.class);

                            ImageView img = (ImageView)listitem.findViewById(R.id.iv_image);
                            Glide.with(context).load(imageUploadInfos.get(position).getImageurl()).into(img);

                            TextView txt = (TextView) listitem.findViewById(R.id.tv_text);
                            txt.setText(imageUploadInfos.get(position).getEventname());

                            TextView txt1 = (TextView) listitem.findViewById(R.id.address);
                            txt1.setText(imageUploadInfos.get(position).getEventlocation());

                            TextView txt2 = (TextView) listitem.findViewById(R.id.date);
                            txt2.setText(imageUploadInfos.get(position).getEventlocation());

                            TextView txt3 = (TextView) listitem.findViewById(R.id.timings);
                            txt3.setText(imageUploadInfos.get(position).getEventlocation());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
        return listitem;
    }
}
