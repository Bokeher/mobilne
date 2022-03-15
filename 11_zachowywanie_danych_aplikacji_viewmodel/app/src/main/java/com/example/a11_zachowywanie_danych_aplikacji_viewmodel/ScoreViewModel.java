package com.example.a11_zachowywanie_danych_aplikacji_viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ScoreViewModel extends ViewModel {
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;
    private ArrayList<String> arrayList = new ArrayList<>();

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }
}
