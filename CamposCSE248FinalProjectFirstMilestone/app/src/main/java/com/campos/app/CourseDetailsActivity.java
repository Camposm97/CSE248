package com.campos.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.campos.R;
import com.campos.model.Course;

public class CourseDetailsActivity extends AppCompatActivity {
    private String courseNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);
        initControls();
    }

    public void initControls() {
        courseNumber = getIntent().getStringExtra("COURSE_NUMBER");
        Log.println(Log.ASSERT, "COURSE_DETAILS", courseNumber);
        Course c = MainActivity.COURSES.get(courseNumber);
        TextView tvCourseNum = findViewById(R.id.tvCourseNumber);
        TextView tvCourseTitle = findViewById(R.id.tvCourseTitle);
        TextView tvCourseDesc = findViewById(R.id.tvCourseDesc);
        TextView tvNumOfCredits = findViewById(R.id.tvNumOfCredits);
        TextView tvPrereq = findViewById(R.id.tvPrereq);
        TextView tvOfferedAt = findViewById(R.id.tvOfferedAt);
        tvCourseNum.setText(c.getCourseNumber());
        tvCourseTitle.setText("Course Title: " + c.getCourseTitle());
        tvCourseDesc.setText("Course Description: " + c.getCourseDesc());
        tvNumOfCredits.setText("Number of Credits: " + c.getNumOfCredits());
        tvPrereq.setText("Prerequesites: " + c.getPrereq());
        tvOfferedAt.setText(c.getOfferedAt());
    }
}
