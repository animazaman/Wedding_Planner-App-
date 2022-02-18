package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mehendi_sangeet extends AppCompatActivity {

    private Button mehedi_songit_package1_button;
    private Button mehedi_songit_Package2_button;
    private Button mehedi_songit_Package3_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mehendi_sangeet);

        //setContentView(R.layout.activity_details_info);

        mehedi_songit_package1_button=(Button)findViewById(R.id.mehendi_pkg_1);
        mehedi_songit_package1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Mehendi_sangeet.this,Mehedi_Songit_Package1.class);
                startActivity(intent);
            }
        });
        mehedi_songit_Package2_button=(Button)findViewById(R.id.mehendi_pkg_2);
        mehedi_songit_Package2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Mehendi_sangeet.this,Mehedi_Songit_Package2.class);
                startActivity(intent);
            }
        });
        mehedi_songit_Package3_button=(Button)findViewById(R.id.mehendi_pkg_3);
        mehedi_songit_Package3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Mehendi_sangeet.this,Mehedi_Songit_Package3.class);
                startActivity(intent);
            }
        });
    }
}
