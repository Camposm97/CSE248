package com.campos.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.campos.R;
import com.campos.model.CurrentSchedule;
import com.campos.model.CurrentSemester;
import com.campos.model.Schedule;
import com.campos.model.ScheduleList;
import com.campos.model.Semester;

import java.util.LinkedList;
import java.util.List;

public class ViewScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);
        initControls();
    }

    public void initControls() {
        ListView lvSchedule = findViewById(R.id.lvSchedules);
        LinkedList<Schedule> list = ScheduleList.getList();
        List<String> strList = new LinkedList<>();
        for (Schedule s : list) {
            strList.add(s.getName());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strList);
        lvSchedule.setAdapter(arrayAdapter);
        ListView lvCourses = findViewById(R.id.lvSchedules);

        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Schedule s = ScheduleList.getList().get(position);
                CurrentSchedule.setCurrent(s);
                Log.println(Log.ASSERT, "Test", "Is Null? " + (s == null));
                Log.println(Log.ASSERT, "Current Schedule", s.getName() + ", " + s.getSemesterList().size());
                openViewScheduleDetailsActivity();
            }
        });
    }

    public void openViewScheduleDetailsActivity() {
        Intent intent = new Intent(this, ViewScheduleDetailsActivity.class);
        startActivity(intent);
    }
}
