package com.cbmwebdevelopment.belong;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;


/**
 * Created by cmeehan on 26-Sep-16.
 */

public class UserSignIn extends AsyncTask<String, Boolean, String> {
    private final String LINK = "http://belong.cbmwebdevelopment.com/UserSignIn.php";
    private final Context CONTEXT;
    private final String TAG = "UserSignIn";
    private EditText passwordText;
    public AsyncResponse delegate = null;

    public interface AsyncResponse{
        void processFinish(String output);
    }

    public UserSignIn(Context context, EditText passwordText, AsyncResponse delegate){
        this.CONTEXT = context;
        this.passwordText = passwordText;
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {
        String username = params[0];
        String password = params[1];
        try {

            // Set the data to the user's entered username and password values
            String data = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
            data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");

            Log.d(TAG, data);

            // Establish a connection to the URL 'belong.cbmwebdevelopment.com/UserSignIn.php
            URL url = new URL(LINK);
            URLConnection conn = url.openConnection();

            // Set the connection for output and convert the charater streams to byte streams
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

            writer.write(data);
            writer.flush(); // Forces any output byes to be written out

            // Read the input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read the server response
            while((line =reader.readLine()) != null){
                sb.append(line);
                break;
            }
            return sb.toString();
        } catch (Exception ex) {
            Log.i(TAG, "Exception: "+ex.getMessage());
            Log.i(TAG, "Exception: "+ Arrays.toString(ex.getStackTrace()));
            return new String("Exeption: "+ex.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String result){
        if(result.equals("NO ACCESS")){
            passwordText.setText("");
            Toast.makeText(CONTEXT, "Invalid Usernamd or Password", Toast.LENGTH_SHORT).show();
        }else{
            delegate.processFinish(result);
        }
    }

}
