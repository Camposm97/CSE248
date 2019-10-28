package com.campos.model;

import java.util.LinkedList;

public class Semester {
    private static int idNumber = 0;
    private String name;
    private LinkedList<Course> courseList;

    public Semester() {
        this.name = "Semester #" + idNumber++;
        this.courseList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
