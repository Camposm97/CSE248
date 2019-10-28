package com.campos.model;

public class CurrentSchedule {
    private static Schedule current;

    private CurrentSchedule() {

    }

    public static Schedule getCurrent() {
        return current;
    }

    public static void setCurrent(Schedule current) {
        CurrentSchedule.current = current;
    }
}
