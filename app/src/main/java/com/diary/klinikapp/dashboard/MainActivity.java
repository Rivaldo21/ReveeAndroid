package com.diary.klinikapp.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.diary.klinikapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_dashboard);

        overridePendingTransition(0, 0);

//        TextView title = (TextView) findViewById(R.id.activityTitle1);
//        title.setText("This is ActivityOne");

            BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
            BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
            Menu menu = bottomNavigationView.getMenu();
            MenuItem menuItem = menu.getItem(0);
            menuItem.setChecked(true);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.ic_home:
                            Intent intent0 = new Intent(MainActivity.this, Dashboard.class);
                            startActivity(intent0);
                            break;

                        case R.id.ic_history:
                            Intent intent1 = new Intent(MainActivity.this, History.class);
                            startActivity(intent1);
                            break;

                        case R.id.ic_calendar:
                            Intent intent2 = new Intent(MainActivity.this, MedicineRecord.class);
                            startActivity(intent2);
                            break;

                        case R.id.ic_profile:
                            Intent intent3 = new Intent(MainActivity.this, Profile.class);
                            startActivity(intent3);
                            break;

                    }

                    return false;
                }
            });
        }
    }
