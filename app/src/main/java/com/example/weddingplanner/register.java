package com.example.weddingplanner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    private Button sign_up_button;
    private EditText txtName, txtEmail, txtPassword, txtConfirmPassword;
    //authenticatin for database
    FirebaseAuth firebaseAuth;
    //realtime database
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        sign_up_button=(Button)findViewById(R.id.signup_btn);
        txtName = (EditText)findViewById(R.id.name_field);
        txtEmail = (EditText)findViewById(R.id.email_field);
        txtPassword = (EditText)findViewById(R.id.password_field);
        txtConfirmPassword = (EditText)findViewById(R.id.retype_pass_field);
        //authentication dor database
        firebaseAuth = FirebaseAuth.getInstance();
        ////realtime database
        databaseReference = FirebaseDatabase.getInstance().getReference("User");


        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                final String name = txtName.getText().toString().trim();
                final String Email = txtEmail.getText().toString().trim();
                final String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtPassword.getText().toString().trim();


                if(TextUtils.isEmpty(name)){
                    Toast.makeText(register.this, "Please Enter Your Name.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(register.this, "Please Enter Your Email.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(register.this, "Please Enter Your Password.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(register.this, "Please Confirm Your Password Again.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length()<5)
                {
                    Toast.makeText(register.this, "Password is too Short.", Toast.LENGTH_SHORT).show();
                }
                if (password.equals(confirmPassword))
                {
                    user.savedName = name;
                    user.savedEmail = Email;
                    user.savedPassword = password;
                    firebaseAuth.createUserWithEmailAndPassword(Email, password)
                            .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        user information = new user(name,Email,password);

                                        FirebaseDatabase.getInstance().getReference("User")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task)
                                            {
                                                Toast.makeText(register.this, "Registration Complete Successfully.", Toast.LENGTH_SHORT).show();
                                                firebaseAuth.signOut();
                                                startActivity( new Intent(getApplicationContext(),NewActivity.class));
                                                finish();

                                            }
                                        });


                                    }
                                    else {
                                        Toast.makeText(register.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });


                }

            }
        });





    }
}
