package com.example.geonet_login_demo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.geonet_login_demo.R;
import com.example.geonet_login_demo.control.SharedPreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

    }

    void checkLogin() {
        String sid = "";
        String spass = "";

//        if login is ok,
        sid = ((EditText) findViewById(R.id.et_id)).getText().toString();
        spass = ((EditText) findViewById(R.id.et_pass)).getText().toString();

        if ((checkCred(sid, spass))) {
//        set logged in
            SharedPreferenceManager.setLoggedInUserID(LoginUserActivity.this, sid);

//        goto dashboard,
            startActivity(new Intent(LoginUserActivity.this, DashboardMainActivity.class));
            finish();
        } else {
//        else show dialog wrong id pass, clr password
            Toast.makeText(this, "Wrong ID and/or password. please try again.", Toast.LENGTH_LONG).show();

//             ((EditText) findViewById(R.id.et_id)).setText("");
            ((EditText) findViewById(R.id.et_pass)).setText("");
        }

    }

    boolean checkCred(String id, String pass) {
        List<String> loginIDList = new ArrayList<>();
        List<String> loginPassList = new ArrayList<>();

//        get login id and passwords stored in strings
        loginIDList = Arrays.asList(getResources().getString(R.string.login_ids).split(","));
        loginPassList = Arrays.asList(getResources().getString(R.string.login_passs).split(","));

//        if id and pass matches in correct order...
        if (loginIDList.contains(id)) {
            return pass.equals(loginPassList.get(loginIDList.indexOf(id)));
        }

        return false;
    }
}
