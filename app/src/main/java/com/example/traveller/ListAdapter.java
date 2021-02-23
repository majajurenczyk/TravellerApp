package com.example.traveller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private static class ItemHolder{
        ImageView mainImg;
        TextView destination;
        TextView resort;
        TextView date;
        TextView price;
        Button moreInfo;
        RatingBar rates;
        CheckBox cbx;
    }
    private LayoutInflater inflater = null;
    private ArrayList<TourItem> items;
    private Context context;

    public ListAdapter(ArrayList<TourItem> items, Context cxt){
        super();
        this.context = cxt;
        this.items = items;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @SuppressLint({"InflateParams", "SetTextI18n"})
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ItemHolder actItem;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.rout_item_row, null);
            actItem = new ItemHolder();
            actItem.destination = (TextView)convertView.findViewById(R.id.destination);
            actItem.resort = (TextView)convertView.findViewById(R.id.resort);
            actItem.date = (TextView)convertView.findViewById(R.id.date);
            actItem.price = (TextView)convertView.findViewById(R.id.price);
            actItem.mainImg = (ImageView)convertView.findViewById(R.id.image);
            actItem.moreInfo = (Button)convertView.findViewById(R.id.more);
            actItem.rates = (RatingBar)convertView.findViewById(R.id.ratingBar);
            actItem.cbx = (CheckBox) convertView.findViewById(R.id.checkBox);
            convertView.setTag(actItem);
        }
        else{
            actItem = (ItemHolder)convertView.getTag();
        }
        actItem.destination.setText(items.get(position).getDestination());
        actItem.resort.setText(items.get(position).getResort());
        actItem.date.setText(items.get(position).getDateStart()+ "-"+ items.get(position).getDateEnd());
        actItem.price.setText(Integer.toString(items.get(position).getPrice()));
        actItem.mainImg.setImageResource(items.get(position).getMainImageId());
        actItem.rates.setRating((float)items.get(position).getRate());

        actItem.cbx.setChecked(items.get(position).isFavorite());
        actItem.cbx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()) {
                    items.get(position).setFavorite(true);
                    Toast.makeText(context, "Dodano do ulubionych!", Toast.LENGTH_SHORT).show();

                }
                else{
                    items.get(position).setFavorite(false);
                    Toast.makeText(context, "Usunięto z ulubionych.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        actItem.moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MoreInfoActivity.class);
                context.startActivity(i);
            }
        });
        return convertView;
    }
}
