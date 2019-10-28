package com.campos.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.campos.R;
import com.campos.model.Course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    public static final TreeMap<String, Course> COURSES = new TreeMap<>();
    private static final String MY_GITHUB = "http://www.github.com/Camposm97";

    private void loadCourses() {
        final String SRC = "courses.txt";
        try {
            InputStream is = super.getAssets().open(SRC);
            InputStreamReader irs = new InputStreamReader(is);
            Scanner in = new Scanner(irs);
            while (in.hasNextLine()) {
                String courseNum = in.nextLine();
                String courseTitle = in.nextLine();
                String courseDesc = in.nextLine();
                String prereq = in.nextLine();
                String offerAt = in.nextLine();
                double numOfCredits = Double.valueOf(in.nextLine());
                in.nextLine();
//                Log.println(Log.ASSERT, "0", courseNum + ", " + courseTitle + ", " + courseDesc + ", " + prereq + ", " + offerAt + ", " + numOfCredits);
                prereq = prereq.substring(14, prereq.length() - 3);
//                Log.println(Log.ASSERT, "0", prereq);
                Course c = new Course(courseNum, courseTitle, courseDesc, prereq, offerAt, numOfCredits);
                COURSES.put(c.getCourseNumber(), c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        loadCourses();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
    }

    public void initControls() {
        findViewById(R.id.btSchedule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ViewScheduleActivity.class);
            }
        });
        findViewById(R.id.btCreateSchedule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(CreateScheduleActivity.class);
            }
        });
        findViewById(R.id.btGithub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyGithub();
            }
        });
        Toolbar toolbar = findViewById(R.id.tb_Main);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_github:
                openMyGithub();
                break;
        }
        return true;
    }

    private void openActivity(Class c) {
        startActivity(new Intent(this, c));
    }

    private void openMyGithub() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MY_GITHUB));
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        startActivity(intent);
    }
}
