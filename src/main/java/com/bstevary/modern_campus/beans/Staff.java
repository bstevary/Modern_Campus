package com.bstevary.modern_campus.beans;

public class Staff extends Person {
   String PF_No,Role_ID,Dept_ID, Salary;

   public Staff(String PF_No) {
      this.PF_No = PF_No;
   }

   public Staff(String f_Name, String s_Name, String l_Name, String email, String n_ID, String contacts, String status, String PF_No, String role_ID, String dept_ID, String salary) {
      super(f_Name, s_Name, l_Name, email, n_ID, contacts, status);
      this.PF_No = PF_No;
      Role_ID = role_ID;
      Dept_ID = dept_ID;
      Salary = salary;
   }
}
