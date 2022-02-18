package com.example.weddingplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class NewActivity extends AppCompatActivity {
    private TextView SignUP_text;
    private EditText txtEmail, txtPassword;
    private Button btn_login;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AlradyHaveUser();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        //text underline
        TextView textView = (TextView) findViewById(R.id.sign_up);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        //sign up to register

        SignUP_text = (TextView) findViewById(R.id.sign_up);
        SignUP_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewActivity.this, register.class);
                startActivity(intent);
                finish();
            }
        });


        txtEmail = (EditText) findViewById(R.id.user_name);
        txtPassword = (EditText) findViewById(R.id.password);
        btn_login = (Button) findViewById(R.id.login_btn);
        firebaseAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Email = txtEmail.getText().toString().trim();
                final String password = txtPassword.getText().toString().trim();


                if (TextUtils.isEmpty(Email)) {
                    Toast.makeText(NewActivity.this, "Please Enter Your Email.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(NewActivity.this, "Please Enter Your Password.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 5) {
                    Toast.makeText(NewActivity.this, "Password is too Short.", Toast.LENGTH_SHORT).show();
                }


                firebaseAuth.signInWithEmailAndPassword(Email, password)
                        .addOnCompleteListener(NewActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override

                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
// Write a message to the database
                                    FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    DatabaseReference myRef = database.getReference("User/" + mFirebaseAuth.getUid());

                                    //myRef.setValue("Hello, World!");
                                    // Read from the database
                                    myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            // This method is called once with the initial value and again
                                            // whenever data at this location is updated.
                                            //String value = dataSnapshot.getValue(String.class);
                                            Log.d("LOGIN_USER_DATA", "Value is: " + dataSnapshot.toString());
                                            Log.d("LOGIN_USER_DATA", "Value is: " + dataSnapshot.child("Email").getValue().toString());
                                            Log.d("LOGIN_USER_DATA", "Value is: " + dataSnapshot.child("name").getValue().toString());


                                            user.savedName = dataSnapshot.child("name").getValue().toString();
                                            startActivity(new Intent(getApplicationContext(), MainEvent.class));
                                            Toast.makeText(NewActivity.this, "Logged In Successfully.", Toast.LENGTH_SHORT).show();
                                            finish();
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError error) {
                                            // Failed to read value
                                            Log.w("LOGIN_USER_DATA", "Failed to read value.", error.toException());
                                        }
                                    });


                                } else {
                                    Toast.makeText(NewActivity.this, "Login Failed or User Not Available.", Toast.LENGTH_SHORT).show();

                                }


                            }
                        });


            }
        });


    }


    void AlradyHaveUser() {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {

            FirebaseAuth mFirebaseAuth = FirebaseAuth.getInstance();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("User/" + mFirebaseAuth.getUid());

            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    //String value = dataSnapshot.getValue(String.class);
                    Log.d("LOGIN_USER_DATA", "Value is: " + dataSnapshot.toString());
                    Log.d("LOGIN_USER_DATA", "Value is: " + dataSnapshot.child("Email").getValue().toString());
                    Log.d("LOGIN_USER_DATA", "Value is: " + dataSnapshot.child("name").getValue().toString());


                    user.savedName = dataSnapshot.child("name").getValue().toString();
                    startActivity(new Intent(getApplicationContext(), MainEvent.class));
                    Toast.makeText(NewActivity.this, "Logged In Successfully.", Toast.LENGTH_SHORT).show();
                    finish();


                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w("LOGIN_USER_DATA", "Failed to read value.", error.toException());
                }
            });

        }
    }


}