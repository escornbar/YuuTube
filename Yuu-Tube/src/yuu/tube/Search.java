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
import static yuu.tube.Video.*;
import static yuu.tube.YuuTube.*;
import static yuu.tube.UserOps.*;

/**
 *
 * @author syaam
 */
public class Search {
    
    public static void searchVid(){
        Scanner s=new Scanner(System.in);
        System.out.print("Search: ");
        vidTitle=s.nextLine();
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        try{
            String SQL="SELECT * FROM public.videostats WHERE title LIKE ?";
            st = conn.prepareStatement(SQL); 
            st.setString(1, "%"+vidTitle+"%");
            rs = st.executeQuery();
            for(int i=0;i<6;i++){
                if  (rs.next()) {
                    System.out.println("");
                    System.out.println(i+1+".");
                    String title = rs.getString("title");
                    int views = rs.getInt("views");
                    int likes = rs.getInt("likes");
                    int dislikes = rs.getInt("dislikes");
                    System.out.println("Title: "+title+
                                       "\nViews: "+views+
                                       "\nLikes: "+likes+
                                       "\nDislikes: "+dislikes);
                } 
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void chosenVid(String title){
        Scanner s=new Scanner(System.in);
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        boolean status=true;
        vidTitle=title;
        try{
            String SQL="SELECT * FROM public.videostats WHERE title=?";
            st = conn.prepareStatement(SQL); 
            st.setString(1, vidTitle);
            rs = st.executeQuery();
            if  (rs.next()) { 
                String filename = rs.getString("filename");
                while(status){
                        System.out.println("\n[1] Play Video\n[2] Like\n[3] Dislike\n[4] Comment\n[5] Back to home");
                        int userchoiceVideo=s.nextInt();
                        switch(userchoiceVideo){
                            case 1:
                                playVideo();
                                break;
                            case 2:
                                likeVid();
                                break;
                            case 3:
                                dislikeVid();
                                break;
                            case 4:
                                break;
                            case 5:
                                home();
                                break;
                            default:
                                System.out.println("Invalid input");
                                break;
                        }
                    }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
