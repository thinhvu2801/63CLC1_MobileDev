package com.vuminhthinh.a63131330_thigiuaki;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonCau1;
    Button buttonCau2;
    Button buttonCau3;
    Button buttonCau4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCau1 = findViewById(R.id.button);
        buttonCau2 = findViewById(R.id.button2);
        buttonCau3 = findViewById(R.id.button3);
        buttonCau4 = findViewById(R.id.button4);


        buttonCau1.setOnClickListener(view -> {
            Intent intentBai1 = new Intent(MainActivity.this, Bai1Activity.class);
            startActivity(intentBai1);
        });
        buttonCau2.setOnClickListener(view -> {
            Intent intentBai2 = new Intent(MainActivity.this, Bai2Activity.class);
            startActivity(intentBai2);
        });
        buttonCau3.setOnClickListener(view -> {
            Intent intentBai3 = new Intent(MainActivity.this, Bai3Activity.class);
            startActivity(intentBai3);
        });
        buttonCau4.setOnClickListener(view -> {
            Intent intentBai4 = new Intent(MainActivity.this, Bai4Activity.class);
            startActivity(intentBai4);
        });

    }
}
