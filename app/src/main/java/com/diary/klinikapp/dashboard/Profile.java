package com.diary.klinikapp.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.diary.klinikapp.HomeActivity;
import com.diary.klinikapp.R;
import com.diary.klinikapp.Signin;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btn1;
    RecyclerView.Adapter recycleViewAdapter;
    RecyclerView.LayoutManager recycleViewLayoutManager;
    ArrayList<ItemModel> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile );

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);

        final TextView txtView = (TextView) findViewById(R.id.tvView);

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profile.this, "Sai husi perfil", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(txtView.getContext(),Signin.class);
                startActivityForResult(myIntent, 0);
            }
        });

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
