package com.vmt.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText dk_soA;
    EditText dk_soB;
    EditText dk_KQ;
    Button cong, tru, nhan, chia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }
    void TimDieuKhien(){
         dk_soA = (EditText) findViewById(R.id.num1);
         dk_soB = (EditText) findViewById(R.id.num2);
         dk_KQ= (EditText) findViewById(R.id.HienThiKQ);
        cong = (Button) findViewById(R.id.btnCong);
        tru = (Button) findViewById(R.id.btnTru);
        nhan = (Button) findViewById(R.id.btnNhan);
        chia = (Button) findViewById(R.id.btnChia);
    }
    public void xuLiCong (View view) {
        //lấy 2 số A , B
        String soA = dk_soA.getText().toString();
        String soB = dk_soB.getText().toString();

        float sot1 = Float.parseFloat(soA);
        float sot2 = Float.parseFloat(soB);

        //Xử lí
        float Tong= sot1+sot2;
        //In
        String kQua = String.valueOf(Tong);
        dk_KQ.setText(kQua);
    }
    public void xuLiTru(View view) {
        // Lấy 2 số A , B
        String soA = dk_soA.getText().toString();
        String soB = dk_soB.getText().toString();

        float sot1 = Float.parseFloat(soA);
        float sot2 = Float.parseFloat(soB);

        // Xử lí
        float Hieu = sot1 - sot2;
        // In
        String kQua = String.valueOf(Hieu);
        dk_KQ.setText(kQua);
    }

    public void xuLiNhan(View view) {
        // Lấy 2 số A , B
        String soA = dk_soA.getText().toString();
        String soB = dk_soB.getText().toString();

        float sot1 = Float.parseFloat(soA);
        float sot2 = Float.parseFloat(soB);

        // Xử lí
        float Tich = sot1 * sot2;
        // In
        String kQua = String.valueOf(Tich);
        dk_KQ.setText(kQua);
    }

    public void xuLiChia(View view) {
        // Lấy 2 số A , B
        String soA = dk_soA.getText().toString();
        String soB = dk_soB.getText().toString();

        float sot1 = Float.parseFloat(soA);
        float sot2 = Float.parseFloat(soB);

        // Xử lí (Kiểm tra trường hợp chia cho 0)
        if (sot2 != 0) {
            float Thuong = sot1 / sot2;
            // In
            String kQua = String.valueOf(Thuong);
            dk_KQ.setText(kQua);
        } else {
            dk_KQ.setText("Không thể chia cho 0");
        }
    }


}