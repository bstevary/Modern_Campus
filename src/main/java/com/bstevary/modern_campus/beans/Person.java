package com.bstevary.modern_campus.beans;

public class Person {


    String  F_Name, S_Name, L_Name,  Email,  N_ID, Contacts, Status ;

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public String getS_Name() {
        return S_Name;
    }

    public void setS_Name(String s_Name) {
        S_Name = s_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getN_ID() {
        return N_ID;
    }

    public void setN_ID(String n_ID) {
        N_ID = n_ID;
    }

    public String getContacts() {
        return Contacts;
    }

    public void setContacts(String contacts) {
        Contacts = contacts;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Person() {
    }

    public Person(String f_Name, String s_Name, String l_Name, String email, String n_ID, String contacts, String status) {
        F_Name = f_Name;
        S_Name = s_Name;
        L_Name = l_Name;
        Email = email;
        N_ID = n_ID;
        Contacts = contacts;
        Status = status;
    }
}
