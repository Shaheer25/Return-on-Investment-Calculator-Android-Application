package com.example.roicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class calculate extends AppCompatActivity {
    TextView npl,amt_in1,amt_ret1,per,cagr,years1,cagr1,cagr2,cagr3,textView3,textView5,textView8,textView17;

    Double in,ret,perc,diff,ca,year,a,b,pro,yrs1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        Intent intent = getIntent();
       int number = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);
       int number1 = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
       int number2 = intent.getIntExtra(MainActivity.EXTRA_NUMBER2,0);

        TextView amt_in1 =(TextView) findViewById(R.id.amt_in1);
        TextView amt_ret1 = (TextView) findViewById(R.id.amt_ret1);
        TextView years1 = (TextView) findViewById(R.id.years1);

       amt_in1.setText("" + number);
       amt_ret1.setText("" + number1);
       years1.setText("" + number2);

        npl = findViewById(R.id.npl);
        per = findViewById(R.id.per);
        cagr = findViewById(R.id.cagr);
        cagr1 = findViewById(R.id.cagr1);
        cagr2 = findViewById(R.id.cagr2);
        cagr3 = findViewById(R.id.cagr3);
        textView5 = findViewById(R.id.textView5);
        textView3 =findViewById(R.id.textView3);
        textView17 =findViewById(R.id.textView17);
        textView8 =findViewById(R.id.textView8);
        amt_in1 = findViewById(R.id.amt_in1);
        amt_ret1 = findViewById(R.id.amt_ret1);
        years1 = findViewById(R.id.years1);

        in=Double.parseDouble(amt_in1.getText().toString());
        ret=Double.parseDouble(amt_ret1.getText().toString());
        year=Double.parseDouble(years1.getText().toString());



        diff = ret - in;
        if (diff >= 0) {
            textView5.setTextColor(Color.parseColor("#039217"));
            textView5.setText("Net Profit");
            npl.setTextColor(Color.parseColor("#039217"));
            npl.setText(String.valueOf(diff));
        }
        else{
            textView5.setTextColor(Color.RED);
            textView5.setText("Net Loss");
            npl.setTextColor(Color.RED);
            npl.setText(String.valueOf(diff));
        }
        perc = (diff/in)*100;
        if (perc>=0) {
            textView3.setTextColor(Color.parseColor("#039217"));
            textView3.setText("Profit Percentage");
            per.setTextColor(Color.parseColor("#039217"));
            per.setText(String.valueOf(String.format("%.2f", perc) + "%"));
        }
        else{
            textView3.setTextColor(Color.RED);
            textView3.setText("Loss Percentage");
            per.setTextColor(Color.RED);
            per.setText(String.valueOf(String.format("%.2f", perc) + "%"));
        }
        a=1/year;
        b=ret/in;
        ca = ((Math.pow(b,a))-1)*100;
        if( ca >= 0 ) {
            textView8.setTextColor(Color.parseColor("#039217"));
            cagr.setTextColor(Color.parseColor("#039217"));
            cagr.setText(String.valueOf(String.format("%.3f", ca) + "%"));
        }
        else{
            textView8.setTextColor(Color.RED);
            cagr.setTextColor(Color.RED);
            cagr.setText(String.valueOf(String.format("%.3f", ca) + "%"));
        }
        pro = ((ret*ca)/100);

        if(pro>=0) {
            cagr1.setText(String.valueOf("With the "+String.format("%.3f",ca)+"% CAGR The Profits In next One year"));
            cagr1.setTextColor(Color.parseColor("#039217"));
            cagr2.setTextColor(Color.parseColor("#039217"));
            cagr2.setText(String.valueOf(String.format("%.4f", pro)));
        }
        else{
            cagr1.setText(String.valueOf("With the "+String.format("%.3f",ca)+"% CAGR The Loss In next One year"));
            cagr1.setTextColor(Color.RED);
            cagr2.setTextColor(Color.RED);
            cagr2.setText(String.valueOf(String.format("%.4f", pro)));
        }
        yrs1 = pro + ret;
        if(pro >= 0) {
            textView17.setTextColor(Color.parseColor("#039217"));
            cagr3.setTextColor(Color.parseColor("#039217"));
            cagr3.setText(String.valueOf(String.format("%.4f",yrs1 )));
        }
        else{
            textView17.setTextColor(Color.RED);
            cagr3.setTextColor(Color.RED);
            cagr3.setText(String.valueOf(String.format("%.4f", yrs1)));
        }

    }

}