package com.supreme.school.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;
import com.supreme.school.LoginandStorage.DataBase;
import com.supreme.school.R;
import com.supreme.school.activity.FacebookLoginActivity;

public class IntroSlideActivity extends AppIntro2 {
    DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new DataBase(this);

        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = this.getSharedPreferences("Supreme", 0);
        if (sharedPreferences.getBoolean("firstLaunch", false) == true) {
            startActivity(new Intent(this, FacebookLoginActivity.class));
        } else {
            SharedPreferences.Editor speditor = sharedPreferences.edit();
            speditor.putBoolean("firstLaunch", true);
            speditor.apply();
        }


        addSlide(AppIntro2Fragment.newInstance("Just Jokes", "Bringing you jokes that will make you laugh", R.drawable.slide_1, getResources().getColor(R.color.slide_1)));
        addSlide(AppIntro2Fragment.newInstance("Crack your joke", "Rack your brain to make other people laugh", R.drawable.slide_2, getResources().getColor(R.color.slide_2)));
        addSlide(AppIntro2Fragment.newInstance("Search", "Search for jokes from all over the world", R.drawable.slide_3, getResources().getColor(R.color.slide_3)));
        addSlide(AppIntro2Fragment.newInstance("Compiled jokes", "Jokes and Lot more after you get started", R.drawable.slide_4, getResources().getColor(R.color.slide_4)));

        setSlideOverAnimation();

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onDonePressed() {
        super.onDonePressed();
        startActivity(new Intent(getApplicationContext(), FacebookLoginActivity.class));
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(getApplicationContext(), FacebookLoginActivity.class));

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
}
