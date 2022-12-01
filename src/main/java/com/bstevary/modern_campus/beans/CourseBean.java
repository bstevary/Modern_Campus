package com.bstevary.modern_campus.beans;

public class CourseBean {
    protected String Course_ID, Course_Name, Dept_ID;

    public CourseBean(String course_ID, String course_Name, String dept_ID) {
        Course_ID = course_ID;
        Course_Name = course_Name;
        Dept_ID = dept_ID;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String course_ID) {
        Course_ID = course_ID;
    }

    public String getCourse_Name() {
        return Course_Name;
    }

    public void setCourse_Name(String course_Name) {
        Course_Name = course_Name;
    }

    public String getDept_ID() {
        return Dept_ID;
    }

    public void setDept_ID(String dept_ID) {
        Dept_ID = dept_ID;
    }
}
