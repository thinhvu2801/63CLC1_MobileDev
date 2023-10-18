package com.vmt.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Country> dsQG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        dsQG = new ArrayList<Country>();
        Country qg1 = new Country("VietNam", "vn", 80);
        Country qg2 = new Country("United States", "us", 331);
        Country qg3 = new Country("Russia", "ru", 38);
        Country qg4 = new Country("France", "fr", 67);
        Country qg5 = new Country("Germany", "de", 83);
        Country qg6 = new Country("Japan", "jp", 126);
        Country qg7 = new Country("China", "cn", 1441);
        Country qg8 = new Country("Australia", "au", 25);
        Country qg9 = new Country("Brazil", "br", 214);
        Country qg10 = new Country("India", "in", 1380);

        dsQG.add(qg1);
        dsQG.add(qg2);
        dsQG.add(qg3);
        dsQG.add(qg4);
        dsQG.add(qg5);
        dsQG.add(qg6);
        dsQG.add(qg7);
        dsQG.add(qg8);
        dsQG.add(qg9);
        dsQG.add(qg10);

        //tim dieu khien
        ListView lvQG = findViewById(R.id.listViewNation);
        //tao adapter
        CountryArrayAdapter adapter;
        adapter = new CountryArrayAdapter(dsQG,this);
        //gan vao
        lvQG.setAdapter(adapter);
        //xu li su kien, nhu bai cu

    }

}