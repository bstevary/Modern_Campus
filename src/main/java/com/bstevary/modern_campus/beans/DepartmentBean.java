package com.bstevary.modern_campus.beans;

public class DepartmentBean {

    String Dept_ID, D_Name, School_ID, Descriptions;

    public DepartmentBean(String dept_ID, String d_Name, String school_ID, String descriptions) {
        Dept_ID = dept_ID;
        D_Name = d_Name;
        School_ID = school_ID;
        Descriptions = descriptions;
    }

    public String getDept_ID() {
        return Dept_ID;
    }

    public void setDept_ID(String dept_ID) {
        Dept_ID = dept_ID;
    }

    public String getD_Name() {
        return D_Name;
    }

    public void setD_Name(String d_Name) {
        D_Name = d_Name;
    }

    public String getSchool_ID() {
        return School_ID;
    }

    public void setSchool_ID(String school_ID) {
        School_ID = school_ID;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }
}
