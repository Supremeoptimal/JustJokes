package com.supreme.school.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.supreme.school.LoginandStorage.DataBase;
import com.supreme.school.R;

public class FacebookLoginActivity extends AppCompatActivity {
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DataBase(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (db.getStatus()) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (db.getStatus()) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    public void nav(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
