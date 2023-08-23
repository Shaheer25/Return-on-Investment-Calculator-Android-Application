package com.example.roicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class realcalc extends AppCompatActivity {
    TextView rediff,reper,recagr,textView29,textView30,textView31,rebtot,rectot;
    Double in,ret,year,qnt,net,perc,cmgr,a,b,ca,buytot,curtot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realcalc);

        Intent intent = getIntent();
        int number = intent.getIntExtra(stock.EXTRA_NUMBER, 0);
        Double number1 = intent.getDoubleExtra(stock.EXTRA_NUMBER1, 0);
        Double number2 = intent.getDoubleExtra(stock.EXTRA_NUMBER2,0);
        int number3 = intent.getIntExtra(stock.EXTRA_NUMBER3,0);

        TextView rein = (TextView) findViewById(R.id.rein);
        TextView reret = (TextView) findViewById(R.id.reret);
        TextView reqnt = (TextView) findViewById(R.id.reqnt);
        TextView reyrs = (TextView) findViewById(R.id.reyrs);

        reqnt.setText("" + number);
        rein.setText("" + number1);
        reret.setText("" + number2);
        reyrs.setText("" + number3);

        rediff = (TextView) findViewById(R.id.rediff);
        reper = (TextView) findViewById(R.id.reper);
        recagr = (TextView) findViewById(R.id.recagr);
        textView29 = findViewById(R.id.textView29);
        textView30 = findViewById(R.id.textView30);
        textView31 = findViewById(R.id.textView31);
        rebtot = findViewById(R.id.rebtot);
        rectot = findViewById(R.id.rectot);

        rein = findViewById(R.id.rein);
        reret = findViewById(R.id.reret);
        reqnt = findViewById(R.id.reqnt);
        reyrs = findViewById(R.id.reyrs);

        in = Double.parseDouble(rein.getText().toString());
        ret = Double.parseDouble(reret.getText().toString());
        qnt = Double.parseDouble(reqnt.getText().toString());
        year= Double.parseDouble(reyrs.getText().toString());

        buytot = in*qnt;
        rebtot.setText(String.valueOf(buytot));

        curtot = ret*qnt;
        rectot.setText(String.valueOf(curtot));

        net = (ret - in)*qnt;
        if(net >= 0){
            textView29.setTextColor(Color.parseColor("#039217"));
            textView29.setText("Net Profit");
            rediff.setTextColor(Color.parseColor("#039217"));
            rediff.setText(String.valueOf(net));
        }
        else{
            textView29.setTextColor(Color.RED);
            textView29.setText("Net Loss");
            rediff.setTextColor(Color.RED);
            rediff.setText(String.valueOf(net));
        }

        perc = ((ret-in)/in)*100;
        if(perc >= 0){
            textView30.setTextColor(Color.parseColor("#039217"));
            textView30.setText("Profit Percentage");
            reper.setTextColor(Color.parseColor("#039217"));
            reper.setText(String.valueOf(String.format("%.2f", perc) + "%"));
        }
        else{
            textView30.setTextColor(Color.RED);
            textView30.setText("Loss Percentage");
            reper.setTextColor(Color.RED);
            reper.setText(String.valueOf(String.format("%.2f", perc) + "%"));
        }

        a=1/year;
        b=ret/in;
        ca = ((Math.pow(b,a))-1)*100;
        if( ca >= 0 ) {
            textView31.setTextColor(Color.parseColor("#039217"));
            recagr.setTextColor(Color.parseColor("#039217"));
            recagr.setText(String.valueOf(String.format("%.3f", ca) + "%"));
        }
        else{
            textView31.setTextColor(Color.RED);
            recagr.setTextColor(Color.RED);
            recagr.setText(String.valueOf(String.format("%.3f", ca) + "%"));
        }
    }
}