package com.diary.klinikapp.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diary.klinikapp.ContentModel;
import com.diary.klinikapp.R;

import java.util.ArrayList;

public class ContentRecycleView extends RecyclerView.Adapter<ContentRecycleView.mViewHolder> {

   private ArrayList<ContentModel> dataItem;

    public class mViewHolder extends RecyclerView.ViewHolder {

        public TextView txtJudul;
        public TextView txtTahun;
        public ImageView img;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);

            txtJudul = itemView.findViewById(R.id.text_judul);
            txtTahun = itemView.findViewById(R.id.text_tahun);
            img = itemView.findViewById(R.id.img_content);
        }
    }

    public ContentRecycleView (ArrayList<ContentModel> dataItem) {
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public ContentRecycleView.mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_list, parent, false);

        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentRecycleView.mViewHolder holder, int position) {

        TextView textJudul = holder.txtJudul;
        TextView textTahun = holder.txtTahun;
        ImageView img = holder.img;

        textJudul.setText(dataItem.get(position).getJudul());
        textTahun.setText(dataItem.get(position).getTahun());
        img.setImageResource(dataItem.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }
}
