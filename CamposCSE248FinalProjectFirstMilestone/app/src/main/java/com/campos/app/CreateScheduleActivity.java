package com.campos.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.campos.R;
import com.campos.model.Schedule;

public class CreateScheduleActivity extends AppCompatActivity {
    private Schedule schedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        schedule = new Schedule();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);
    }
}
