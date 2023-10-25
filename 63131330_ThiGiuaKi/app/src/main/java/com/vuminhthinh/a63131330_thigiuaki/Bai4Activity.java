package com.vuminhthinh.a63131330_thigiuaki;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Bai4Activity extends AppCompatActivity {

    private EditText etTen, etLop, etTuoi, etNgaySinh, etSoThich;
    private Button btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        etTen = findViewById(R.id.etTen);
        etLop = findViewById(R.id.etLop);
        etTuoi = findViewById(R.id.etTuoi);
        etNgaySinh = findViewById(R.id.etNgaySinh);
        etSoThich = findViewById(R.id.etSoThich);
        btnXacNhan = findViewById(R.id.btnXacNhan);

        btnXacNhan.setOnClickListener(v -> {
            String ten = etTen.getText().toString();
            String lop = etLop.getText().toString();
            int tuoi = Integer.parseInt(etTuoi.getText().toString());
            String ngaySinh = etNgaySinh.getText().toString();
            String soThich = etSoThich.getText().toString();

            Intent intent = new Intent(Bai4Activity.this, HienThiThongTinActivity.class);
            intent.putExtra("ten", ten);
            intent.putExtra("lop", lop);
            intent.putExtra("tuoi", tuoi);
            intent.putExtra("ngaySinh", ngaySinh);
            intent.putExtra("soThich", soThich);
            startActivity(intent);
        });
    }
}
