package com.diary.klinikapp.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diary.klinikapp.R;

import java.util.ArrayList;


/*Show to profile*/
public class MyRecycleView extends RecyclerView.Adapter<MyRecycleView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtHead;
        TextView txtSubhead;
        ImageView imageIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtHead = itemView.findViewById(R.id.text_title1);
            txtSubhead = itemView.findViewById(R.id.text_subtitle1);
            imageIcon = itemView.findViewById(R.id.image1);
        }
    }

    MyRecycleView(ArrayList<ItemModel> dataItem) {
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public MyRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleView.ViewHolder holder, int position) {

        TextView txtHead = holder.txtHead;
        TextView txtSubhead = holder.txtSubhead;
        ImageView imageIcon = holder.imageIcon;

        txtHead.setText(dataItem.get(position).getName());
        txtSubhead.setText(dataItem.get(position).getType());
        imageIcon.setImageResource(dataItem.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }
}
