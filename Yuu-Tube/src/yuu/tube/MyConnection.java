/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuu.tube;
import java.sql.*;
/**
 *
 * @author syaam
 */
public class MyConnection{
    public static Connection getConnection(){ 
        Connection conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yuutube","postgres","syaamil");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
        
    }

    
       
}
