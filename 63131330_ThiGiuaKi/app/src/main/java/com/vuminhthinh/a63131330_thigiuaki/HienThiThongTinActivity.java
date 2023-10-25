package com.vuminhthinh.a63131330_thigiuaki;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HienThiThongTinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_thong_tin);

        Intent intent = getIntent();
        String ten = intent.getStringExtra("ten");
        String lop = intent.getStringExtra("lop");
        int tuoi = intent.getIntExtra("tuoi", 0);
        String ngaySinh = intent.getStringExtra("ngaySinh");
        String soThich = intent.getStringExtra("soThich");

        TextView tvThongTin = findViewById(R.id.tvThongTin);
        String thongTin = "Tên: " + ten + "\n" +
                "Lớp: " + lop + "\n" +
                "Tuổi: " + tuoi + "\n" +
                "Ngày sinh: " + ngaySinh + "\n" +
                "Sở thích: " + soThich;

        tvThongTin.setText(thongTin);
    }
}
