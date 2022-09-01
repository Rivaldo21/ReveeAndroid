package com.diary.klinikapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.diary.klinikapp.databinding.ActivitySigninBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signin extends AppCompatActivity {

    ActivitySigninBinding binding;
    FirebaseAuth auth;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        auth = FirebaseAuth.getInstance();
        preferences = getSharedPreferences("kitasinau", MODE_PRIVATE);
        editor = preferences.edit();

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();
                storeLoginUser(email, password);
            }
        });

        binding.singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signin.this, Singup.class));
            }
        });
    }

    private void storeLoginUser(String email, String password){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    editor.putBoolean("autologin", true);
                    editor.apply();
                    startActivity(new Intent(Signin.this, HomeActivity.class));
                    ProgressDialog.show(Signin.this, "Prosesu", "Favor hein...");
                    } else {
                        startActivity(new Intent(Signin.this, HomeActivity.class));
                    }
                    finish();
            }
        });
    }
}
