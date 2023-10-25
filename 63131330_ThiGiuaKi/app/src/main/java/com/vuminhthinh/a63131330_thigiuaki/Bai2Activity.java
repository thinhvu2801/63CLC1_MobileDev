package com.vuminhthinh.a63131330_thigiuaki;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;


public class Bai2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        ArrayList<String> dataSrc = new ArrayList<String>();
        dataSrc.add("BH1");
        dataSrc.add("BH2");
        dataSrc.add("BH3");
        dataSrc.add("BH4");
        dataSrc.add("BH5");
        dataSrc.add("BH6");
        dataSrc.add("BH7");
        dataSrc.add("BH8");
        dataSrc.add("BH9");

        ListView listViewBH = findViewById(R.id.lvDSBaiHat);
        ArrayAdapter<String> bhAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataSrc);

        listViewBH.setAdapter(bhAdapter);

        // Thêm sự kiện onClick
        listViewBH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedBaiHat = dataSrc.get(position);
                Toast.makeText(Bai2Activity.this, "Bạn đã chọn bài hát: " + selectedBaiHat, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
