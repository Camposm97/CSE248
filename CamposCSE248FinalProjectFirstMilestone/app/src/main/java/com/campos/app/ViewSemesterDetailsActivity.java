package com.campos.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.campos.R;
import com.campos.model.Course;
import com.campos.model.CurrentSemester;
import com.campos.model.Semester;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class ViewSemesterDetailsActivity extends AppCompatActivity {
    private Semester sem;

    public ViewSemesterDetailsActivity() {
        this.sem = CurrentSemester.getCurrent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_semester_details);
        initControls();
    }

    public void initControls() {
        TextView tvSemesterName = findViewById(R.id.tvSemesterName);
        tvSemesterName.setText(sem.getName() + " | Credits Taking: " + sem.getTotalCreditsTaking());
        ListView lvCourses = findViewById(R.id.lvSemesterDetails);
        LinkedList<String> list = new LinkedList<>();
        for (Course c : sem.getCourseList()) {
            list.add(c.getCourseNumber());
        }
        ArrayAdapter<String> arrAdapter;
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvCourses.setAdapter(arrAdapter);
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewCourseDetails(sem.getCourseList().get(position));
            }
        });
    }

    public void viewCourseDetails(Course c) {
        Intent intent = new Intent(this, null);
        intent.putExtra("COURSE_NUMBER", c.getCourseNumber());
        startActivity(intent);
    }
}
