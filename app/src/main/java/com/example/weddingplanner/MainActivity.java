package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //timer start

        timer =new Timer();
        timer.schedule (new TimerTask() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this,  NewActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}
