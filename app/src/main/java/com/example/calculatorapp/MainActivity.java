package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtInput;
    boolean decimalDisplay;
    boolean isNewOp = true;
    String OldNumber,NewNumber = "";
    String Operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput = findViewById(R.id.txtInput);

    }


    public void setNumber(View view) {
        if(isNewOp)
            txtInput.setText("");
        isNewOp = false;
        String number = txtInput.getText().toString();
        switch (view.getId()) {
            case R.id.btn0:
                number += "0";
                break;
            case R.id.btn1:
                number += "1";
                break;
            case R.id.btn2:
                number += "2";
                break;
            case R.id.btn3:
                number += "3";
                break;
            case R.id.btn4:
                number += "4";
                break;
            case R.id.btn5:
                number += "5";
                break;
            case R.id.btn6:
                number += "6";
                break;
            case R.id.btn7:
                number += "7";
                break;
            case R.id.btn8:
                number += "8";
                break;
            case R.id.btn9:
                number += "9";
                break;
            case R.id.btnPosNeg:
//                number = String.valueOf(Double.parseDouble(number) * -1);
                number = String.valueOf(Double.parseDouble(number) * -1);
                decimalDisplay = true;
                break;
            case R.id.btnDot:
                if(!decimalDisplay){
                    number += ".";
                    decimalDisplay = true;
                }
                break;
            case R.id.btnClearEntry:
                number = "";
                break;
            case R.id.btnClearAll:
                OldNumber  = "";
                NewNumber = "";
                number = "";
                break;
            case R.id.btnDeleteTxt:
                if(number.length()!=0){
                    number = number.substring(0,number.length()-1);
                }
        }

        txtInput.setText(number);
    }

    public void setOperator(View view) {
        isNewOp = true;
        OldNumber = txtInput.getText().toString();
        switch (view.getId()){
            case R.id.btnAdd :
                Operator = "+";
                break;
            case R.id.btnMinus :
                Operator = "-";
                break;
            case R.id.btnMultiply :
                Operator = "*";
                break;
            case R.id.btnDivide :
                Operator = "/";
                break;
        }
        decimalDisplay = false;
    }
    public void specialOperator(View view) {
        String number = txtInput.getText().toString();
        double result = 0.0;
        switch (view.getId()){
            case R.id.btnPercent :
                result = Double.parseDouble(number)/100;
                break;
            case R.id.btn1x :
                result = 1/Double.parseDouble(number);
                break;
            case R.id.btnSquareRoot :
                result = Double.parseDouble(number) * Double.parseDouble(number);
                break;
            case R.id.btnSquared :
                result = Math.sqrt(Double.parseDouble(number));
                break;
        }
        txtInput.setText(result+"");
    }
    public void Calculate(View view) {
        NewNumber = txtInput.getText().toString();
        double result = 0.0;
        switch (Operator){
            case "+" :
                result = Double.parseDouble(OldNumber) + Double.parseDouble(NewNumber);
                break;
            case "-" :
                result = Double.parseDouble(OldNumber) - Double.parseDouble(NewNumber);
                break;
            case "*" :
                result = Double.parseDouble(OldNumber) * Double.parseDouble(NewNumber);
                break;
            case "/" :
                result = Double.parseDouble(OldNumber) / Double.parseDouble(NewNumber);
                break;
        }
        txtInput.setText(result+"");
    }


}