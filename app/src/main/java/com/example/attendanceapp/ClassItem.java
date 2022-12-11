package com.example.attendanceapp;

public class ClassItem {
    private  String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(String courseSection) {
        this.courseSection = courseSection;
    }

    private String courseSection;

    public ClassItem(String courseCode, String courseSection) {
        this.courseCode = courseCode;
        this.courseSection = courseSection;
    }
}
