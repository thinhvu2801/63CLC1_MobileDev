package com.vmt.tictactoeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView playerOneScore, PlayerTwoScore, playerStatus;
    Button [] buttons = new Button[9];
    Button resetGame;
    Button quit;
    int playerOneScoreCount, playerTwoScoreCount, roundCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}