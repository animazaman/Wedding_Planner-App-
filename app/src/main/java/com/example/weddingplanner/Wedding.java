package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Wedding extends AppCompatActivity {

    private Button wedding_package1_button;
    private Button wedding_package2_button;
    private Button wedding_package3_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding);

        wedding_package1_button=(Button)findViewById(R.id.wedding_pkg_1);
        wedding_package1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Wedding.this,WeddingPackage1.class);
                startActivity(intent);
            }
        });
        wedding_package2_button=(Button)findViewById(R.id.wedding_pkg_2);
        wedding_package2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Wedding.this,WeddingPackage2.class);
                startActivity(intent);
            }
        });
        wedding_package3_button=(Button)findViewById(R.id.wedding_pkg_3);
        wedding_package3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Wedding.this,WeddingPackage3.class);
                startActivity(intent);
            }
        });
    }
}
