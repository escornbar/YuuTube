/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class trendingVid {
    
    public void trendingVideos(){
   
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
    
    //get number of videos in db
        try{
            String SQL = "SELECT title FROM videostats ORDER BY views DESC LIMIT 5";
            rs = st.executeQuery();
            System.out.println("Trending on Yuu-Tube:");
            int i=0;
            if(rs.next()) {
                i++;
                System.out.print("#" + i);
                System.out.println(rs.getString("views"));
            }
        }catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
   
    

