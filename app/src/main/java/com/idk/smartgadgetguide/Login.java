package com.idk.smartgadgetguide;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText em,pas;
    private ProgressDialog progressDialog;
    Button Log;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        em = (EditText) findViewById(R.id.editText15);
        pas= (EditText) findViewById(R.id.editText16);
        Log=(Button) findViewById(R.id.button2);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            finish();
            startActivity(new Intent(Login.this, home.class));
        }
        Log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (em.getText().toString().equals("") || pas.getText().toString().equals("")) {
                    Toast.makeText(Login.this, "Please enter the fields..!", Toast.LENGTH_LONG).show();
                }
                else{
                    validate(em.getText().toString(), pas.getText().toString());
                }
            }
        });
    }
    private void validate(String userName, String userPassword) {



        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    scan g=new scan();
                    g.execute();
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(Login.this, home.class));
                }else{
                    Toast.makeText(Login.this, "Login Failed! Please Check Email & Password!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    public class scan extends AsyncTask<String, String, String> {

        private ProgressDialog pd;

        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(Login.this);
            pd.setTitle("Please Wait");
            pd.setMessage("Checking Credentials!!");
            pd.setMax(10);
            pd.show();
        }

        @Override
        protected String doInBackground(String... params) {
            // TODO Auto-generated method stub
            return null;
        }
    }

    public void clear()
    {
        em.setText("");
        pas.setText("");
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Intent i=new Intent(Login.this,MainActivity.class);
        startActivity(i);
    }
}