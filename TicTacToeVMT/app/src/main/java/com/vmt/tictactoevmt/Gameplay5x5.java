package com.vmt.tictactoevmt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Gameplay5x5 extends AppCompatActivity implements View.OnClickListener {

    TextView playerOneScore, playerTwoScore, playerStatus;
    Button[] buttons = new Button[25];
    Button resetGame;
    Button quitButton;
    int playerOneScoreCount, playerTwoScoreCount, roundCount;
    boolean activePlayer;

    // empty = 2
    // player 1 = 0
    // player 2 = 1
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winPositions = {
            {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24}, // rows
            {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24}, // columns
            {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20} // diagonals
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay5x5);

        playerOneScore = findViewById(R.id.playerScore1);
        playerTwoScore = findViewById(R.id.playerScore2);
        playerStatus = findViewById(R.id.playerStatus);
        resetGame = findViewById(R.id.buttonReset);
        quitButton = findViewById(R.id.buttonQuit);

        // Quit Button code
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gameplay5x5.this, SelectMap.class);
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
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        String buttonID = v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1));
        if (activePlayer) {
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.parseColor("#FFC34A"));
            gameState[gameStatePointer] = 0;
        } else {
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.parseColor("#70FFEA"));
            gameState[gameStatePointer] = 1;
        }
        roundCount++;
        if (checkWinner()) {
            if (activePlayer) {
                playerOneScoreCount++;
                updatePlayerScore();
                Toast.makeText(this, "Player One Won!", Toast.LENGTH_SHORT).show();
                playAgain();
            }
            if (!activePlayer) {
                playerTwoScoreCount++;
                updatePlayerScore();
                Toast.makeText(this, "Player Two Won!", Toast.LENGTH_SHORT).show();
                playAgain();
            }
        } else if (roundCount == 25) {
            playAgain();
            Toast.makeText(this, "No Winner!", Toast.LENGTH_SHORT).show();
        } else {
            activePlayer = !activePlayer;
        }
        if (playerOneScoreCount > playerTwoScoreCount) {
            playerStatus.setText("Player One is The WINNER!");
        } else if (playerTwoScoreCount > playerOneScoreCount) {
            playerStatus.setText("Player Two is The WINNER!");
        } else {
            playerStatus.setText("");
        }
        resetGame.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                playAgain();
                roundCount = 0;
                playerOneScoreCount = 0;
                playerTwoScoreCount = 0;
                playerStatus.setText("");
                playerOneScore.setText(Integer.toString(0));
                playerTwoScore.setText(Integer.toString(0));
                updatePlayerScore();
            }
        });
    }

    public boolean checkWinner() {
        boolean winnerResult = false;
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] &&
                    gameState[winPosition[1]] == gameState[winPosition[2]] &&
                    gameState[winPosition[2]] == gameState[winPosition[3]] &&
                    gameState[winPosition[3]] == gameState[winPosition[4]] &&
                    gameState[winPosition[0]] != 2) {
                winnerResult = true;
            }
        }
        return winnerResult;
    }

    public void updatePlayerScore() {
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }

    public void playAgain() {
        roundCount = 0;
        activePlayer = true;

        for (int i = 0; i < buttons.length; i++) {
            gameState[i] = 2;
            buttons[i].setText("");
        }
    }
}
