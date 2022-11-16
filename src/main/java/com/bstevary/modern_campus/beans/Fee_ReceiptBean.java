package com.bstevary.modern_campus.beans;

public class Fee_ReceiptBean {
protected    String Rcpt_ID, Term_ID, Reg_No;
protected double Debit, Credit;

    public Fee_ReceiptBean(String rcpt_ID, String term_ID, String reg_No, double debit, double credit) {
        Rcpt_ID = rcpt_ID;
        Term_ID = term_ID;
        Reg_No = reg_No;
        Debit = debit;
        Credit = credit;
    }

    public String getRcpt_ID() {
        return Rcpt_ID;
    }

    public void setRcpt_ID(String rcpt_ID) {
        Rcpt_ID = rcpt_ID;
    }

    public String getTerm_ID() {
        return Term_ID;
    }

    public void setTerm_ID(String term_ID) {
        Term_ID = term_ID;
    }

    public String getReg_No() {
        return Reg_No;
    }

    public void setReg_No(String reg_No) {
        Reg_No = reg_No;
    }

    public double getDebit() {
        return Debit;
    }

    public void setDebit(double debit) {
        Debit = debit;
    }

    public double getCredit() {
        return Credit;
    }

    public void setCredit(double credit) {
        Credit = credit;
    }
}
