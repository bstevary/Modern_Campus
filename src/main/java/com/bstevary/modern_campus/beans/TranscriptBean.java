package com.bstevary.modern_campus.beans;

public class TranscriptBean {
String CODE;
    String Reg_No;
    String Unit_ID;
    String Exam_Marks;
    String Cat_Marks;
    String Term_ID;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    String Status;

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
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

    public String getExam_Marks() {
        return Exam_Marks;
    }

    public void setExam_Marks(String exam_Marks) {
        Exam_Marks = exam_Marks;
    }

    public String getCat_Marks() {
        return Cat_Marks;
    }

    public void setCat_Marks(String cat_Marks) {
        Cat_Marks = cat_Marks;
    }

    public String getTerm_ID() {
        return Term_ID;
    }

    public void setTerm_ID(String term_ID) {
        Term_ID = term_ID;
    }

    public TranscriptBean(String CODE, String reg_No, String unit_ID, String exam_Marks, String cat_Marks, String term_ID, String status) {
        this.CODE = CODE;
        Reg_No = reg_No;
        Unit_ID = unit_ID;
        Exam_Marks = exam_Marks;
        Cat_Marks = cat_Marks;
        Term_ID = term_ID;
        Status = status;
    }
}
