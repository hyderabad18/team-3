package com.example.sai.cfg_youth4s;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;

/**
 * Created by sai on 14-07-2018.
 */
public class HealthyAdapter extends RecyclerView.Adapter<HealthyAdapter.MyViewHolder> {

    private FirebaseAuth firebaseAuth;
    public String Database_Path = "Users/";
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    Context context;
    private List<EventDetails> entries;
    private String userId,imageURL;

    public HealthyAdapter(Context context, List<EventDetails> TempList) throws IOException {

        this.entries = TempList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_eventdetails, parent, false);
        HealthyAdapter.MyViewHolder viewHolder = new HealthyAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        firebaseAuth = FirebaseAuth.getInstance();

        EventDetails eventDetails = entries.get(position);

        holder.text.setText(eventDetails.getEventname());
        holder.address.setText(eventDetails.getEventlocation());
        holder.date.setText(eventDetails.getStartdate());
        holder.time.setText(eventDetails.getStarttime());
        Glide.with(context).load(eventDetails.getImageurl()).into(holder.image);

        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.enroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = firebaseAuth.getCurrentUser().getEmail();
                key = key.replaceAll("[^\\w\\s]","");
                mFirebaseInstance = FirebaseDatabase.getInstance();
                // get reference to 'users' node
                mFirebaseDatabase = mFirebaseInstance.getReference(Database_Path).child(key).child("pending");

                userId = mFirebaseDatabase.push().getKey();

                FirebaseDatabase.getInstance().getReference().child("Events").child("Enablement")
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                    EventDetails user = snapshot.getValue(EventDetails.class);

                                    if (holder.text.getText() == user.getEventname())
                                    {
                                        imageURL = user.getImageurl();

                                        EventDetails details = new EventDetails(imageURL,holder.text.getText().toString(),holder.address.getText().toString(),holder.date.getText().toString(),holder.time.getText().toString());

                                        mFirebaseDatabase.child(userId).child("imageurl").setValue(details.getImageurl());
                                        mFirebaseDatabase.child(userId).child("eventname").setValue(details.getEventname());
                                        mFirebaseDatabase.child(userId).child("location").setValue(details.getEventlocation());
                                        mFirebaseDatabase.child(userId).child("date").setValue(details.getStartdate());
                                        mFirebaseDatabase.child(userId).child("time").setValue(details.getStarttime());

//                                            holder.cd.setVisibility(View.GONE);

                                        addUserChangeListener();

                                    }
                                }
                                //do what you want with the email
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

            }
        });
    }

    private void addUserChangeListener()
    {
        // User data change listener
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                EventDetails details = dataSnapshot.getValue(EventDetails.class);

                // Check for null
                if (details == null) {
                    Toast.makeText(context, "Data is Null..", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(context, "Enrolled Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(context,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {

        return entries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView text,address,date,time;
        ImageView image;
        ImageView imageview,wishlist,delete;
        CardView cd;
        Button enroll;

        public MyViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.tv_text);
            image=(ImageView)itemView.findViewById(R.id.iv_image);
            address=(TextView)itemView.findViewById(R.id.address);
            date=(TextView)itemView.findViewById(R.id.date);
            time=(TextView)itemView.findViewById(R.id.timings);
            cd=(CardView)itemView.findViewById(R.id.card_view);
            enroll=(Button)itemView.findViewById(R.id.enroll);
            Typeface custom_font = Typeface.createFromAsset(context.getAssets(),"open.ttf");

            text.setTypeface(custom_font);
        }
    }
}