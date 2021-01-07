/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ravin
 */
public class JavaA {

//SELECT MIN(EmpSalary) FROM Salary WHERE EmpSalary IN
//(SELECT TOP 3 EmpSalary FROM Salary ORDER BY EmpSalary DESC)

    public void trendingvids(){
        
        MyConnection connection = new MyConnection();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        conn = connection.getConnection();
        
        System.out.println("-----Trending on Yuu-Tube-----");
        
        for (int i = 1; i < 6; i++) {
        
        try{
            
            String SQL = "SELECT * FROM public.videostats WHERE views="
                         +"(SELECT MIN(views) FROM public.videostats WHERE views IN "
                         +"(SELECT TOP "+i+" views FROM public.videostats ORDER BY views DESC))";
            
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            if (rs.next()){
                String title = rs.getString("title");
                int views = rs.getInt("views");
                int likes = rs.getInt("likes"); 
                int dislikes = rs.getInt("dislikes");
                System.out.println("#"+i+" "+title+"\nViews: "+views+" Likes: "+likes+" Dislikes: "+dislikes);
            }
        }catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        
    }
    
}


