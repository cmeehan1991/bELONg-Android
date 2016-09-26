package com.cbmwebdevelopment.belong;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by cmeehan on 26-Sep-16.
 */

public class UserInformation extends AsyncTask<String, Void, String> {
    public AsyncResponse delegate;
    private final Context CONTEXT;
    private final String TAG = "UserInformation", LINK = "";


    public interface AsyncResponse{
        void processFinish(String output);
    }

    public UserInformation(Context context, AsyncResponse delegate){
        this.CONTEXT = context;
        this.delegate = delegate;
    }

    @Override
    protected String doInBackground(String... params) {
        String userID = params[0];
        try{

        }catch (Exception ex){
            Log.i(TAG, "Error: "+ex);
        }
        return null;
    }

    @Override
    protected void onPostExecute(String results){

    }
}
