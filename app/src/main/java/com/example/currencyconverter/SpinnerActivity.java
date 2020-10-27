package com.example.currencyconverter;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private String []list = {"USD", "VND", "EUR","GBP","JPY","CHF","LAK","BAK","HKD","AUD"};
    EditText amount;
    TextView result;
    double usd2eur = 0.84;
    double usd2vnd = 23178.0;
    private double arg1, arg2, tmp;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_activity);
        result =(TextView) findViewById(R.id.id_result);
        amount =(EditText) findViewById(R.id.id_amount);
        spinner1 = (Spinner) findViewById(R.id.id_spinner1);
        spinner2 = (Spinner) findViewById(R.id.id_spinner2);
        ArrayAdapter spinnerAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list);
        spinner1.setAdapter(spinnerAdapter);
        spinner2.setAdapter(spinnerAdapter);

        //Bắt sự kiện cho Spinner, khi chọn phần tử nào thì hiển thị lên Toast
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position==0) arg1 = 1;
                if (position==1) arg1 = 0.00004347826;
                if (position==2) arg1 = 1.18;
                if (position==3) arg1 = 1.31;
                if (position==4) arg1 = 0.00925925925;
                if (position==5) arg1 = 1.1025;
                if (position==6) arg1 = 0.0001082;
                if (position==7) arg1 = 0.03204;
                if (position==8) arg1 = 0.13;
                if (position==9) arg1 = 0.71;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (position==0) arg2 = 1;
                if (position==1) arg2 = 0.00004347826;
                if (position==2) arg2 = 1.18;
                if (position==3) arg2 = 1.31;
                if (position==4) arg2 = 0.00925925925;
                if (position==5) arg2 = 1.1025;
                if (position==6) arg2 = 0.0001082;
                if (position==7) arg2 = 0.03204;
                if (position==8) arg2 = 0.13;
                if (position==9) arg2 = 0.71;

            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    str = amount.getText().toString();
                    double rsl; //ketqua hien thi tren textview
                    tmp = Double.parseDouble(str);
                    rsl = tmp *(arg1/arg2);
                    rsl = (double) Math.round(rsl * 100) / 100;
                    String a = Double.toString(rsl);
                    result.setText(a);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}