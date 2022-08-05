package com.diary.klinikapp;

import android.os.Bundle;
import android.view.SubMenu;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    ArrayList<Pojo> arrayList;
    GridView gridView;
    AdapaterGridView adapaterGridView;
    SubMenu subMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportActionBar().setTitle("Kategoria Tratamentu");

        gridView = findViewById(R.id.grid_list);

        gridItemShow();

        adapaterGridView = new AdapaterGridView(this, arrayList);
        gridView.setAdapter(adapaterGridView);
    }

    private void gridItemShow() {
        arrayList = new ArrayList<Pojo>();

        arrayList.add(new Pojo("Fokit Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_12));
        arrayList.add(new Pojo("Hamos Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_13));
        arrayList.add(new Pojo("Aumenta Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_14));
        arrayList.add(new Pojo("Solda Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_15));
        arrayList.add(new Pojo("Solda Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_15));
        arrayList.add(new Pojo("Solda Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_15));
        arrayList.add(new Pojo("Solda Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_15));
        arrayList.add(new Pojo("Solda Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_15));
        arrayList.add(new Pojo("Solda Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_15));
        arrayList.add(new Pojo("Solda Nehan", "Diskontu Konsulta nehan...", R.drawable.ic_15));
    }
}