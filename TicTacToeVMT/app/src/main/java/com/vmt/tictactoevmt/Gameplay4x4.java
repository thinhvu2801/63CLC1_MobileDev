package com.vmt.tictactoevmt;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Gameplay4x4 extends AppCompatActivity implements View.OnClickListener {

    private TextView playerOneTextView;
    private TextView playerTwoTextView;
    private TextView playerScore1TextView;
    private TextView playerScore2TextView;
    private TextView playerStatusTextView;
    private GridLayout gridLayout;
    private Button quitButton;
    private Button resetButton;

    private Button[][] buttons = new Button[4][4];
    private boolean currentPlayerIsX = true;

    private int player1Score = 0;
    private int player2Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay4x4);

        playerOneTextView = findViewById(R.id.playerOne);
        playerTwoTextView = findViewById(R.id.playerTwo);
        playerScore1TextView = findViewById(R.id.playerScore1);
        playerScore2TextView = findViewById(R.id.playerScore2);
        playerStatusTextView = findViewById(R.id.playerStatus);
        quitButton = findViewById(R.id.buttonQuit);
        resetButton = findViewById(R.id.buttonReset);

        quitButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);

        createButtons();
        firstTurn();
    }

    private void createButtons() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String buttonID = "btn_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }
    }

    private void firstTurn() {
        currentPlayerIsX = true;
        playerStatusTextView.setText("X turn");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == quitButton.getId()) {
            finish(); // Close the app
        } else if (view.getId() == resetButton.getId()) {
            resetGame();
        } else {
            Button button = (Button) view;
            if (button.getText().toString().equals("")) {
                if (currentPlayerIsX) {
                    button.setTextColor(Color.RED);
                    button.setText("X");
                    currentPlayerIsX = false;
                    playerStatusTextView.setText("O turn");
                    check();
                } else {
                    button.setTextColor(Color.BLUE);
                    button.setText("O");
                    currentPlayerIsX = true;
                    playerStatusTextView.setText("X turn");
                    check();
                }
            }
        }
    }

    private void check() {
        // Check win conditions
        for (int i = 0; i < 4; i++) {
            if (checkLine(i, 0, i, 1, i, 2, i, 3) || checkLine(0, i, 1, i, 2, i, 3, i)) {
                return;
            }
        }
        if (checkLine(0, 0, 1, 1, 2, 2, 3, 3) || checkLine(0, 3, 1, 2, 2, 1, 3, 0)) {
            return;
        }

        // Check Draw
        boolean draw = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (buttons[i][j].getText().toString().equals("")) {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            draw();
        }
    }

    private boolean checkLine(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        String text1 = buttons[x1][y1].getText().toString();
        String text2 = buttons[x2][y2].getText().toString();
        String text3 = buttons[x3][y3].getText().toString();
        String text4 = buttons[x4][y4].getText().toString();

        if (!text1.equals("") && text1.equals(text2) && text1.equals(text3) && text1.equals(text4)) {
            endGame(text1 + " wins");
            updateScores(text1);
            return true;
        }

        return false;
    }

    private void draw() {
        endGame( "Draw!");
    }

    private void endGame( String message) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
        playerStatusTextView.setText(message);
    }

    private void resetGame() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
                buttons[i][j].setTextColor(Color.BLACK);
            }
        }

        firstTurn();
    }

    private void updateScores(String winner) {
        if (winner.equals("X")) {
            player1Score++;
        } else {
            player2Score++;
        }
        playerScore1TextView.setText(String.valueOf(player1Score));
        playerScore2TextView.setText(String.valueOf(player2Score));
    }
}
