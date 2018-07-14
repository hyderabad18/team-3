package com.example.sai.cfg_youth4s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button create,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FontChangeCrawler fontChanger = new FontChangeCrawler(getAssets(), "open.ttf");
        fontChanger.replaceFonts((ViewGroup)this.findViewById(android.R.id.content));

        create = (Button)findViewById(R.id.sign_up_button);
        reset = (Button)findViewById(R.id.btn_reset_password);


    }
}
