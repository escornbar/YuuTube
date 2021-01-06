package yuu.tube;

import java.sql.*;

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
