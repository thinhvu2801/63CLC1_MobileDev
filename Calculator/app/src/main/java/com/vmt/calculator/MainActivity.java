package com.vmt.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void xuLiCong (View view) {
        //lấy 2 số A , B
        EditText dk_soA = (EditText) findViewById(R.id.num1);
        int soA=Integer.parseInt(dk_soA.getText().toString());
        EditText dk_soB = (EditText) findViewById(R.id.num2);
        int soB=Integer.parseInt(dk_soA.getText().toString());
        //Xử lí
        int kQua= soA+soB;
        //In
        TextView dk_KQ= (TextView) findViewById(R.id.HienThiKQ);
        dk_KQ.setText(String.valueOf(kQua));
    }
    void xuLiTru(View view) {
        // Lấy 2 số A , B
        EditText dk_soA = (EditText) findViewById(R.id.num1);
        int soA = Integer.parseInt(dk_soA.getText().toString());
        EditText dk_soB = (EditText) findViewById(R.id.num2);
        int soB = Integer.parseInt(dk_soB.getText().toString());
        // Xử lí
        int kQua = soA - soB;
        // In
        TextView dk_KQ = (TextView) findViewById(R.id.HienThiKQ);
        dk_KQ.setText(String.valueOf(kQua));
    }
    void xuLiNhan(View view) {
        // Lấy 2 số A , B
        EditText dk_soA = (EditText) findViewById(R.id.num1);
        int soA = Integer.parseInt(dk_soA.getText().toString());
        EditText dk_soB = (EditText) findViewById(R.id.num2);
        int soB = Integer.parseInt(dk_soB.getText().toString());
        // Xử lí
        int kQua = soA * soB;
        // In
        TextView dk_KQ = (TextView) findViewById(R.id.HienThiKQ);
        dk_KQ.setText(String.valueOf(kQua));
    }
    void xuLiChia(View view) {
        // Lấy 2 số A , B
        EditText dk_soA = (EditText) findViewById(R.id.num1);
        int soA = Integer.parseInt(dk_soA.getText().toString());
        EditText dk_soB = (EditText) findViewById(R.id.num2);
        int soB = Integer.parseInt(dk_soB.getText().toString());
        // Xử lí (Kiểm tra trường hợp chia cho 0)
        if (soB != 0) {
            float kQua = (float) soA / soB;
            // In
            TextView dk_KQ = (TextView) findViewById(R.id.HienThiKQ);
            dk_KQ.setText(String.valueOf(kQua));
        } else {
            TextView dk_KQ = (TextView) findViewById(R.id.HienThiKQ);
            dk_KQ.setText("Không thể chia cho 0");
        }
    }

}