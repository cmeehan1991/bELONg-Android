package com.cbmwebdevelopment.belong;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by cmeehan on 23-Sep-16.
 */

public class ViewClassDetails extends AppCompatActivity {
    private TextView classTextView;

    @Override
    protected void onCreate(Bundle savedStateInstances){
        super.onCreate(savedStateInstances);

        // Receive the intent
        Intent intent = getIntent();
        String courseName = intent.getExtras().getString("COURSE_NAME");
        String courseNumber = intent.getExtras().getString("COURSE_NUMBER");


        // Start the activity
        setContentView(R.layout.class_information_layout);

        // Set the title to the class code
        setTitle(courseNumber);


        // Set the title to the class code
        classTextView = (TextView) findViewById(R.id.className);
        classTextView.setText(courseName);


    }
}
