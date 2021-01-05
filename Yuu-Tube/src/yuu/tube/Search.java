/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuu.tube;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yuu.tube.Video.vidTitle;

/**
 *
 * @author syaam
 */
public class Search {
    
    public static void searchVid(){
        Scanner s=new Scanner(System.in);
        vidTitle=s.nextLine();
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        try{
            String SQL="SELECT * FROM public.videostats WHERE title=?";
            st = conn.prepareStatement(SQL); 
            st.setString(1, vidTitle);
            rs = st.executeQuery();
            if  (rs.next()) { 
                String title = rs.getString("title");
                int views = rs.getInt("views");
                int likes = rs.getInt("likes");
                int dislikes = rs.getInt("dislikes");
                System.out.println("Title: "+title+
                                   "\nViews: "+views+
                                   "\nLikes: "+likes+
                                   "\nDislikes: "+dislikes);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
