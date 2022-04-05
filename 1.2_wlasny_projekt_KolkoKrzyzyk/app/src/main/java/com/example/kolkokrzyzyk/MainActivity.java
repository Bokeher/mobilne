package com.example.kolkokrzyzyk;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = getResources();
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_1.setOnClickListener(view -> move(btn_1));
        btn_2.setOnClickListener(view -> move(btn_2));
        btn_3.setOnClickListener(view -> move(btn_3));
        btn_4.setOnClickListener(view -> move(btn_4));
        btn_5.setOnClickListener(view -> move(btn_5));
        btn_6.setOnClickListener(view -> move(btn_6));
        btn_7.setOnClickListener(view -> move(btn_7));
        btn_8.setOnClickListener(view -> move(btn_8));
        btn_9.setOnClickListener(view -> move(btn_9));

        Button btn_reset = findViewById(R.id.btn_reset);
        btn_reset.setOnClickListener(view -> reset());
    }

    private void move(Button btn) {
        if(btn.getText().equals("") && !gameOver) {
            btn.setText(getSign());
            changeSign();
            int state = checkMap();
            if(state != 0) endGame(state);
        }
    }

    // 1 - won player1 | 2 - won player2 | 3 - draw | 0 - nothing
    private int checkMap() {
        int[][] t = new int[3][3];

        //y  x
        t[0][0] = mapSignToInt(btn_1);
        t[0][1] = mapSignToInt(btn_2);
        t[0][2] = mapSignToInt(btn_3);
        t[1][0] = mapSignToInt(btn_4);
        t[1][1] = mapSignToInt(btn_5);
        t[1][2] = mapSignToInt(btn_6);
        t[2][0] = mapSignToInt(btn_7);
        t[2][1] = mapSignToInt(btn_8);
        t[2][2] = mapSignToInt(btn_9);

        int sum;

        // horizontal _
        for(int i = 0; i < 3; i++) {
            sum = t[i][0] + t[i][1] + t[i][2];
            if(sum == 3) return 1;
            else if(sum == 6) return 2;
        }

        // vertical |
        for(int i = 0; i < 3; i++) {
            sum = t[0][i] + t[1][i] + t[2][i];
            if(sum == 3) return 1;
            else if(sum == 6) return 2;
        }

        // diagonal / \
        sum = t[2][0] + t[1][1] + t[0][2];
        if(sum == 3) return 1;
        else if(sum == 6) return 2;

        sum = t[0][0] + t[1][1] + t[2][2];
        if(sum == 3) return 1;
        else if(sum == 6) return 2;

        //draw
        int draw = 0;
        for(int i = 0; i < 3; i++) {
            if(t[0][i] + t[1][i] + t[2][i] < 10) draw++;
        }
        if(draw == 3) return 3;

        return 0; // nothing
    }

    private void endGame(int result) {
        gameOver = true;
        String winner;

        if(result == 1) {
            addPoints(true);
            winner = res.getString(R.string.player1_won);
        } else if(result == 2) {
            addPoints(false);
            winner = res.getString(R.string.player2_won);
        } else winner = res.getString(R.string.draw);

        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(winner);
        dlgAlert.setTitle(res.getString(R.string.game_over));
        dlgAlert.setPositiveButton("Ok", (dialog, which) -> clearBoard()); // potential error {}
        dlgAlert.setCancelable(false);
        dlgAlert.create().show();
    }

    private void clearBoard() {
        btn_1.setText("");
        btn_2.setText("");
        btn_3.setText("");
        btn_4.setText("");
        btn_5.setText("");
        btn_6.setText("");
        btn_7.setText("");
        btn_8.setText("");
        btn_9.setText("");

        gameOver = false;
        if(!sign) changeSign();
    }

    private int mapSignToInt(Button btn) {
        String text = String.valueOf(btn.getText());
        if(text.equals("X")) return 1;
        else if(text.equals("O")) return 2;
        return 10;
    }

    private void changeSign() {
        sign = !sign;

        TextView txtView_currentMove = findViewById(R.id.txtView_currentMove);
        if(sign) txtView_currentMove.setText(res.getString(R.string.player1_move));
        else txtView_currentMove.setText(res.getString(R.string.player2_move));
    }

    private String getSign() {
        if(sign) return "X";
        return "O";
    }

    private void addPoints(boolean player) {
        TextView txtView_score;

        if(player) {
            txtView_score = findViewById(R.id.txtView_player1_score);
        } else {
            txtView_score = findViewById(R.id.txtView_player2_score);
        }

        int score = Integer.parseInt(String.valueOf(txtView_score.getText()));
        txtView_score.setText(""+(score+1));
    }

    private void clearScore() {
        TextView txtView_player1_score = findViewById(R.id.txtView_player1_score);
        TextView txtView_player2_score = findViewById(R.id.txtView_player2_score);

        txtView_player1_score.setText("0");
        txtView_player2_score.setText("0");
    }
    private void reset() {
        clearScore();
        clearBoard();
    }

    // true - X | false - O
    private boolean gameOver = false;
    private boolean sign = true;
}