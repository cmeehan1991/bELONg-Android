package com.cbmwebdevelopment.belong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by paintboy602 on 9/25/16.
 */

public class AddHomeworkActivity extends AppCompatActivity{
    private String courseName, courseNumber;
    private EditText courseNameText, homeworkTitleText, homeworkDescriptionText;
    private final String TAG = "Add Homework Activity";


    @Override
    public void onCreate(Bundle savedStateInstances){
        super.onCreate(savedStateInstances);
        setContentView(R.layout.add_homework_content);


        // Get the intent
        Intent intent = getIntent();
        this.courseName = intent.getExtras().getString("COURSE_NAME");
        this.courseNumber = intent.getExtras().getString("COURSE_NUMBER");
        Log.d(TAG, courseNumber);


        courseNameText = (EditText) findViewById(R.id.courseName);
        courseNameText.setText(courseName);

        homeworkTitleText = (EditText)findViewById(R.id.homeworkTitle);
        homeworkDescriptionText = (EditText)findViewById(R.id.homeworkDescription);

    }

    @Override
    public void onBackPressed(){
        Intent backIntent = new Intent(this, ViewClassDetails.class);
        backIntent.putExtra("COURSE_NAME", this.courseName);
        backIntent.putExtra("COURSE_NUMBER", this.courseNumber);
        setResult(RESULT_OK, backIntent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Log.d(TAG, String.valueOf(item.getItemId()));
        switch(item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this, ViewClassDetails.class);
                intent.putExtra("COURSE_NAME",courseName);
                intent.putExtra("COURSE_NUMBER", courseNumber);
                startActivity(intent);
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveHomework(View view){
        Intent intent = new Intent(this, ViewClassDetails.class);
        intent.putExtra("COURSE_NAME", courseName);
        intent.putExtra("COURSE_NUMBER", courseNumber);
        startActivity(intent);
    }
}
