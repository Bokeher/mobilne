package com.example.a0_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_addOne = findViewById(R.id.btn_addOne);
        Button btn_removeOne = findViewById(R.id.btn_removeOne);
        TextView txtV_counter = findViewById(R.id.txtV_counter);
        TextView txtV_numb = findViewById(R.id.txtV_numb);
        ImageView imgV_1 = findViewById(R.id.imgV_1);

        txtV_counter.setText(""+number);

        btn_addOne.setOnClickListener(view -> {
            number++;
            txtV_counter.setText(""+number);
        });

        btn_removeOne.setOnClickListener(view -> {
            if(number > 0){
                number--;
                txtV_counter.setText(""+number);
            }
        });
    }
}