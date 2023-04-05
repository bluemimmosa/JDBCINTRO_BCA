/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.jdbcproject;

import java.sql.*;

/**
 *
 * @author Niraj Khadka
 */
public class ScrollResultSet {
    static Connection conn;
   
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prime","root","root");
            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("SELECT * FROM student;");
            System.out.println("All records:");
            while(rs.next()){
                System.out.println("[Id: "+rs.getInt("id")+", Name: "+rs.getString("name")+", Faculty: "+rs.getString("faculty")+", Roll No: "+rs.getInt("roll_no")+"]");  
            }
            System.out.println("I am pinting to last record now, but i will  go to first record.");
            rs.first();
            System.out.println("[Id: "+rs.getInt("id")+", Name: "+rs.getString("name")+", Faculty: "+rs.getString("faculty")+", Roll No: "+rs.getInt("roll_no")+"]");
            System.out.println("The third record is:");
            rs.absolute(3);
            System.out.println("[Id: "+rs.getInt("id")+", Name: "+rs.getString("name")+", Faculty: "+rs.getString("faculty")+", Roll No: "+rs.getInt("roll_no")+"]");
            //rs.moveToInsertRow();
            rs.updateInt(1, 10);
            rs.updateString(2, "Bishan Poudel");
            rs.updateString(3, "BIM");
            rs.updateInt(4, 100);
            rs.updateRow();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
