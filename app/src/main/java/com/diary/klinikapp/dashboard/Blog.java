package com.diary.klinikapp.dashboard;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.diary.klinikapp.ForumActivity;
import com.diary.klinikapp.HomeActivity;
import com.diary.klinikapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Blog extends AppCompatActivity {

    WebView webView;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                View decor = getWindow().getDecorView();
                boolean shouldChangeStatusBarTintToDark = true;
                getWindow().setStatusBarColor(Color.WHITE);
                if (shouldChangeStatusBarTintToDark) {
                    decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                } else {
                    // We want to change tint color to white again.
                    // You can also record the flags in advance so that you can turn UI back completely if
                    // you have set other flags before, such as translucent or full screen.
                    decor.setSystemUiVisibility(0);
                }
            }
        }

//        webView = (WebView) findViewById(R.id.webrevee);
//        /*bar = (ProgressBar) findViewById(R.id.progressBarStyle);*/
//        webView.setWebViewClient(new myWebclient());
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://revee.site/");
//
//        WebView myWebView = (WebView) findViewById(R.id.webrevee);
//        myWebView.loadUrl("https://revee.site/");

        overridePendingTransition(0,0);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.blog_toolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.white)));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById( R.id.bottomNavView_Bar );
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked( true );

        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent intent0 = new Intent( Blog.this, HomeActivity.class );
                        startActivity( intent0 );
                        break;

                    case R.id.ic_forum:
                        Intent intent1 = new Intent(Blog.this, ForumActivity.class);
                        startActivity( intent1 );
                        break;

                    case R.id.ic_blog:
                        break;

                    case R.id.ic_favoritu:
                        Intent intent3 = new Intent(Blog.this, Favoritu.class);
                        startActivity( intent3 );
                        break;

                    case  R.id.ic_profile:
                        Intent intent4 = new Intent(Blog.this, Profile.class);
                        startActivity( intent4 );
                        break;
                }

                return false;
            }
        } );
    }
    private class myWebclient extends WebViewClient {
    }
}
