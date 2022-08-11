package com.diary.klinikapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.diary.klinikapp.databinding.ActivitySplashBinding;

public class Splash extends AppCompatActivity {

    ActivitySplashBinding binding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        preferences = getSharedPreferences("doviana", MODE_PRIVATE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (preferences.getBoolean("autologin", false)){
                    startActivity(new Intent(Splash.this, HomeActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(Splash.this, HomeActivity.class));
                }
                    finish();

                Intent intent = new Intent(Splash.this, Signin.class);
            }
        },5000);
    }
}
