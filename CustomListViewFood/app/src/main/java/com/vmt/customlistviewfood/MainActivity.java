package com.vmt.customlistviewfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Phở", "Món ăn Việt Nam", R.drawable.pho));
        foodList.add(new Food("Sushi", "Món ăn Nhật Bản", R.drawable.sushi));

        FoodAdapter adapter = new FoodAdapter(this, foodList);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
