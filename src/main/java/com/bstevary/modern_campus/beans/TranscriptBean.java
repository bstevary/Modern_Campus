package com.bstevary.modern_campus.beans;

public class TranscriptBean {
String CODE, Reg_No, Unit_ID, Exam_Marks, Cat_Marks, Term_ID;

    public TranscriptBean(String reg_No, String unit_ID, String exam_Marks, String cat_Marks, String term_ID) {
        Reg_No = reg_No;
        Unit_ID = unit_ID;
        Exam_Marks = exam_Marks;
        Cat_Marks = cat_Marks;
        Term_ID = term_ID;
    }
}
