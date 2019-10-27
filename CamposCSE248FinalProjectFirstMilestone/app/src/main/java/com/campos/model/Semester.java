package com.campos.model;

import java.util.LinkedList;

public class Semester {
    private LinkedList<Course> courseList;

    public Semester() {
        this.courseList = new LinkedList<>();
    }

    public double getTotalCreditsTaking() {
        double totalNumOfCredits = 0;
        for (Course c : courseList)
            totalNumOfCredits += c.getNumOfCredits();
        return totalNumOfCredits;
    }

    public LinkedList<Course> getCourseList() {
        return courseList;
    }
}
