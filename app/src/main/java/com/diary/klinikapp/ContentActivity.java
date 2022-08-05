package com.diary.klinikapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diary.klinikapp.dashboard.ContentRecycleView;

import java.util.ArrayList;

public class ContentActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ContentModel> dataItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        recyclerView = findViewById(R.id.content_recyclerView);
        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        dataItem = new ArrayList<>();
        for (int i = 0; i < ContentItem.judul.length; i++) {
            dataItem.add(new ContentModel(ContentItem.judul[i],
                    ContentItem.tahun[i],
                    ContentItem.poster[i]));
        }

        recycleViewAdapter = new ContentRecycleView(dataItem);
        recyclerView.setAdapter(recycleViewAdapter);

    }
}