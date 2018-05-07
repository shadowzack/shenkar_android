package com.shenkar.battl.shenkar_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;

    private Button mult;
    private Button div;
    private Button plus;
    private Button minus;
    private Button clear;
    private Button equal;
    //private Button dot;
    private TextView opr;
    private TextView result;
    private char action;
    private int errorCounter=0;
    private double firstnumber= Double.NaN;
    private double secondnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listeners();
    }

    private void init(){
        zero=(Button)findViewById(R.id.btn_0);
        one=(Button)findViewById(R.id.btn_1);
        two=(Button)findViewById(R.id.btn_2);
        three=(Button)findViewById(R.id.btn_3);
        four=(Button)findViewById(R.id.btn_4);
        five=(Button)findViewById(R.id.btn_5);
        six=(Button)findViewById(R.id.btn_6);
        seven=(Button)findViewById(R.id.btn_7);
        eight=(Button)findViewById(R.id.btn_8);
        nine=(Button)findViewById(R.id.btn_9);
        mult=(Button)findViewById(R.id.btn_mul);
        equal=(Button)findViewById(R.id.btn_equal);
        plus=(Button)findViewById(R.id.btn_plus);
        minus=(Button)findViewById(R.id.btn_sub);
        div=(Button)findViewById(R.id.btn_div);
        clear=(Button)findViewById(R.id.btn_clear);
        //dot=(Button)findViewById(R.id.btn_dot);
        result=(TextView) findViewById(R.id.result);
        opr=(TextView) findViewById(R.id.opreation);
    }
    private void listeners(){

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ zero.getText().toString());
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ one.getText().toString());
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ two.getText().toString());
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ three.getText().toString());
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ four.getText().toString());
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ five.getText().toString());
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ six.getText().toString());
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ seven.getText().toString());
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ eight.getText().toString());
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ nine.getText().toString());
            }
        });

        ////////
      /*  zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ zero.getText().toString());
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(opr.getText().toString()+ zero.getText().toString());
            }
        });
*/

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                action='+';
                result.setText(String.valueOf(firstnumber)+'+');
                opr.setText(null);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calc();
                action='-';
                result.setText(String.valueOf(firstnumber)+'-');
                opr.setText(null);

            }
        });
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                action='*';
                result.setText(String.valueOf(firstnumber)+'*');
                opr.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                action='/';
                result.setText(String.valueOf(firstnumber)+'/');
                opr.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc();
                char temp=action;
                action = '=';
                if(temp!='/')
                    result.setText(result.getText().toString()+ String.valueOf(secondnumber)+"="+String.valueOf(firstnumber));
                else{
                    if(secondnumber!=0)
                        result.setText(result.getText().toString()+ String.valueOf(secondnumber)+"="+String.valueOf(firstnumber));
                }
                if(errorCounter==0)
                    opr.setText(String.valueOf(firstnumber));
                else{
                    errorCounter--;
                    opr.setText(null);
                    //result.setText(null);
                    firstnumber=Double.NaN;
                    secondnumber=Double.NaN;
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opr.setText(null);
                result.setText(null);
                firstnumber=Double.NaN;
                secondnumber=Double.NaN;
            }
        });





    }

    private void calc(){
        if(!Double.isNaN(firstnumber)){
            //if its  number
            if(!opr.getText().toString().isEmpty()) {
                secondnumber = Double.parseDouble(opr.getText().toString());

                switch (action) {
                    case '+':
                        firstnumber += secondnumber;
                        break;
                    case '-':
                        firstnumber -= secondnumber;
                        break;
                    case '*':
                        firstnumber *= secondnumber;
                        break;
                    case '/':
                        if (secondnumber != 0)
                            firstnumber /= secondnumber;
                        else {
                            result.setText("ERROR DIVITION BY ZERO");
                            errorCounter++;
                        }
                        break;
                    case '=':
                        break;
                }
            }
        }else {
            try {
                firstnumber=Double.parseDouble(opr.getText().toString());
            }
            catch (Exception e){}


        }
    }


}

