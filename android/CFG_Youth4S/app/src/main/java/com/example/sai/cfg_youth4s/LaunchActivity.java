package com.example.sai.cfg_youth4s;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LaunchActivity extends AppCompatActivity {
    private Button signin,regiser;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText email,pwd;
    private DatabaseReference databaseReference,ref1;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "open.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null)
        {
            String user = firebaseAuth.getCurrentUser().getEmail();
            SharedPreferences preferences1 = PreferenceManager.getDefaultSharedPreferences(LaunchActivity.this);
            SharedPreferences.Editor editor = preferences1.edit();
            editor.putString("email",user);
            editor.commit();
            startActivity(new Intent(LaunchActivity.this, MainActivity.class));
        }

        signin = (Button)findViewById(R.id.sign_in_button);
        regiser = (Button)findViewById(R.id.sign_up_button);
        email = (EditText)findViewById(R.id.email);
        pwd = (EditText)findViewById(R.id.password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LaunchActivity.this,LoginActivity.class));
            }
        });

        regiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String ed1 = email.getText().toString().trim();
                final String password = pwd.getText().toString().trim();

                if (TextUtils.isEmpty(ed1)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(LaunchActivity.this,ed1, Toast.LENGTH_SHORT).show();

                //create user
                firebaseAuth.createUserWithEmailAndPassword(ed1, password)
                        .addOnCompleteListener(LaunchActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(LaunchActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(LaunchActivity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                                    Bundle b = new Bundle();
                                    b.putString("Username", ed1);
                                    intent.putExtras(b);
                                    firebaseDatabase = FirebaseDatabase.getInstance();
                                    databaseReference = firebaseDatabase.getReference();
                                    String parsed_email = ed1.replaceAll("[^\\w\\s]","");
                                    ref1 = FirebaseDatabase.getInstance().getReference().child("Users").child(parsed_email);
                                    FirebaseDatabase.getInstance().getReference().child("Users").child(parsed_email).
                                           addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            User users = dataSnapshot.getValue(User.class);

                                            User user1 = new User();
                                            ref1.child("name").setValue(user1.getName());
                                            ref1.child("dob").setValue(user1.getDob());
                                            ref1.child("gender").setValue(user1.getGender());
                                            ref1.child("location").setValue(user1.getLocation());
                                            ref1.child("hours").setValue(user1.getHours());
                                            ref1.child("events").setValue(user1.getEvent());
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {

                                        }
                                    });
                                    startActivity(intent);
                                }
                            }
                        });

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
