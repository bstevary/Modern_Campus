package com.bstevary.modern_campus.beans;

public class UnitBean {
    String Unit_ID, Code_Name, Instructor, Dept_ID, Descriptions;
    double Cost;

    public UnitBean(String unit_ID, String code_Name, String instructor, String dept_ID, String descriptions, double cost) {
        Unit_ID = unit_ID;
        Code_Name = code_Name;
        Instructor = instructor;
        Dept_ID = dept_ID;
        Descriptions = descriptions;
        Cost = cost;
    }

    public UnitBean(String reg_no, String unit_id, String term_id) {

    }

    public String getUnit_ID() {
        return Unit_ID;
    }

    public void setUnit_ID(String unit_ID) {
        Unit_ID = unit_ID;
    }

    public String getCode_Name() {
        return Code_Name;
    }

    public void setCode_Name(String code_Name) {
        Code_Name = code_Name;
    }

    public String getInstructor() {
        return Instructor;
    }

    public void setInstructor(String instructor) {
        Instructor = instructor;
    }

    public String getDept_ID() {
        return Dept_ID;
    }

    public void setDept_ID(String dept_ID) {
        Dept_ID = dept_ID;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }
}
