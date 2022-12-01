package com.bstevary.modern_campus.beans;

public class StudentBean extends Person {
    protected String Reg_No,Cohort_ID, Course_ID,Type;

    public StudentBean( String email,  String contacts,  String reg_No) {
        super( email,  contacts );
        Reg_No = reg_No;
    }

    public String getReg_No() {
        return Reg_No;
    }

    public void setReg_No(String reg_No) {
        Reg_No = reg_No;
    }

    public String getCohort_ID() {
        return Cohort_ID;
    }

    public void setCohort_ID(String cohort_ID) {
        Cohort_ID = cohort_ID;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String course_ID) {
        Course_ID = course_ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


    public StudentBean(String reg_No) {
        Reg_No = reg_No;
    }

    public StudentBean(String f_Name, String s_Name, String l_Name, String email, String n_ID, String contacts, String status, String reg_No, String cohort_ID, String course_ID, String type) {
        super(f_Name, s_Name, l_Name, email, n_ID, contacts, status);
        Reg_No = reg_No;
        Cohort_ID = cohort_ID;
        Course_ID = course_ID;
        Type = type;
    }
}
