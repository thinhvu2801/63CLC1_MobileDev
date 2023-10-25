package com.vuminhthinh.a63131330_thigiuaki;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Bai1Activity extends AppCompatActivity {

    EditText edta, edtb;
    Button btncong, btntru, btnnhan, btnchia;
    TextView txtdapan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau1);
        edta = findViewById(R.id.edtsoa);
        edtb = findViewById(R.id.edtsob);
        btncong = findViewById(R.id.btncong);
        btntru = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);
        btnchia = findViewById(R.id.btnchia);
        txtdapan =findViewById(R.id.txtdapan);
        String chuoi ="not success!!!!!!!!!!!!!!!!";
        // xử lý nút cộng
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a + b;
                txtdapan.setText(String.valueOf(c));
            }
        });
        // xử lý nút trừ
        btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a - b;
                txtdapan.setText(String.valueOf(c));

            }
        });
        // xử lý nút nhân
        btnnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a * b;
                txtdapan.setText(String.valueOf(c));

            }
        });
        // xử lý nút chia
        btnchia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                if(a >= 0 && b> 0){
                    double c = (double) a / b;
                    txtdapan.setText(c+"");
                } else if (b==0) {
                    txtdapan.setText(chuoi);
                }

            }
        });

    }
}
