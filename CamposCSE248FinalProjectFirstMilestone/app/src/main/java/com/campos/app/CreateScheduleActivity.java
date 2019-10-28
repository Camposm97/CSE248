package com.campos.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.campos.R;
import com.campos.model.CurrentSchedule;
import com.campos.model.CurrentSemester;
import com.campos.model.Schedule;
import com.campos.model.ScheduleList;
import com.campos.model.Semester;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.LinkedList;

public class CreateScheduleActivity extends AppCompatActivity {
    private Schedule schedule;

    public CreateScheduleActivity() {
        schedule = new Schedule();
        CurrentSchedule.setCurrent(schedule);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);
        initControls();
    }

    public void initControls() {
        FloatingActionButton fab = findViewById(R.id.fabAddSem);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createSemester();
            }
        });
        ListView lv = findViewById(R.id.lvSemesters);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Semester s = schedule.getSemesterList().get(position);
                CurrentSemester.setCurrent(s);
                openCreateSemesterActivity();
            }
        });
        Toolbar toolbar = findViewById(R.id.toolBarCreateSchedule);
        setSupportActionBar(toolbar);
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
                closeActivity();
                break;
        }
        return true;
    }

    private void openCreateSemesterActivity() {
        Intent intent = new Intent(this, CreateSemesterActivity.class);
        startActivity(intent);
    }

    private void closeActivity() {
        TextInputEditText til = findViewById(R.id.tilScheName);
        schedule.setName(til.getText().toString());
        ScheduleList.getList().add(schedule);
        finish();
    }

    private void createSemester() {
        Semester s = new Semester();
        schedule.getSemesterList().add(s);
        LinkedList<String> list = new LinkedList<>();
        for (Semester s1 : schedule.getSemesterList()) {
            list.add(s1.getName());
        }
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        ListView lv = findViewById(R.id.lvSemesters);
        lv.setAdapter(arrayAdapter);
        Toast.makeText(CreateScheduleActivity.this, "Created Semester!", Toast.LENGTH_SHORT).show();
    }
}
