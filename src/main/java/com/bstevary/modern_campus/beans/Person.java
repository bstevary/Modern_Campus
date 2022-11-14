package com.bstevary.modern_campus.beans;

public class Person {


    String  F_Name, S_Name, L_Name,  Email,  N_ID, Contacts, Status ;

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
