package com.bstevary.modern_campus.beans;

public class SchoolBean {
    String School_ID, Sch_Name, Descriptions;

    public SchoolBean(String school_ID, String sch_Name, String descriptions) {
        School_ID = school_ID;
        Sch_Name = sch_Name;
        Descriptions = descriptions;
    }

    public String getSchool_ID() {
        return School_ID;
    }

    public void setSchool_ID(String school_ID) {
        School_ID = school_ID;
    }

    public String getSch_Name() {
        return Sch_Name;
    }

    public void setSch_Name(String sch_Name) {
        Sch_Name = sch_Name;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }
}
