package com.example.roicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class stock extends AppCompatActivity {
    public static final String EXTRA_NUMBER = "com.example.application.roicalc.EXTRA_NUMBER";
    public static final String EXTRA_NUMBER1 = "com.example.application.roicalc.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.application.roicalc.EXTRA_NUMBER2";
    public static final String EXTRA_NUMBER3 = "com.example.application.roicalc.EXTRA_NUMBER3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        Button button = (Button) findViewById(R.id.sbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openstockcalc();

            }
        });
    }
    public void openstockcalc(){
        EditText sbuy = (EditText) findViewById(R.id.sbuy);
        Double number = Double.parseDouble(sbuy.getText().toString());

        EditText ssell = (EditText) findViewById(R.id.ssell);
        Double number1 = Double.parseDouble(ssell.getText().toString());

        EditText sqnt = (EditText) findViewById(R.id.sqnt);
        int number2 = Integer.parseInt(sqnt.getText().toString());

        EditText smon  = (EditText) findViewById(R.id.smon);
        int number3 = Integer.parseInt(smon.getText().toString());
        Intent intent = new Intent(this,stockcalc.class);


        intent.putExtra(EXTRA_NUMBER,number);
        intent.putExtra(EXTRA_NUMBER1,number1);
        intent.putExtra(EXTRA_NUMBER2,number2);
        intent.putExtra(EXTRA_NUMBER3,number3);

        startActivity(intent);
    }
}