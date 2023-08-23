package com.example.roicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class stockcalc extends AppCompatActivity {
    TextView stdeff,stper,stcmgr,textView22,textView23,textView24,stcagr,btot,ctot;
    Double in,ret,year,qnt,net,perc,cmgr,a,b,ca,totb,tots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockcalc);

        Intent intent = getIntent();
        Double number = intent.getDoubleExtra(stock.EXTRA_NUMBER, 0);
        Double number1 = intent.getDoubleExtra(stock.EXTRA_NUMBER1, 0);
        int number2 = intent.getIntExtra(stock.EXTRA_NUMBER2,0);
        int number3 = intent.getIntExtra(stock.EXTRA_NUMBER3,0);

        TextView stin = (TextView) findViewById(R.id.stin);
        TextView stret = (TextView) findViewById(R.id.stret);
        TextView stqnt = (TextView) findViewById(R.id.stqnt);
        TextView styrs = (TextView) findViewById(R.id.styrs);

        stin.setText("" + number);
        stret.setText("" + number1);
        stqnt.setText("" + number2);
        styrs.setText("" + number3);

        stdeff = (TextView) findViewById(R.id.stdeff);
        stper = (TextView) findViewById(R.id.stper);
        stcmgr = (TextView) findViewById(R.id.stcmgr);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        btot = findViewById(R.id.btot);
        ctot = findViewById(R.id.ctot);

        stin = findViewById(R.id.stin);
        stret = findViewById(R.id.stret);
        stqnt = findViewById(R.id.stqnt);
        styrs = findViewById(R.id.styrs);

        in = Double.parseDouble(stin.getText().toString());
        ret = Double.parseDouble(stret.getText().toString());
        qnt = Double.parseDouble(stqnt.getText().toString());
        year= Double.parseDouble(styrs.getText().toString());

        totb=in*qnt;
        btot.setText(String.valueOf(totb));

        tots=ret*qnt;
        ctot.setText(String.valueOf(tots));

        net = (ret - in)*qnt;
        if(net >= 0){
            textView22.setTextColor(Color.parseColor("#039217"));
            textView22.setText("Net Profit");
            stdeff.setTextColor(Color.parseColor("#039217"));
            stdeff.setText(String.valueOf(net));
        }
        else{
            textView22.setTextColor(Color.RED);
            textView22.setText("Net Loss");
            stdeff.setTextColor(Color.RED);
            stdeff.setText(String.valueOf(net));
        }

        perc = ((ret-in)/in)*100;
        if(perc >= 0){
            textView23.setTextColor(Color.parseColor("#039217"));
            textView23.setText("Profit Percentage");
            stper.setTextColor(Color.parseColor("#039217"));
            stper.setText(String.valueOf(String.format("%.2f", perc) + "%"));
        }
        else{
            textView23.setTextColor(Color.RED);
            textView23.setText("Loss Percentage");
            stper.setTextColor(Color.RED);
            stper.setText(String.valueOf(String.format("%.2f", perc) + "%"));
        }

        a=1/year;
        b=ret/in;
        ca = ((Math.pow(b,a))-1)*100;
        if( ca >= 0 ) {
            textView24.setTextColor(Color.parseColor("#039217"));
            stcmgr.setTextColor(Color.parseColor("#039217"));
            stcmgr.setText(String.valueOf(String.format("%.3f", ca) + "%"));
        }
        else{
            textView24.setTextColor(Color.RED);
            stcmgr.setTextColor(Color.RED);
            stcmgr.setText(String.valueOf(String.format("%.3f", ca) + "%"));
        }





    }
}