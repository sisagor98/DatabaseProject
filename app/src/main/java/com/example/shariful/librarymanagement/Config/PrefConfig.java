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
}
