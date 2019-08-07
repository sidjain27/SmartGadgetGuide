package com.idk.smartgadgetguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reg,login;
    boolean mPressedOnce=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg=findViewById(R.id.button1);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,registration.class));
            }
        });
        login=findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        if(mPressedOnce)
        {
            super.onBackPressed();
        }
        this.mPressedOnce=true;

        Toast.makeText(this,"Press again to ex it",Toast.LENGTH_SHORT).show();
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPressedOnce=false;
            }
        }, 2000);
    }
}