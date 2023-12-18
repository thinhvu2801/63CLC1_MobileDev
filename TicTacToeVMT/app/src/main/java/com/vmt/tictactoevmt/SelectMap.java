package com.vmt.tictactoevmt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectMap extends AppCompatActivity {
    Button btn_3x3, btn_4x4, btn_5x5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_diff);
        btn_3x3 = findViewById(R.id.button3x3);
        btn_4x4 = findViewById(R.id.button4x4);
        btn_5x5 = findViewById(R.id.button5x5);

        btn_3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectMap.this, Gameplay4x4.class);
                startActivity(intent);
            }
        });
        btn_4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectMap.this, Gameplay4x4.class);
                startActivity(intent);
            }
        });
        btn_5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectMap.this, Gameplay5x5.class);
                startActivity(intent);
            }
        });
    }
}