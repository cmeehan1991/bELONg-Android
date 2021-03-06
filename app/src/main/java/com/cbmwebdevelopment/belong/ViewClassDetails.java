package com.cbmwebdevelopment.belong;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by cmeehan on 23-Sep-16.
 */

public class ViewClassDetails extends AppCompatActivity {
    private TextView classTextView;
    private String courseName, courseNumber;
    private Intent intent;
    private ArrayList<String> homeworkList;
    private ListView homework;
    private final String TAG = "View Class Details";

    @Override
    protected void onCreate(Bundle savedStateInstances) {
        super.onCreate(savedStateInstances);

        // Receive the intent
        intent = getIntent();
        courseName = intent.getStringExtra("COURSE_NAME");
        courseNumber = intent.getStringExtra("COURSE_NUMBER");
        Log.d(TAG, " onCreate Course Name: " + courseName);
        Log.d(TAG, " onCreate Course Number: " + courseNumber);

        // Start the activity
        setContentView(R.layout.class_information_layout);

        // Set the title to the class code
        setTitle(courseNumber);

        // Set the title to the class code
        classTextView = (TextView) findViewById(R.id.className);
        classTextView.setText(courseName);

        homework = (ListView) findViewById(R.id.homeworkList);
        homeworkList = new ArrayList<>();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                homeworkList);
        homework.setAdapter(adapter);
    }


    public void addHomework(View view) {
        Intent intent = new Intent(this, AddHomeworkActivity.class);
        intent.putExtra("COURSE_NAME", courseName);
        intent.putExtra("COURSE_NUMBER", courseNumber);
        intent.putStringArrayListExtra("HOMEWORK_LIST", homeworkList);
        Log.i(TAG, "addHomework COURSE_NUMBER: "+courseNumber);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            courseName = data.getStringExtra("COURSE_NAME");
            courseNumber = data.getStringExtra("COURSE_NUMBER");
            Log.d(TAG, courseName);
            Log.d(TAG, courseNumber);
            Toast.makeText(this, "Back Worked", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onActivityResult");
        }
    }
}
