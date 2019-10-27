package com.campos.model;

import java.util.LinkedList;

public class Schedule {
    private LinkedList<Semester> semesterList;

    public Schedule() {
        semesterList = new LinkedList<>();
    }

    public LinkedList<Semester> getSemesterList() {
        return semesterList;
    }
}
