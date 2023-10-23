package com.example.penitipanbarang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.penitipanbarang.model.ItemsCategory;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {
    private List<ItemsCategory> itemsCategories;

    public CustomSpinnerAdapter(Context context, int resource, List<ItemsCategory> itemsCategories) {
        super(context, resource);
        this.itemsCategories = itemsCategories;
    }
    @Override
    public int getCount() {
        return itemsCategories.size();
    }

    @Override
    public String getItem(int position) {
        return itemsCategories.get(position).getId();
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_item, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(itemsCategories.get(position).getCategoryName());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);
        }

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(itemsCategories.get(position).getCategoryName());

        return convertView;
    }
}
