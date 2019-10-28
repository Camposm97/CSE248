package com.campos.model;

import java.util.LinkedList;

public class ScheduleList {
    private static LinkedList<Schedule> list = new LinkedList<>();

    public static LinkedList<Schedule> getList() {
        return list;
    }

    public static void setList(LinkedList<Schedule> list) {
        ScheduleList.list = list;
    }
}
