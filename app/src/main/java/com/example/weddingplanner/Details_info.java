package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Details_info extends AppCompatActivity {

    private Button confirm_btn;
    private EditText bname, gname, bnid, gnid, bphn, gphn;
    //realtime database
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //setSupportActionBar(toolbar);

        confirm_btn = (Button) findViewById(R.id.confirm_btn);
        bname = (EditText) findViewById(R.id.bname_field);
        gname = (EditText) findViewById(R.id.gname_field);
        bnid = (EditText) findViewById(R.id.bnid_field);
        gnid = (EditText) findViewById(R.id.bnid_field);
        bphn = (EditText) findViewById(R.id.bno_field);
        gphn = (EditText) findViewById(R.id.gno_field);


        databaseReference = FirebaseDatabase.getInstance().getReference("Details Information");


        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final String name = bname.getText().toString().trim();
                final String name1 = gname.getText().toString().trim();
                String nid = bnid.getText().toString().trim();
                String nid1 = gnid.getText().toString().trim();
                String phn = bphn.getText().toString().trim();
                String phn1 = gphn.getText().toString().trim();

                if(TextUtils.isEmpty(name)){
                    Toast.makeText(Details_info.this, "Please Enter Bride Name.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(name1)){
                    Toast.makeText(Details_info.this, "Please Enter Groom Name.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(nid)){
                    Toast.makeText(Details_info.this, "Please Enter Bride NID.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(nid1)){
                    Toast.makeText(Details_info.this, "Please Enter Groom NID.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phn)){
                    Toast.makeText(Details_info.this, "Please Enter Bride Phone No.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phn1)){
                    Toast.makeText(Details_info.this, "Please Enter Groom Phone No.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(nid.length()<10)
                {
                    Toast.makeText(Details_info.this, "NID is too Short.", Toast.LENGTH_SHORT).show();
                }
                if(nid.length()<10)
                {
                    Toast.makeText(Details_info.this, "NID is too Short.", Toast.LENGTH_SHORT).show();
                }
                if(phn.length()<11)
                {
                    Toast.makeText(Details_info.this, "Phone No is too Short.", Toast.LENGTH_SHORT).show();
                }
                if(phn1.length()<11)
                {
                    Toast.makeText(Details_info.this, "Phone No is too Short.", Toast.LENGTH_SHORT).show();
                }


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("DETAILS_INFO/"+ FirebaseAuth.getInstance().getUid()+"/");
                Map<String, String> cart = new HashMap<>();
                cart.put("Bride_Name", name);
                cart.put("Groom_Name", name1);
                cart.put("Bride_NID", nid);
                cart.put("Groom_NID", nid1);
                cart.put("Bride_Phone", phn);
                cart.put("Groom_Phone", phn1);
                myRef.setValue(cart);

                Intent intent =new Intent(getApplicationContext(),  Congratulation.class);
                startActivity(intent);
                finish();

            }

        });



    }
}
