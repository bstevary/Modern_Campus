package com.bstevary.modern_campus.beans;

public class RegistrationBean {
    String Row_id, Reg_No, Unit_ID, Term_ID, Status;

    public RegistrationBean(String row_id, String reg_No, String unit_ID, String term_ID, String status) {
        Row_id = row_id;
        Reg_No = reg_No;
        Unit_ID = unit_ID;
        Term_ID = term_ID;
        Status = status;
    }

    public RegistrationBean(String reg_No, String unit_ID, String term_ID) {
        Reg_No = reg_No;
        Unit_ID = unit_ID;
        Term_ID = term_ID;
    }

    public String getRow_id() {
        return Row_id;
    }

    public void setRow_id(String row_id) {
        Row_id = row_id;
    }

    public String getReg_No() {
        return Reg_No;
    }

    public void setReg_No(String reg_No) {
        Reg_No = reg_No;
    }

    public String getUnit_ID() {
        return Unit_ID;
    }

    public void setUnit_ID(String unit_ID) {
        Unit_ID = unit_ID;
    }

    public String getTerm_ID() {
        return Term_ID;
    }

    public void setTerm_ID(String term_ID) {
        Term_ID = term_ID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
