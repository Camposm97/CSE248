package com.campos.util;

import android.util.Log;

import com.campos.app.MainActivity;
import com.campos.model.Course;
import com.campos.model.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Util {
	public static String[] emitSubjectArr() {
		String[] arr = new String[Subject.values().length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Subject.values()[i].toString();
		}
		return arr;
	}

	public static String[] emitCourseNumArr(Subject subject) {
		Set<String> courseSet = MainActivity.COURSES.keySet();
		Iterator<String> iterator = courseSet.iterator();
		ArrayList<String> list = new ArrayList<>();
		while (iterator.hasNext()) {
			String courseNumber = iterator.next();
//			Log.println(Log.ASSERT, "0", courseNumber + " | " + subject);
			if (courseNumber.contains(subject.toString())) {
				list.add(courseNumber);
			}
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		return arr;
	}

	public static List<String> emitCourseList(List<Course> courseList) {
		List<String> list = new LinkedList<>();
		for (Course c : courseList) {
			list.add(c.getCourseNumber());
		}
		return list;
	}
}
