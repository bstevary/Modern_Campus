package com.bstevary.modern_campus.beans;

public class Student extends Person {
    String Reg_No,Cohort_ID, Course_ID,Type,D_O_B;

    public Student(String reg_No) {
        Reg_No = reg_No;
    }

    public Student(String f_Name, String s_Name, String l_Name, String email, String n_ID, String contacts, String status, String reg_No, String cohort_ID, String course_ID, String type, String d_O_B) {
        super(f_Name, s_Name, l_Name, email, n_ID, contacts, status);
        Reg_No = reg_No;
        Cohort_ID = cohort_ID;
        Course_ID = course_ID;
        Type = type;
        D_O_B = d_O_B;
    }
}
