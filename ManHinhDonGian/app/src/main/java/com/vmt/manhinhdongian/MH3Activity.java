package com.vmt.manhinhdongian;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MH3Activity extends AppCompatActivity {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mh3);

        backButton = findViewById(R.id.btnBackMH3);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khi nút trở về được nhấn, sử dụng finish() để đóng màn hình hiện tại và quay về màn hình trước đó
                finish();
            }
        });
    }
}
