package com.diary.klinikapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.diary.klinikapp.dashboard.Blog;
import com.diary.klinikapp.dashboard.BottomNavigationViewHelper;
import com.diary.klinikapp.dashboard.Favoritu;
import com.diary.klinikapp.dashboard.Profile;

public class ForumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        overridePendingTransition(0,0);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.forum_toolbar);

        com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView = (com.google.android.material.bottomnavigation.BottomNavigationView) findViewById( R.id.bottomNavView_Bar );
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked( true );

        bottomNavigationView.setOnNavigationItemSelectedListener( new com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent( ForumActivity.this, HomeActivity.class );
                        startActivity( intent0 );
                        break;

                    case R.id.ic_blog:
                        Intent intent1 = new Intent( ForumActivity.this, Blog.class );
                        startActivity( intent1 );
                        break;

                    case R.id.ic_forum:
                        break;

                    case R.id.ic_favoritu:
                        Intent intent3 = new Intent(ForumActivity.this, Favoritu.class);
                        startActivity( intent3 );
                        break;

                    case  R.id.ic_profile:
                        Intent intent4 = new Intent(ForumActivity.this, Profile.class);
                        startActivity( intent4 );
                        break;

                }

                return false;
            }
        } );
    }

}