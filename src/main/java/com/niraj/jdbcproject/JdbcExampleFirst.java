/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.jdbcproject;


/**
 *
 * @author Niraj Khadka
 */
import java.sql.*;
public class JdbcExampleFirst {
    static Connection conn;
   
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prime","root","root");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student;");
            while(rs.next()){
                System.out.println("[Id: "+rs.getInt("id")+", Name: "+rs.getString("name")+", Faculty: "+rs.getString("faculty")+", Roll No: "+rs.getInt("roll_no")+"]");
                
                
            }
//            st.close();
//            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
