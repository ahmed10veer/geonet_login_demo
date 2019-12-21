package com.example.geonet_login_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.geonet_login_demo.R;
import com.example.geonet_login_demo.control.SharedPreferenceManager;

public class DashboardMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_main);

        setTitle(getResources().getString(R.string.app_name));

        String logged_in_user = ((getResources().getString(R.string.logged_in_user)) + SharedPreferenceManager.getLoggedInUserID(DashboardMainActivity.this));

        ((TextView) findViewById(R.id.tv_dashboard_userid)).setText(logged_in_user);

        Button btn_logout = findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    void logout() {
        SharedPreferenceManager.setLoggedInUserID(DashboardMainActivity.this, "");
        startActivity(new Intent(DashboardMainActivity.this, LoginUserActivity.class));

        finish();
    }
}
