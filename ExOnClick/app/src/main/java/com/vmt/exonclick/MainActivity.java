package com.vmt.exonclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_Name;
    Button buttonSayHi, buttonXinChao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findControls();
        //......
    }
    void findControls() {
        editText_Name= findViewById(R.id.edtName);
        buttonSayHi = findViewById(R.id.btnHello);
        buttonXinChao = findViewById(R.id.btnXinChao);
    }
    public void XuLyNoiHello(View v) {
        String strName =  editText_Name.getText().toString();
        String strThongBao = "Nice to see you \n" + strName;
        Toast.makeText(this, strThongBao, Toast.LENGTH_LONG).show();
    }
    public void XuLyNoiXinChao(View v) {
        String strName =  editText_Name.getText().toString();
        String strThongBao = "Xin chào \n" + strName;
        Toast.makeText(this, strThongBao, Toast.LENGTH_LONG).show();
    }
}