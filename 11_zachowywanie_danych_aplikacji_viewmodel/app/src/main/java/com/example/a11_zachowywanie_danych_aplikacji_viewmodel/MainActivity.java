package com.example.a11_zachowywanie_danych_aplikacji_viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ScoreViewModel ScoreViewModel;
    TextView txtView_A_score;
    TextView txtView_B_score;
    ArrayAdapter<String> adapter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScoreViewModel = new ViewModelProvider(this).get(ScoreViewModel.class);
        txtView_A_score = findViewById(R.id.txtView_A_score);
        txtView_B_score = findViewById(R.id.txtView_B_score);
        spinner = findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ScoreViewModel.getArrayList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btn_A_plus3 = findViewById(R.id.btn_A_plus3);
        Button btn_A_plus2 = findViewById(R.id.btn_A_plus2);
        Button btn_A_free = findViewById(R.id.btn_A_free);
        Button btn_B_plus3 = findViewById(R.id.btn_B_plus3);
        Button btn_B_plus2 = findViewById(R.id.btn_B_plus2);
        Button btn_B_free = findViewById(R.id.btn_B_free);
        Button btn_reset = findViewById(R.id.btn_reset);

        btn_A_plus3.setOnClickListener(view -> {
            add("A", 3);
        });
        btn_A_plus2.setOnClickListener(view -> {
            add("A", 2);
        });
        btn_A_free.setOnClickListener(view -> {
            add("A", 1);
        });
        btn_B_plus3.setOnClickListener(view -> {
            add("B", 3);
        });
        btn_B_plus2.setOnClickListener(view -> {
            add("B", 2);
        });
        btn_B_free.setOnClickListener(view -> {
            add("B", 1);
        });
        btn_reset.setOnClickListener(view -> {
            reset();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        txtView_A_score.setText(Integer.toString(ScoreViewModel.getScoreTeamA()));
        txtView_B_score.setText(Integer.toString(ScoreViewModel.getScoreTeamB()));
    }

    public void add(String team, int amount) {
        if(team.equals("A")) {
            ScoreViewModel.setScoreTeamA(ScoreViewModel.getScoreTeamA()+amount);
            txtView_A_score.setText(Integer.toString(ScoreViewModel.getScoreTeamA()));
        } else {
            ScoreViewModel.setScoreTeamB(ScoreViewModel.getScoreTeamB()+amount);
            txtView_B_score.setText(Integer.toString(ScoreViewModel.getScoreTeamB()));
        }


        adapter.add("Team"+team+": +"+amount);
    }

    public void reset() {
        ScoreViewModel.setScoreTeamA(0);
        ScoreViewModel.setScoreTeamB(0);

        txtView_A_score.setText(Integer.toString(ScoreViewModel.getScoreTeamA()));
        txtView_B_score.setText(Integer.toString(ScoreViewModel.getScoreTeamB()));
    }
}