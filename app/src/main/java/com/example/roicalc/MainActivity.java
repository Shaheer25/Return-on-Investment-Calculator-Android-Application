package com.example.roicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.SeekableByteChannel;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "com.example.application.roicalc.EXTRA_NUMBER";
    public static final String EXTRA_NUMBER1 = "com.example.application.roicalc.EXTRA_NUMBER1";
    public static final String EXTRA_NUMBER2 = "com.example.application.roicalc.EXTRA_NUMBER2";
    SeekBar sb;
    TextView tv1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (SeekBar) findViewById(R.id.seekBar);
        tv1 = (TextView) findViewById(R.id.years);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Button button = (Button) findViewById(R.id.btn_calc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openactivity2();

            }
        });
        Button button1 = (Button) findViewById(R.id.btn_stock);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstock();
            }
        });
        Button button2 = (Button) findViewById(R.id.btn_re);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openreal();
            }
        });


        }
        public void openactivity2(){
        EditText editText1 = (EditText) findViewById(R.id.amt_in);
        int number = Integer.parseInt(editText1.getText().toString());

        EditText editText2 = (EditText) findViewById(R.id.amt_ret);
        int number1 = Integer.parseInt(editText2.getText().toString());

        int number2 = Integer.parseInt(tv1.getText().toString());

        Intent intent = new Intent(this,calculate.class);

        intent.putExtra(EXTRA_NUMBER,number);
        intent.putExtra(EXTRA_NUMBER1,number1);
        intent.putExtra(EXTRA_NUMBER2,number2);

        startActivity(intent);

        }
        public void openstock(){
            Intent intent = new Intent(this,stock.class);
            startActivity(intent);
        }
        public void openreal(){
            Intent intent = new Intent(this,real.class);
            startActivity(intent);
        }

    }

