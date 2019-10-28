package com.campos.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.campos.R;
import com.campos.model.CurrentSchedule;
import com.campos.model.CurrentSemester;
import com.campos.model.Schedule;
import com.campos.model.Semester;

import java.util.LinkedList;

/**
 * Displays a list view of the current schedule containing the semesters.
 */
public class ViewScheduleDetailsActivity extends AppCompatActivity {
    private static Schedule s = CurrentSchedule.getCurrent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule_details);
        initControls();
    }

    public void initControls() {
        TextView tvScheduleName = findViewById(R.id.tvScheduleName);
        tvScheduleName.setText(s.getName());
        initListView();
    }

    public void initListView() {
        ListView lvSemesterDetails = findViewById(R.id.lvSemesterDetails);
        LinkedList<String> list = loadSemesterDetails();
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvSemesterDetails.setAdapter(arrAdapter);
        lvSemesterDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viewSemesterDetailsActivity(position);
            }
        });
    }

    public void viewSemesterDetailsActivity(int position) {
        Semester semester = s.getSemesterList().get(position);
        CurrentSemester.setCurrent(semester);
        Intent intent = new Intent(this, ViewSemesterDetailsActivity.class);
        startActivity(intent);
    }

    public LinkedList<String> loadSemesterDetails() {
        LinkedList<Semester> semesterList = s.getSemesterList();
        LinkedList<String> list = new LinkedList<>();
        for (Semester sem : semesterList) {
            String name = sem.getName();
            String strNumOfCourses = "Courses: " + sem.getCourseList().size();
            String creditsTaking = "Credits: " + sem.getTotalCreditsTaking();
            list.add(name + " | " + strNumOfCourses + " | " + creditsTaking);
        }
        return list;
    }
}
