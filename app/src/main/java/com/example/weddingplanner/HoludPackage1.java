package com.example.weddingplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HoludPackage1 extends AppCompatActivity {

    private Button Add_to_cart_process;
    private TextView Txt_total_amount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.row);

        Add_to_cart_process=(Button) findViewById(R.id.button_cart);
        Txt_total_amount=(TextView) findViewById(R.id.tprice);


    }
}
