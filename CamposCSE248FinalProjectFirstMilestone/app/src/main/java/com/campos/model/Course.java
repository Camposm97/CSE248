package com.campos.model;

import com.campos.R;

public class Course {
    private String courseNumber;
    private String courseTitle;
    private String courseDesc;
    private String prereq;
    private String offeredAt;
    private double numOfCredits;

    public Course(String courseNumber, String courseTitle, String courseDesc, String prereq, String offeredAt, double numOfCredits) {
        this.courseNumber = courseNumber;
        this.courseTitle = courseTitle;
        this.courseDesc = courseDesc;
        this.prereq = prereq;
        this.offeredAt = offeredAt;
        this.numOfCredits = numOfCredits;

    }

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

	public String getOfferedAt() {
		return offeredAt;
	}

	public void setOfferedAt(String offeredAt) {
		this.offeredAt = offeredAt;
	}

	public double getNumOfCredits() {
		return numOfCredits;
	}

	public void setNumOfCredits(double numOfCredits) {
		this.numOfCredits = numOfCredits;
	}

	@Override
	public String toString() {
		return "Course [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle + ", courseDesc=" + courseDesc
				+ ", prereq=" + prereq + ", offeredAt=" + offeredAt + ", numOfCredits=" + numOfCredits + "]";
	}
}
