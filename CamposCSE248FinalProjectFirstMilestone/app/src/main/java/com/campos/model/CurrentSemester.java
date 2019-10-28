package com.campos.model;

public class CurrentSemester {
    public static Semester current = null;

    private CurrentSemester() {

    }

    public static Semester getCurrent() {
        return current;
    }

    public static void setCurrent(Semester current) {
        CurrentSemester.current = current;
    }
}
