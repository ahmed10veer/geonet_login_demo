package com.example.geonet_login_demo.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.geonet_login_demo.control.SharedPreferenceManager;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isLoggedIn;

        isLoggedIn = SharedPreferenceManager.isLoggedIn(LauncherActivity.this);

        if (isLoggedIn) {
            startActivity(new Intent(this, DashboardMainActivity.class));
        } else {
            startActivity(new Intent(this, LoginUserActivity.class));
        }

        finish();
    }
}
