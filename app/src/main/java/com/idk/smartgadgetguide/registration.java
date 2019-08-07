package com.idk.smartgadgetguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registration extends AppCompatActivity {
    Button sub;
    EditText name,email,phno,pass;
    private user User;
    FirebaseDatabase database;
    String Name,Phno,Email;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);
        name=(EditText)findViewById(R.id.editText6);
        phno=(EditText)findViewById(R.id.editText8);
        email=(EditText)findViewById(R.id.editText5);
        pass=(EditText)findViewById(R.id.editText9);
        User=new user();
        database=FirebaseDatabase.getInstance();
        ref=FirebaseDatabase.getInstance().getReference().child("user");
        sub = findViewById(R.id.button);
        sub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(name.getText().toString().trim().length()==0||
                        email.getText().toString().trim().length()==0||
                        phno.getText().toString().trim().length()==0||
                        pass.getText().toString().trim().length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Enter All the Fields", Toast.LENGTH_SHORT).show();
                    return;

                }
                else if(phno.getText().toString().trim().length()!=10)
                {
                    Toast.makeText(getApplicationContext(), "Please Enter 10 Digit Mobile No", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    String user_email = email.getText().toString().trim();
                    String user_password = pass.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(registration.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent a = new Intent(registration.this, Login.class);
                                startActivity(a);
                                //sendUserData();
                            } else {
                                Toast.makeText(registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        });
                    clear();
                    return;
                }
            }
        });
    }
    public void clear()
    {
        name.setText("");
        email.setText("");
        phno.setText("");
        pass.setText("");
    }

    private void sendUserData(){
        Name = name.getText().toString();
        Email = email.getText().toString();
        Phno = phno.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        userprofile UserProfile = new userprofile(Phno, Email, Name);
        myRef.setValue(UserProfile);
    }
}