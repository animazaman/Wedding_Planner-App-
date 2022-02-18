package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Akdh extends AppCompatActivity {

    private Button akdhPackage1_button;
    private Button akdhPackage2_button;
    private Button akdhPackage3_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akdh);

        akdhPackage1_button=(Button)findViewById(R.id.akdh_pkg_1);
        akdhPackage1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Akdh.this,AkdhPackage1.class);
                startActivity(intent);
            }
        });
        akdhPackage2_button=(Button)findViewById(R.id.akdh_pkg_2);
        akdhPackage2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Akdh.this,AkdhPackage2.class);
                startActivity(intent);
            }
        });
        akdhPackage3_button=(Button)findViewById(R.id.akdh_pkg_3);
        akdhPackage3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Akdh.this,AkdhPackage3.class);
                startActivity(intent);
            }
        });
    }
}
