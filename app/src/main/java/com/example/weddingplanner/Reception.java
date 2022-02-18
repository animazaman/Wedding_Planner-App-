package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reception extends AppCompatActivity {

    private Button reception_package1_button;
    private Button reception_package2_button;
    private Button reception_package3_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);

        reception_package1_button=(Button)findViewById(R.id.reception_pkg_1);
        reception_package1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Reception.this,ReceptionPackage1.class);
                startActivity(intent);
            }
        });
        reception_package2_button=(Button)findViewById(R.id.reception_pkg_2);
        reception_package2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Reception.this,ReceptionPackage2.class);
                startActivity(intent);
            }
        });
        reception_package3_button=(Button)findViewById(R.id.reception_pkg_3);
        reception_package3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Reception.this,ReceptionPackage3.class);
                startActivity(intent);
            }
        });
    }
}
