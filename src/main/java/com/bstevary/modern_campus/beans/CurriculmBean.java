package com.bstevary.modern_campus.beans;

public class CurriculmBean {
    protected String Caricullum_ID, Semester, Yrs_O_Stdy, Unit_ID;

    public String getCaricullum_ID() {
        return Caricullum_ID;
    }

    public void setCaricullum_ID(String caricullum_ID) {
        Caricullum_ID = caricullum_ID;
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

    public CurriculmBean(String caricullum_ID, String semester, String yrs_O_Stdy, String unit_ID) {
        Caricullum_ID = caricullum_ID;
        Semester = semester;
        Yrs_O_Stdy = yrs_O_Stdy;
        Unit_ID = unit_ID;
    }
}
