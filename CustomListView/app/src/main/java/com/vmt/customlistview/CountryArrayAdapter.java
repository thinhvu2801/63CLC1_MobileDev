package com.vmt.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryArrayAdapter extends BaseAdapter {
    //nguồn dữ liệu
    ///class's attributes
    private List<Country> listDataSource;
    private LayoutInflater inflater;
    private Context context;

    //contructor
    public CountryArrayAdapter(List<Country> listDataSource, Context context) {
        this.listDataSource = listDataSource;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    //inner class
    class CountryItemViewHolder {//mapping customize item XML layout
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }

    @Override
    public int getCount() {
        return listDataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return listDataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CountryItemViewHolder itemViewHolder;
        if (view == null) {
            //XML-->
            view = inflater.inflate(R.layout.country_item_layout, null);
            //get ref
            itemViewHolder = new CountryItemViewHolder();
            itemViewHolder.flagView = view.findViewById(R.id.imageViewFlag);
            itemViewHolder.countryNameView = view.findViewById(R.id.textViewCountryName);
            itemViewHolder.populationView = view.findViewById(R.id.textViewPopulation);
            //
            view.setTag(itemViewHolder);
        } else {
            itemViewHolder = (CountryItemViewHolder) view.getTag();
        }
        //Set item's data
        Country countryItem = listDataSource.get(i);
        itemViewHolder.countryNameView.setText(countryItem.getCountryName());
        itemViewHolder.populationView.setText("Population: "+countryItem.getPopulation());
        //img data, need ur own function
        int flagID=getImgIDbyResName(countryItem.getCountryFlag());
        itemViewHolder.flagView.setImageResource(flagID);
        return view;
    }//end of getView
    //My own function for reading image ID
    public int getImgIDbyResName(String resName) {
        String packageName = context.getPackageName();
        int imgId = context.getResources().getIdentifier(resName,"mipmap",packageName);
        return imgId;
    };
}

