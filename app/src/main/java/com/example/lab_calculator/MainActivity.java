package com.example.lab_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.editTxt);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.btnOne:
                number += "1";
                break;
            case R.id.btnTwo:
                number += "2";
                break;
            case R.id.btnThree:
                number += "3";
                break;
            case R.id.btnFour:
                number += "4";
                break;
            case R.id.btnFive:
                number += "5";
                break;
            case R.id.btnSix:
                number += "6";
                break;
            case R.id.btnSeven:
                number += "7";
                break;
            case R.id.btnEight:
                number += "8";
                break;
            case R.id.btnNine:
                number += "9";
                break;
            case R.id.btnZero:
                number += "0";
                break;
            case R.id.btnDot:
                number += ".";
                break;
            case R.id.btnPlusMinus:
                number = "-"+number;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.btnDivide: op = "/"; break;
            case R.id.btnMultiply: op = "*"; break;
            case R.id.btnSqRoot: op = "√"; break;
            case R.id.btnPlus: op = "+"; break;
            case R.id.btnMinus: op = "-"; break;
        }
    }

    public void equalEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op) {
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }

    public void deleteEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }

    public void rootEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result1 = Math.sqrt(Double.parseDouble(newNumber));
        ed1.setText(result1+"");
    }
}