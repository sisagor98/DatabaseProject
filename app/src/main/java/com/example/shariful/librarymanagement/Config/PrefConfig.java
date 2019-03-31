package com.example.shariful.librarymanagement.Config;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public PrefConfig(Context context) {
        this.context = context;
        sharedPreferences = this.context.getSharedPreferences("pref file", context.MODE_PRIVATE);
    }

        public void writeLoginStatus(boolean status) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("login_status", status);
            editor.commit();
        }

        public boolean readLoginStatus(){
            return sharedPreferences.getBoolean("login_status",false);
        }

        public void writeLogoutStatus(boolean status)
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("logout_status", status);
            editor.commit();
        }
        public boolean readLogoutStatus()
        {
            return sharedPreferences.getBoolean("logout_status",false);
        }

        public void writeUsername(String s)
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username",s);
            editor.commit();
        }
        public String readUsername()
        {
            return  sharedPreferences.getString("username",null);
        }
//    public void writeAdminLoginStatus(boolean status) {
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putBoolean("login_status", status);
//        editor.commit();
//    }
//
//    public boolean readAdminLoginStatus(){
//        return sharedPreferences.getBoolean("login_status",false);
//    }
}
