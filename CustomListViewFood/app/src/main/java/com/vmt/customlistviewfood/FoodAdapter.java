package com.vmt.customlistviewfood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class FoodAdapter extends ArrayAdapter<Food> {

    public FoodAdapter(Context context, ArrayList<Food> foods) {
        super(context, 0, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Food food = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageViewFood = convertView.findViewById(R.id.imageViewFood);
        TextView textViewName = convertView.findViewById(R.id.textViewName);
        TextView textViewDescription = convertView.findViewById(R.id.textViewDescription);

        imageViewFood.setImageResource(food.getImageResourceId());
        textViewName.setText(food.getName());
        textViewDescription.setText(food.getDescription());

        // Thêm sự kiện onClick
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), food.getName() + "\n" + food.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
