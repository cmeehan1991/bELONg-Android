package com.cbmwebdevelopment.belong;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

/**
 * Created by cmeehan on 23-Sep-16.
 */

public class Splash extends Activity {
    private final static int SPLASH_TIME_OUT = 3000;
    private SharedPreferences preferences;
    private Intent logInIntent;
    private boolean isLogin;
    public Splash() {
    }

    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.splash_screen);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        isLogin = preferences.getBoolean("IsLogin", false);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // check if the user is logged in
                if(isLogin){
                    logInIntent = new Intent(Splash.this, MainActivity.class);
                }else{
                    logInIntent = new Intent(Splash.this, SignInActivity.class);
                }
                startActivity(logInIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
