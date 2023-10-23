package com.vmt.practicesonglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> dataSrc = new ArrayList<String>();
        dataSrc.add("BH1");dataSrc.add("BH2");dataSrc.add("BH3");dataSrc.add("BH4");dataSrc.add("BH5");dataSrc.add("BH6");dataSrc.add("BH7");dataSrc.add("BH8");dataSrc.add("BH9");

        ListView listViewBH = (ListView) findViewById(R.id.lvDSBaiHat);
        ArrayAdapter<String> bhAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dataSrc);

        listViewBH.setAdapter(bhAdapter);
    }
}