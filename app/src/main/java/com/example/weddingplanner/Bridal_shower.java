package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bridal_shower extends AppCompatActivity {

    private Button bs_Package1_button;
    private Button bs_Package2_button;
    private Button bs_Package3_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridal_shower);

        bs_Package1_button=(Button)findViewById(R.id.bridalshower_pkg_1);
        bs_Package1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bridal_shower.this,Bridal_Shower_Package1.class);
                startActivity(intent);
            }
        });
        bs_Package2_button=(Button)findViewById(R.id.bridalshower_pkg_2);
        bs_Package2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bridal_shower.this,Bridal_Shower_Package2.class);
                startActivity(intent);
            }
        });
        bs_Package3_button=(Button)findViewById(R.id.bridalshower_pkg_3);
        bs_Package3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Bridal_shower.this,Bridal_Shower_Package3.class);
                startActivity(intent);
            }
        });
    }
}
