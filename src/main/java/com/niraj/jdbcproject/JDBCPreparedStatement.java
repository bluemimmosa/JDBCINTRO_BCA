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
public class JDBCPreparedStatement {
    static Connection conn;
   
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prime","root","root");
            String query = "INSERT INTO `prime`.`student` "
                    + "(`id`, `name`, `faculty`, `roll_no`) VALUES (?,?,?,?);";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, 5);
            pst.setString(2, "Abhinna");
            pst.setString(3, "BIM");
            pst.setInt(4, 6);
            pst.executeUpdate(); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
