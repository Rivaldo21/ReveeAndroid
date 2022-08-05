package com.diary.klinikapp.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diary.klinikapp.HomeActivity;
import com.diary.klinikapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recycleViewAdapter;
    RecyclerView.LayoutManager recycleViewLayoutManager;
    ArrayList<ItemModel> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        recycleViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recycleViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        for (int i = 0; i <MyItem.Headline.length; i++) {
            data.add(new ItemModel(MyItem.Headline[i],
                    MyItem.Subheadline[i],
                    MyItem.iconlist[i]));
        }

        recycleViewAdapter = new MyRecycleView(data);
        recyclerView.setAdapter(recycleViewAdapter);

        overridePendingTransition(0,0);

        getSupportActionBar().setTitle("Perfil");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        /*TextView title = (TextView) findViewById(R.id.activityTitle2);*/

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById( R.id.bottomNavView_Bar );
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked( true );

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent( Profile.this, HomeActivity.class );
                        startActivity( intent0 );
                        break;

                    case R.id.ic_history:
                        Intent intent1 = new Intent(Profile.this, History.class);
                        startActivity( intent1 );
                        break;

                    case R.id.ic_calendar:
                        Intent intent2 = new Intent(Profile.this, MedicineRecord.class);
                        startActivity( intent2 );
                        break;

                    case  R.id.ic_profile:
                        break;

                }

                return false;
            }
        } );
    }
}
