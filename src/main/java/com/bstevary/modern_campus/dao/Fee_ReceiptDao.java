package com.bstevary.modern_campus.dao;

import com.bstevary.modern_campus.beans.Fee_ReceiptBean;
import com.bstevary.modern_campus.beans.TranscriptBean;
import com.bstevary.modern_campus.config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Fee_ReceiptDao {
    Database database;
    String viewFeebalamce= "SELECT * FROM fee_Receipt";
    String showFeeBal = "SELECT Debit ,Credit WHERE RegNo = ?";

    public  double showFeeBal(String reg_no) {
        Connection connection = database.getConnection();
        double balance = 0;
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(showFeeBal);

            while (resultSet.next()) {
                double Debit = resultSet.getDouble("Debit");
                double Credit = resultSet.getDouble("Credit");
                balance +=(Debit-Credit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }

    //ALFRED
        // creating fee balance
        public Fee_ReceiptBean viewFinance(String reg_no) {
            Connection connection = database.getConnection();
            Fee_ReceiptBean receiptBean = null;
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(viewFeebalamce);

                while (resultSet.next()) {
                    String Rcpt_ID = resultSet.getString("RCPT_ID");
                    String Term_ID = resultSet.getString("Term_ID");
                    String Reg_No = resultSet.getString("Reg_No");
                    double Debit = resultSet.getDouble("Debit");
                    double Credit = resultSet.getDouble("Credit");
                    receiptBean = new Fee_ReceiptBean(Rcpt_ID, Term_ID, Reg_No, Debit, Credit);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return receiptBean;
        }







}
