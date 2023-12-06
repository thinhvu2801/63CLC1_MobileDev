package com.vmt.tictactoeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView playerOneScore, playerTwoScore, playerStatus;
    Button [] buttons = new Button[9];
    Button resetGame;
    Button quit;
    int playerOneScoreCount, playerTwoScoreCount, roundCount;
    boolean activePlayer;

//    empty = 0
//    player 1 = 1
//    player 2 = 2
    int [] gameState = {0,0,0,0,0,0,0,0,0};

    int [][] winPosition = {
            {0,1,2} ,{3,4,5},{6,7,8}, //row
            {0,3,6},{1,4,7},{3,5,8}, //collum
            {0,4,8},{2,4,6} //cross
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScore = (TextView) findViewById(R.id.playerScore1);
        playerTwoScore = (TextView) findViewById(R.id.playerScore2);
        playerStatus = (TextView) findViewById(R.id.playerStatus);

        resetGame = (Button) findViewById(R.id.resetButton);
        quit = (Button) findViewById(R.id.quitButton);

        for (int i = 0; i < buttons.length; i++) {
            String buttonID= "btn_"+i;
            int resourceID= getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i]= (Button) findViewById(resourceID);
                buttons[i].setOnClickListener(this);

        }
        

    }

    @Override
    public void onClick(View v) {
//        Log.i("test","clicked!");
    }
}