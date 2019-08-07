package com.idk.smartgadgetguide;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity {
    ImageView sm,tb;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sm=(ImageView) findViewById(R.id.imageView);
        tb=(ImageView) findViewById(R.id.imageView3);
        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, smartphone.class));
            }
        });
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this, tablet.class));
            }
        });
        firebaseAuth=FirebaseAuth.getInstance();
    }
            private void Logout(){
                firebaseAuth.signOut();
                finish();
                Toast.makeText(home.this, "Succesfully Logged Out!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(home.this, MainActivity.class));
            }

            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {

                switch(item.getItemId()){
                    case R.id.logoutMenu:{
                        scan g=new scan();
                        g.execute();
                        Logout();
                        break;
                    }
                }
                return super.onOptionsItemSelected(item);
            }

    public class scan extends AsyncTask<String, String, String> {

        private ProgressDialog pd;

        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(home.this);
            pd.setTitle("Please Wait");
            pd.setMessage("Logging Out!!");
            pd.setMax(10);
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            return null;
        }
    }
        }