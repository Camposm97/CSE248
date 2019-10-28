package com.campos.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.campos.R;
import com.campos.model.Schedule;
import com.campos.model.ScheduleList;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class ViewScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_schedule);

        ListView lvSchedule = findViewById(R.id.lvSchedule);
        LinkedList<Schedule> list = ScheduleList.getList();
        List<String> strList = new LinkedList<>();
        for (Schedule s : list) {
            strList.add(s.getName() + ": " + s.getDateCreated());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strList);
        lvSchedule.setAdapter(arrayAdapter);
    }


}
