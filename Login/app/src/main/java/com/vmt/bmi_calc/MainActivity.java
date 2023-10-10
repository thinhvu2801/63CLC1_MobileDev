package com.vmt.bmi_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //tìm điều khiển cần lấy tương tác, ngay khi màn hình đc bật
        //để dùng khi cần thiết
    }

    public void XuLyLogin() {
        //xu li nut OK
        //B1: lay du lieu tu editText
        //1.1: tìm điều khiển cần lấy dữ liệu
        EditText editText_UN = findViewById(R.id.edtUserName);
        //editText_UN là biến đại diện cho editUserName ở file XML
        EditText editText_PWD = findViewById(R.id.edtPass);
        //1.2: lấy dữ liệu chứa user đã nhập vào điều khiển trên
        String tenDN = editText_UN.getText().toString();
        String mk = editText_PWD.getText().toString();
        //B2: Xử lí Logic
        String ketQua;
        if (tenDN.equals("63CLC1") && mk.equals("123"))
            ketQua = "Login success";
        else
            ketQua = "Login Fail";
        //B3: xuat ket quả
        Toast.makeText(this, ketQua, Toast.LENGTH_LONG).show();
    }
}