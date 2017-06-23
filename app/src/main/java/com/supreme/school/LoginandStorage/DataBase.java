package com.supreme.school.LoginandStorage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by supreme on 6/20/17.
 */

public class DataBase {
    SharedPreferences sharedPreferences;
    private String user = "details";

    public DataBase(Context context) {
        sharedPreferences = context.getSharedPreferences(user, 0);
    }


    public User getUser() {
        String uname = sharedPreferences.getString("username", "");
        String upass = sharedPreferences.getString("password", "");
        return new User(uname, upass);
    }

    public void setUser(User user) {
        SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putString("username", user.username);
        spEditor.putString("password", user.password);
        spEditor.apply();
    }

    public boolean getStatus() {
        if(sharedPreferences.getBoolean("logged_in",false)==true) return true;
        else return  false;
    }

    public void setStatus(Boolean status) {
        SharedPreferences.Editor spEditor = sharedPreferences.edit();
        spEditor.putBoolean("logged_in", status);
        spEditor.apply();
    }

}
