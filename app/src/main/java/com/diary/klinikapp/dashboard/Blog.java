package com.diary.klinikapp.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.diary.klinikapp.R;
import com.diary.klinikapp.HomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Blog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        overridePendingTransition(0,0);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.blog_toolbar);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById( R.id.bottomNavView_Bar );
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked( true );

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent( Blog.this, HomeActivity.class );
                        startActivity( intent0 );
                        break;

                    case R.id.ic_blog:
                        break;

                    case R.id.ic_favoritu:
                        Intent intent2 = new Intent(Blog.this, Favoritu.class);
                        startActivity( intent2 );
                        break;

                    case  R.id.ic_profile:
                        Intent intent3 = new Intent(Blog.this, Profile.class);
                        startActivity( intent3 );
                        break;

                }

                return false;
            }
        } );
    }
}