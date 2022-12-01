package com.bstevary.modern_campus.beans;

public class CurriculmBean {
    private String  Course_ID, Semester, Yrs_O_Stdy, Unit_ID;

    public CurriculmBean(String course_ID, String semester, String yrs_O_Stdy, String unit_ID) {
        Course_ID = course_ID;
        Semester = semester;
        Yrs_O_Stdy = yrs_O_Stdy;
        Unit_ID = unit_ID;
    }

    public CurriculmBean(String course_ID, String semester, String yrs_O_Stdy) {
        Course_ID = course_ID;
        Semester = semester;
        Yrs_O_Stdy = yrs_O_Stdy;
    }

    public CurriculmBean(String unit_ID) {
        Unit_ID = unit_ID;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String course_ID) {
        Course_ID = course_ID;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getYrs_O_Stdy() {
        return Yrs_O_Stdy;
    }

    public void setYrs_O_Stdy(String yrs_O_Stdy) {
        Yrs_O_Stdy = yrs_O_Stdy;
    }

    public String getUnit_ID() {
        return Unit_ID;
    }

    public void setUnit_ID(String unit_ID) {
        Unit_ID = unit_ID;
    }
}
