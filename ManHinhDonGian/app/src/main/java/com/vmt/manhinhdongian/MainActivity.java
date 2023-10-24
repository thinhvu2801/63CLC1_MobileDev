package com.vmt.manhinhdongian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button nutMH2;
    Button nutNH3;
    void timDieuKhien(){
        nutMH2= (Button) findViewById(R.id.btnMH2);
        nutNH3=(Button) findViewById(R.id.btnMH3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timDieuKhien();
        nutMH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMH2 = new Intent(MainActivity.this, MH2Activity.class);
                startActivities(new Intent[]{intentMH2});
            }
        });
        nutNH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMH3 = new Intent(MainActivity.this, MH3Activity.class);
                startActivities(new Intent[]{intentMH3});
            }
        });


    }
}