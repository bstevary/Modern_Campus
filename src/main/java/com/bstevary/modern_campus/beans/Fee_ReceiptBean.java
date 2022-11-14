package com.bstevary.modern_campus.beans;

public class Fee_ReceiptBean {
    String Rcpt_ID, Term_ID, Reg_No, Debit, Credit;
    byte identify;

    public Fee_ReceiptBean(String term_ID, String reg_No, String credit, byte identify) {
        Term_ID = term_ID;
        Reg_No = reg_No;
        Credit = credit;
        this.identify = identify;
    }

    public Fee_ReceiptBean(String term_ID, String reg_No, String debit) {
        Term_ID = term_ID;
        Reg_No = reg_No;
        Debit = debit;
    }
}
