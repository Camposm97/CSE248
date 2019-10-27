package com.campos.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.campos.R;
import com.campos.model.Course;

import androidx.appcompat.app.AppCompatActivity;

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
        initBtns();
    }

    public void initBtns() {
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
    }

    private void openActivity(Class c) {
        startActivity(new Intent(this, c));
    }

    private void openMyGithub() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(MY_GITHUB));
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        startActivity(intent);
    }

//    private void loadSpinnerItems(Spinner sp1) {
//        Set<String> keySet = COURSES.keySet();
//        LinkedList<String> list = new LinkedList<>();
//        for (String s : keySet) {
//            list.add(s + " - " + COURSES.get(s).getCourseTitle());
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        sp1.setAdapter(arrayAdapter);
//    }
}
