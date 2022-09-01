package com.diary.klinikapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapaterGridView extends BaseAdapter {

    Context context;
    ArrayList<Pojo> gridViewPojos;
    SubMenu subMenu;

    public AdapaterGridView(Context context, ArrayList<Pojo> gridViewPojos) {
        this.context = context;
        this.gridViewPojos = gridViewPojos;
    }

    @Override
    public int getCount() {
        return gridViewPojos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.custom_grid_layout, parent, false);
        ImageView imageView = convertView.findViewById(R.id.image);
        TextView textView = convertView.findViewById(R.id.name);

        imageView.setImageResource(gridViewPojos.get(position).getImage());
        textView.setText(gridViewPojos.get(position).getName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+gridViewPojos.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
