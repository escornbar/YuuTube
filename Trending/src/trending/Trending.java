/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trending;

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
public class Trending {

    private String fileDestination = "C:\\Users\\syaam\\Videos\\";

    public void trendingvids(){
        
        MyConnection connection = new MyConnection();
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        conn = connection.getConnection();
        
        System.out.println("Trending on Yuu-Tube");
        
        //1st video
        try{
            String SQL = "SELECT * FROM public.videostats WHERE views=(SELECT MAX(views) FROM public.videostats)";
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            if (rs.next()){
                String title = rs.getString("title");
                int views = rs.getInt("views");
                int likes = rs.getInt("likes"); 
                int dislikes = rs.getInt("dislikes");
                System.out.println("1. "+title+"\nViews: "+views+" Likes: "+likes+" Dislikes: "+dislikes);
                System.out.println("File Destination: "+fileDestination+title);
            }
        }catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //2nd video
        try{
            String SQL = "SELECT * FROM public.videostats WHERE views="
                    + "(SELECT MAX(views) FROM public.videostats WHERE views NOT IN "
                    + "(SELECT MAX(views) FROM public.videostats))";
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            if (rs.next()){
                String title = rs.getString("title");
                int views = rs.getInt("views");
                int likes = rs.getInt("likes"); 
                int dislikes = rs.getInt("dislikes");
                System.out.println("2. "+title+"\nViews: "+views+" Likes: "+likes+" Dislikes: "+dislikes);
                System.out.println("File Destination: "+fileDestination+title);
            }
        }catch(SQLException ex){
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //3rd, 4th, 5th videos
        int j = 2;
        for (int i=0;i<3;i++){
            try{
                String SQL = "SELECT * FROM public.videostats ORDER BY views DESC LIMIT j,1"; //2,1; 3,1; 4,1
                st = conn.prepareStatement(SQL);
                rs = st.executeQuery();
                if (rs.next()){
                    String title = rs.getString("title");
                    int views = rs.getInt("views");
                    int likes = rs.getInt("likes"); 
                    int dislikes = rs.getInt("dislikes");
                    System.out.println(j++ +". "+title+"\nViews: "+views+" Likes: "+likes+" Dislikes: "+dislikes);
                    System.out.println("File Destination: "+fileDestination+title);
                }
            }catch(SQLException ex){
                Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    } 
}


