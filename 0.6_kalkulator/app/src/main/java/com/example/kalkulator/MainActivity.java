package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calculator calc = new Calculator();
        TextView txtView_result = findViewById(R.id.txtView_result);

        findViewById(R.id.btn_1).setOnClickListener(view -> {
            check(calc);
            addData("1", calc);
        });

        findViewById(R.id.btn_2).setOnClickListener(view -> {
            check(calc);
            addData("2", calc);
        });

        findViewById(R.id.btn_3).setOnClickListener(view -> {
            check(calc);
            addData("3", calc);
        });

        findViewById(R.id.btn_4).setOnClickListener(view -> {
            check(calc);
            addData("4", calc);
        });

        findViewById(R.id.btn_5).setOnClickListener(view -> {
            check(calc);
            addData("5", calc);
        });

        findViewById(R.id.btn_6).setOnClickListener(view -> {
            check(calc);
            addData("6", calc);
        });

        findViewById(R.id.btn_7).setOnClickListener(view -> {
            check(calc);
            addData("7", calc);
        });

        findViewById(R.id.btn_8).setOnClickListener(view -> {
            check(calc);
            addData("8", calc);
        });

        findViewById(R.id.btn_9).setOnClickListener(view -> {
            check(calc);
            addData("9", calc);
        });

        findViewById(R.id.btn_0).setOnClickListener(view -> {
            check(calc);
            addData("0", calc);
        });

        findViewById(R.id.btn_add).setOnClickListener(view -> {
            setSign("+", calc);
        });
        findViewById(R.id.btn_minus).setOnClickListener(view -> {
            setSign("-", calc);
        });
        findViewById(R.id.btn_multiply).setOnClickListener(view -> {
            setSign("*", calc);
        });
        findViewById(R.id.btn_divide).setOnClickListener(view -> {
            setSign("/", calc);
        });

        findViewById(R.id.btn_C).setOnClickListener(view -> {
            txtView_result.setText("");
            calc.setData("");
            calc.setSign("");
        });

        findViewById(R.id.btn_dot).setOnClickListener(view -> {
            String text = calc.getData();
            if(text.length()>0){
                if(checkIfHasSign()){
                    String temp = text.substring(text.indexOf(calc.getSign()));
                    if(!temp.contains(".")) addData(".", calc);
                }else{
                    if(!text.contains(".")) addData(".", calc);
                }
            }
        });

        findViewById(R.id.btn_del).setOnClickListener(view -> {
            String text = txtView_result.getText().toString();
            if(text.length()>0) {
                text = text.substring(0, text.length() - 1);
                txtView_result.setText(text);
                calc.setData(text);
                if (!checkIfHasSign()) calc.setSign("");
            }
        });

        findViewById(R.id.btn_equals).setOnClickListener(view -> {
            String res = calc.calculate();
            txtView_result.setText(res);
        });
    }

    private void check(Calculator calc){
        TextView txtView_result = findViewById(R.id.txtView_result);
        if(txtView_result.getText().equals("Brak wyniku") || txtView_result.getText().equals("Nie mozna dzielic przez 0") ) {
            txtView_result.setText("");
            calc.setData("");
            calc.setSign("");
        }
    }

    private void setSign(String sign, Calculator calc){
        TextView txtView_result = findViewById(R.id.txtView_result);
        if(checkIfHasSign()){ //has sign
            String text = txtView_result.getText().toString().replace(calc.getSign(), sign);
            txtView_result.setText(text);
            calc.setData(text);
        }else{ //doesn't have sign
            if(txtView_result.getText().length()>0){
                txtView_result.setText(txtView_result.getText()+sign);
                calc.addData(sign);
            }
        }
        calc.setSign(sign);
    }

    private boolean checkIfHasSign(){
        TextView txtView_result = findViewById(R.id.txtView_result);
        String[] signs = {"+", "-", "*", "/"};
        for(int i=0; i<signs.length; i++){
            if(txtView_result.getText().toString().contains(signs[i])) return true;
        }
        return false;
    }

    private void addData(String data, Calculator calc){
        TextView txtView_result = findViewById(R.id.txtView_result);
        txtView_result.setText(txtView_result.getText()+data);
        calc.addData(data);
    }

}