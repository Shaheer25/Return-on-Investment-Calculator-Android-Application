package com.example.roicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class real extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.application.roicalc.EXTRA_NUMBER";
    public static final String EXTRA_NUMBER1 = "com.example.application.roicalc.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.application.roicalc.EXTRA_NUMBER2";
    public static final String EXTRA_NUMBER3 = "com.example.application.roicalc.EXTRA_NUMBER3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        Button button = (Button) findViewById(R.id.rebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openrealcalc();

            }
        });
    }
    public void openrealcalc(){

        EditText reyar = (EditText) findViewById(R.id.reyar);
        int number =Integer.parseInt(reyar.getText().toString());

        EditText rebuy = (EditText) findViewById(R.id.rebuy);
        Double number1 = Double.parseDouble(rebuy.getText().toString());

        EditText resell = (EditText) findViewById(R.id.resell);
        Double number2 = Double.parseDouble(resell.getText().toString());

        EditText reyears  = (EditText) findViewById(R.id.reyears);
        int number3 = Integer.parseInt(reyears.getText().toString());

        Intent intent = new Intent(this,realcalc.class);

        intent.putExtra(EXTRA_NUMBER,number);
        intent.putExtra(EXTRA_NUMBER1,number1);
        intent.putExtra(EXTRA_NUMBER2,number2);
        intent.putExtra(EXTRA_NUMBER3,number3);

        startActivity(intent);
    }
}