package com.cbmwebdevelopment.belong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by paintboy602 on 9/25/16.
 */

public class AddHomeworkActivity extends AppCompatActivity{
    private String courseName, courseNumber;
    private EditText courseNameText, homeworkTitleText, homeworkDescriptionText;


    @Override
    public void onCreate(Bundle savedStateInstances){
        super.onCreate(savedStateInstances);

        // Get the intent
        Intent intent = getIntent();
        this.courseName = intent.getExtras().getString("COURSE_NAME");
        this.courseNumber = intent.getExtras().getString("COURSE_DESCRIPTION");

        setContentView(R.layout.add_homework_content);

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
        switch(item.getItemId()){
            case android.R.id.home:

        }
    }

    public void saveHomework(View view){
        Intent intent = new Intent(this, ViewClassDetails.class);
        intent.putExtra("COURSE_NAME", courseName);
        intent.putExtra("COURSE_NUMBER", courseNumber);
        startActivity(intent);
    }
}
