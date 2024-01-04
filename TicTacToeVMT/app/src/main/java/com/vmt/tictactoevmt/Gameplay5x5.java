package com.vmt.tictactoevmt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Gameplay5x5 extends AppCompatActivity implements View.OnClickListener {

    private int dimention = 5;
    private Button[][] buttons = new Button[dimention][dimention];

    private boolean p1Turn = true;
    public int p1TotalWins;
    public int p2TotalWins;

    private int rounder;

    private int p1Points;
    private int p2Points;

    private TextView p1Score;
    private TextView p2Score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay5x5);

        p1Score = findViewById(R.id.text_view_p1);
        p2Score = findViewById(R.id.text_view_p2);

        for (int i = 0; i < dimention; i++) {
            for (int j = 0; j < dimention; j++) {

                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();
            }
        });

        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Gameplay5x5.this, SelectMap.class));
                finish();
            }
        });
    }

    private void Reset() {

        p1Points = 0;
        p2Points = 0;
        ScoreText();
        CleanBoard();
    }

    @Override
    public void onClick(View view) {

        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        playBeepSound();

        if (p1Turn) {
            ((Button) view).setText("X");
        } else {
            ((Button) view).setText("O");
        }

        rounder++;

        if (checkForWin()) {
            if (p1Turn) {
                Handler handler = new Handler();
                //tạo delay trong này
                handler.postDelayed(() -> p1Win(), 100);
            } else {
                Handler handler = new Handler();
                handler.postDelayed(() -> p2Win(), 100);
            }
        } else if (rounder == 25) {
            Handler handler = new Handler();
            handler.postDelayed(() -> draw(), 100);
        } else {
            p1Turn = !p1Turn;
        }
    }

    private boolean checkForWin() {
        String[][] field = new String[dimention][dimention];

        for (int i = 0; i < dimention; i++) {
            for (int j = 0; j < dimention; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < dimention; i++) {
            if (field[i][0].equals(field[i][1]) &&
                    field[i][0].equals(field[i][2]) &&
                    field[i][0].equals(field[i][3]) &&
                    field[i][0].equals(field[i][4]) &&
                    !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < dimention; i++) {
            if (field[0][i].equals(field[1][i]) &&
                    field[0][i].equals(field[2][i]) &&
                    field[0][i].equals(field[3][i]) &&
                    field[0][i].equals(field[4][i]) &&
                    !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1]) &&
                field[0][0].equals(field[2][2]) &&
                field[0][0].equals(field[3][3]) &&
                field[0][0].equals(field[4][4]) &&
                !field[0][0].equals("")) {
            return true;
        }

        if (field[0][4].equals(field[1][3]) &&
                field[1][3].equals(field[2][2]) &&
                field[2][2].equals(field[3][1]) &&
                field[3][1].equals(field[4][0]) &&
                !field[0][4].equals("")) {
            return true;
        }

        return false;
    }

    private void p1Win() {

        p1Points++;
        Toast.makeText(this, "Player 1 wins!", Toast.LENGTH_SHORT).show();
        p1TotalWins++;
        ScoreText();
        CleanBoard();
    }

    private void p2Win() {

        p2Points++;
        Toast.makeText(this, "Player 2 wins!", Toast.LENGTH_SHORT).show();
        p2TotalWins++;
        ScoreText();
        CleanBoard();
    }

    private void draw() {

        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        CleanBoard();
    }

    private void ScoreText() {
        p1Score.setText("P1: " + p1Points);
        p2Score.setText("P2: " + p2Points);

    }

    private void CleanBoard() {
        for (int i = 0; i < dimention; i++) {
            for (int j = 0; j < dimention; j++) {
                buttons[i][j].setText("");
            }
        }
        rounder = 0;
        p1Turn = true;
    }

    private void playBeepSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.beep_sound);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        mediaPlayer.start();
    }
}