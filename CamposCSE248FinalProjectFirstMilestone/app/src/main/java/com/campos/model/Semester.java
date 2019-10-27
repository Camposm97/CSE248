package com.campos.model;

import java.util.LinkedList;

public class Semester {
    private LinkedList<Course> courseList;

    public Semester() {
        this.courseList = new LinkedList<>();
    }

    public LinkedList<Course> getCourseList() {
        return courseList;
    }
}
