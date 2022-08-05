package com.diary.klinikapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.diary.klinikapp.dashboard.BottomNavigationViewHelper;
import com.diary.klinikapp.dashboard.ContentRecycleView;
import com.diary.klinikapp.dashboard.History;
import com.diary.klinikapp.dashboard.MedicineRecord;
import com.diary.klinikapp.dashboard.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity<AdapterRecyclerView> extends AppCompatActivity {

    ViewPager viewPager;
    int[] images = {R.drawable.two, R.drawable.three, R.drawable.one};
    int currentPageCunter = 0;
    ArrayList<Pojo> arrayList;
    GridView gridView;
    TextView textView;
    AdapaterGridView adapaterGridView;
    SubMenu subMenu;
    RecyclerView recyclerView;
    RecyclerView.Adapter recycleViewAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ContentModel> dataItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView see_all = findViewById(R.id.see_all);

        see_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { startActivity(new Intent(HomeActivity.this, CategoryActivity.class));
            }
        });

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


        overridePendingTransition(0,0);

        getSupportActionBar().setElevation(0);

        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new SliderAdapter(images, HomeActivity.this));

        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPageCunter == images.length) {
                    currentPageCunter = 0;
                }

                viewPager.setCurrentItem(currentPageCunter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2500,2500);

    BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById( R.id.bottomNavView_Bar );
    BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
    Menu menu = bottomNavigationView.getMenu();
    MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked( true );

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.ic_home:
                    break;

                case R.id.ic_history:
                    Intent intent1 = new Intent(HomeActivity.this, History.class);
                    startActivity( intent1 );
                    break;

                case R.id.ic_calendar:
                    Intent intent2 = new Intent(HomeActivity.this, MedicineRecord.class);
                    startActivity( intent2 );
                    break;

                case R.id.ic_profile:
                    Intent intent3 = new Intent(HomeActivity.this, Profile.class);
                    startActivity( intent3 );
                    break;
            }
            return false;
        }
        } );
    }
}
