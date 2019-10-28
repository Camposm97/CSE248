package com.campos.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.campos.R;
import com.campos.model.Course;
import com.campos.model.CurrentSemester;
import com.campos.model.Season;
import com.campos.model.Semester;
import com.campos.model.Subject;
import com.campos.util.Util;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CreateSemesterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_semester);
        initControls();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.create_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_done:
                closeThisActivity();
                break;
        }
        return true;
    }

    public void initControls() {
        Spinner sp = findViewById(R.id.spSeason);
        ArrayList<String> list = new ArrayList<String>();
        for (Season s : Season.values()) {
            list.add(s.toString());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);

        FloatingActionButton fabAddCourse = findViewById(R.id.fabAddCourse);
        fabAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySubjectDialog();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolBarCreateSemester);
        setSupportActionBar(toolbar);
    }

    public void closeThisActivity() {
        Spinner spSeason = findViewById(R.id.spSeason);
        TextView tfYear = findViewById(R.id.tfYear);
        String season = (String) spSeason.getSelectedItem();
        String year = tfYear.getText().toString();
        CurrentSemester.getCurrent().setName(season + "-" + year);
//        CurrentSchedule.getCurrent().getSemesterList().add(CurrentSemester.getCurrent());
        finish();
    }

    public void displaySubjectDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Choose Subject");
        String[] subjectArr = Util.emitSubjectArr();
        alert.setItems(subjectArr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Subject subject = Subject.values()[which];
                Log.println(Log.ASSERT, "0", "User Picked: " + subject);
                displayCourseDialog(subject);
            }
        });
        alert.show();
    }

    public void displayCourseDialog(Subject subject) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Choose " + subject + " Course");
        final String[] courseNumArr = Util.emitCourseNumArr(subject);
        alert.setItems(courseNumArr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String courseNumber = courseNumArr[which];
                addCourseToView(courseNumber);
            }
        });
        alert.show();
    }

    public void addCourseToView(String courseNumber) {
        Log.println(Log.ASSERT, "0", "User Picked: " + courseNumber);
        Semester sem = CurrentSemester.getCurrent();
        final LinkedList<Course> courseList = sem.getCourseList();
        courseList.add(MainActivity.COURSES.get(courseNumber));
        List<String> list = Util.emitCourseList(courseList);
        final ListView lvCourses = findViewById(R.id.lvCourses);
        ArrayAdapter<String> arrAdapter;
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvCourses.setAdapter(arrAdapter);
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openViewCourseActivity(courseList.get(position));
            }
        });
        lvCourses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                courseList.remove(courseList.get(position));
                updateLvCourses(courseList);
                return true;
            }
        });
    }

    public void openViewCourseActivity(Course c) {
        Intent intent = new Intent(this, CourseDetailsActivity.class);
        intent.putExtra("COURSE_NUMBER", c.getCourseNumber());
        startActivity(intent);
    }

    public void updateLvCourses(LinkedList<Course> courseList) {
        ListView lvCourses = findViewById(R.id.lvCourses);
        List<String> list = Util.emitCourseList(courseList);
        ArrayAdapter<String> arrAdapter;
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lvCourses.setAdapter(arrAdapter);
    }
}
