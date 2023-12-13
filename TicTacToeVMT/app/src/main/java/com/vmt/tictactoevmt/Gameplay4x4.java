package com.vmt.tictactoevmt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Gameplay4x4 extends AppCompatActivity implements View.OnClickListener {

    TextView playerOneScore, playerTwoScore, playerStatus;
    Button[] buttons = new Button[9];
    Button resetGame;
    Button quitButton;
    int playerOneScoreCount, playerTwoScoreCount, roundCount;
    boolean activePlayer;

    //    empty = 0
    //    player 1 = 1
    //    player 2 = 2
                //    int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                //
                //    int[][] winPosition = {
                //            {0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15}, //row
                //            {0, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}, //collum
                //            {0, 5, 10, 15}, {3, 6, 9, 12} //cross
                //    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay4x4);

        playerOneScore = findViewById(R.id.playerScore1);
        playerTwoScore = findViewById(R.id.playerScore2);
        playerStatus = findViewById(R.id.playerStatus);
        resetGame = findViewById(R.id.buttonReset);
        quitButton = findViewById(R.id.buttonQuit);

        //Quit Button code
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gameplay4x4.this, SelectMap.class);
                startActivity(intent);
            }
        });

        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(resourceID);
            buttons[i].setOnClickListener(this);

        }
        roundCount = 0;
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        activePlayer = true;
    }

    @Override
    public void onClick(View v) {
//        Log.i("test","clicked!");

    }
}
