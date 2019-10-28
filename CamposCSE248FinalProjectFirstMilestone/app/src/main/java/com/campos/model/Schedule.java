package com.campos.model;

import java.util.Date;
import java.util.LinkedList;

public class Schedule {
    private String name;
    private Date dateCreated;
    private LinkedList<Semester> semesterList;

    public Schedule() {
        this.dateCreated = new Date();
        semesterList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Semester> getSemesterList() {
        return semesterList;
    }
}
