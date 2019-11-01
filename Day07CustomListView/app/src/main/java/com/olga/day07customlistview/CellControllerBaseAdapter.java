package com.olga.day07customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CellControllerBaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<Flower> flowerArrayList;

    public CellControllerBaseAdapter(Context context, ArrayList<Flower> flowerArrayList) {
        this.context = context;
        this.flowerArrayList = flowerArrayList;
    }

    //number of sells
    @Override
    public int getCount() {
        return flowerArrayList.size();
    }

    //return 1 flower object
    @Override
    public Object getItem(int position) {
        return flowerArrayList.get(position);
    }

    //
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View cellReusableViewObject, ViewGroup parent) {
        Flower flower  = flowerArrayList.get(position);

        if(cellReusableViewObject == null){
            cellReusableViewObject = LayoutInflater.from(context).inflate(R.layout.cell_custom, parent, false);
        }

        ImageView cell_imageView = cellReusableViewObject.findViewById(R.id.imgCustomImage);
        TextView cell_title  = cellReusableViewObject.findViewById(R.id.cellCustomTitle);
        TextView cell_price  = cellReusableViewObject.findViewById(R.id.cellCustomPrice);
        TextView cell_description  = cellReusableViewObject.findViewById(R.id.cellCustomDescription);

        String photoName = flower.getPhoto();

        if(photoName.contains(".")){
            photoName = photoName.substring(0, photoName.lastIndexOf('.'));
        }
        int imageResId  = context.getResources().getIdentifier(photoName,
                "drawable",
                context.getApplicationContext().getPackageName());
        cell_imageView.setImageResource(imageResId);

        return cellReusableViewObject;
    }
}
