package com.cbmwebdevelopment.belong;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.cbmwebdevelopment.belong.UserSignIn.AsyncResponse;

import org.json.JSONObject;

/**
 * Created by cmeehan on 26-Sep-16.
 */

public class SignInActivity extends AppCompatActivity {
    private EditText usernameText, passwordText;
    private String username, password;
    private Context context;
    private final String TAG = "SignInActivity";
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.signin_content);

        usernameText = (EditText) findViewById(R.id.username);
        passwordText = (EditText) findViewById(R.id.password);
        context = this;
    }

    protected void userSignIn(View view) {
        username = usernameText.getText().toString();
        password = passwordText.getText().toString();
        UserSignIn userSignIn = (UserSignIn) new UserSignIn(this, passwordText, new AsyncResponse() {
            @Override
            public void processFinish(String output) {
                preferences = PreferenceManager.getDefaultSharedPreferences(SignInActivity.this);
                preferences.edit().putBoolean("IsLogin",true).commit();
                try {
                    JSONObject jsonObject = new JSONObject(output);
                    String userID = jsonObject.getString("ID");
                    String firstName = jsonObject.getString("FIRST_NAME");
                    String lastName = jsonObject.getString("LAST_NAME");
                    preferences.edit().putString("ID", userID).commit();
                    preferences.edit().putString("firstName", firstName).commit();
                    preferences.edit().putString("lastName", lastName).commit();
                    preferences.edit().putString("fullName", firstName + " " + lastName).commit();
                }catch(Exception ex){
                    Log.e(TAG, "JSON Object" + ex);
                }
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }).execute(username, password);
    }
}
