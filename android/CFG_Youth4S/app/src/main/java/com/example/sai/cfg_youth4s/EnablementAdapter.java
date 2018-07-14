package com.example.sai.cfg_youth4s;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.List;

/**
 * Created by sai on 14-07-2018.
 */
public class EnablementAdapter extends RecyclerView.Adapter<EnablementAdapter.MyViewHolder> {

    private FirebaseAuth firebaseAuth;
    Context context;
    private List<EventDetails> entries;
    private String userId,imageURL;

    public EnablementAdapter(Context context, List<EventDetails> TempList) throws IOException {

        this.entries = TempList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_eventdetails, parent, false);
        EnablementAdapter.MyViewHolder viewHolder = new EnablementAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        firebaseAuth = FirebaseAuth.getInstance();

        EventDetails eventDetails = entries.get(position);

        holder.text.setText(eventDetails.getEventname());
        holder.address.setText(eventDetails.getEventlocation());
        holder.date.setText(eventDetails.getEventdate());
        holder.time.setText(eventDetails.getEventtime());
        Glide.with(context).load(eventDetails.getImageurl()).into(holder.image);

        holder.cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

        public MyViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.tv_text);
            image=(ImageView)itemView.findViewById(R.id.iv_image);
            address=(TextView)itemView.findViewById(R.id.address);
            date=(TextView)itemView.findViewById(R.id.date);
            time=(TextView)itemView.findViewById(R.id.timings);
            cd=(CardView)itemView.findViewById(R.id.card_view);
            Typeface custom_font = Typeface.createFromAsset(context.getAssets(),"open.ttf");

            text.setTypeface(custom_font);
        }
    }
}