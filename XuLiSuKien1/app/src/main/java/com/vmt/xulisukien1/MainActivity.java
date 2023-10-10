package com.vmt.xulisukien1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //code xu li btnOK
    public void XuLiChonOK(View v)
    {
        String chuoiThongBao="Ban vua nhan OK";
        Toast.makeText(this, chuoiThongBao,Toast.LENGTH_LONG).show();
    }
}