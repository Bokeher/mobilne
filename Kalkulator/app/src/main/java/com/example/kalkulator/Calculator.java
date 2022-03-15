package com.example.kalkulator;

public class Calculator {
    public String data = "";
    public String sign = "";

    public void addData(String newData) {
        this.data = this.data + newData;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String calculate() {
        if(data.length()==0) return "Brak wyniku";
        if(sign.length()==0 && data.contains(".")) return "Brak wyniku";
        if((data.charAt(data.indexOf(".")+1)+"").equals(sign)) data.replace(".", "");
        else if(data.lastIndexOf(".") == data.length()-1) data.replace(".", "");
        if (sign != "" && data.length() > 2) {
            String[] numbers = data.split("\\" + sign);
            double numb1 = Double.parseDouble(numbers[0]);
            double numb2 = Double.parseDouble(numbers[1]);

            double res = 0;
            if (sign == "+") {
                res = (numb1 + numb2);
            } else if (sign == "-") {
                res = (numb1 - numb2);
            } else if (sign == "*") {
                res = (numb1 * numb2);
            } else if (sign == "/") {
                if (numb2 != 0) res = (numb1 / numb2);
                else return "Nie mozna dzielic przez 0";
            }

            return res + "";
        } else return "Brak wyniku";
    }
}
