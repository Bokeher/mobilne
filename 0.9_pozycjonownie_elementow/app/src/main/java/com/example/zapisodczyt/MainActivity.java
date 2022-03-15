package com.example.zapisodczyt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_save = findViewById(R.id.btn_save);
        Button btn_load = findViewById(R.id.btn_load);
        EditText editText_insertData = findViewById(R.id.editText_insertData);
        TextView textView_data = findViewById(R.id.textView_data);

        String filename = "data.txt";
        Context context = this;

        File f = new File(context.getFilesDir(), filename);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText_insertData.getText().toString();

                try {
                    FileWriter fw = new FileWriter(f);
                    fw.write(text);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Scanner sc = new Scanner(f);

                    String data = "";
                    while(sc.hasNextLine()) {
                        data += sc.nextLine();
                    }
                    sc.close();

                    editText_insertData.setText(data);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}