package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Holud extends AppCompatActivity {

    private Button holudPackage1_button;
    private Button holudPackage2_button;
    private Button holudPackage3_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holud);

        holudPackage1_button=(Button)findViewById(R.id.holud_pkg_1);
        holudPackage1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Holud.this,Listview.class);
                startActivity(intent);
            }
        });
        holudPackage2_button=(Button)findViewById(R.id.holud_pkg_2);
        holudPackage2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Holud.this,HoludPackage2.class);
                startActivity(intent);
            }
        });
        holudPackage3_button=(Button)findViewById(R.id.holud_pkg_3);
        holudPackage3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Holud.this,HoludPackage3.class);
                startActivity(intent);
            }
        });
    }
}
