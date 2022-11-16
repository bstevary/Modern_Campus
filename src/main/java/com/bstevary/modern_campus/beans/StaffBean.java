package com.bstevary.modern_campus.beans;

public class StaffBean extends Person {
   String PF_No, R_NAME,Dept_ID, Salary;

   public String getPF_No() {
      return PF_No;
   }

   public void setPF_No(String PF_No) {
      this.PF_No = PF_No;
   }

   public String getR_NAME() {
      return R_NAME;
   }

   public void setR_NAME(String r_NAME) {
      R_NAME = r_NAME;
   }

   public String getDept_ID() {
      return Dept_ID;
   }

   public void setDept_ID(String dept_ID) {
      Dept_ID = dept_ID;
   }

   public String getSalary() {
      return Salary;
   }

   public void setSalary(String salary) {
      Salary = salary;
   }

   public StaffBean(String PF_No) {
         this.PF_No = PF_No;
   }

   public StaffBean(String f_Name, String s_Name, String l_Name, String email, String n_ID, String contacts, String status, String PF_No, String role_ID, String dept_ID, String salary) {
      super(f_Name, s_Name, l_Name, email, n_ID, contacts, status);
      this.PF_No = PF_No;
      R_NAME = role_ID;
      Dept_ID = dept_ID;
      Salary = salary;
   }
}
