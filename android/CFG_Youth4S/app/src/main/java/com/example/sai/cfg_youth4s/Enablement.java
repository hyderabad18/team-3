package com.example.sai.cfg_youth4s;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * Created by sai on 14-07-2018.
 */
public class Enablement extends Fragment {
    private String Database_Path = "Events/Enablement/";

    DatabaseReference databaseReference;

    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter ;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    // Creating List of ImageUploadInfo class.
    List<EventDetails> list = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_card_view, container, false);

        // Assign id to RecyclerView.
        recyclerView = (RecyclerView) rootview.findViewById(R.id.rv_recycler_view);

        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);

        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(getActivity());

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading...");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        databaseReference = FirebaseDatabase.getInstance().getReference();

        DatabaseReference commandsRef = databaseReference.child("Events").child("Enablement");


        // Adding Add Value Event Listener to databaseReference.
        commandsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot)
            {
                list.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    EventDetails events = postSnapshot.getValue(EventDetails.class);

                    list.add(events);
                }

                reverse(list);
                try {
//                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//                    SharedPreferences.Editor editor = preferences.edit();
//                    editor.putString("Category",category);
//                    editor.commit();
                    adapter = new EnablementAdapter(getActivity(),list);

                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                recyclerView.setAdapter(adapter);

                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });
        return rootview;
    }
}
