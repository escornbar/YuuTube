/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuu.tube;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yuu.tube.Video.*;
import static yuu.tube.YuuTube.*;
import static yuu.tube.UserOps.*;
import static yuu.tube.RegisterForm.*;

/**
 *
 * @author syaam
 */
public class Search {
    static String username1;
    
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
            for(int i=0;i<5;i++){
                if  (rs.next()) {
                    System.out.println("");
                    System.out.println(i+1+".");
                    String title = rs.getString("title");
                    int views = rs.getInt("views");
                    int likes = rs.getInt("likes");
                    int dislikes = rs.getInt("dislikes");
                    String comment = rs.getString("comments");
                    System.out.println("Title: "+title+
                                       "\nViews: "+views+
                                       "\nLikes: "+likes+
                                       "\nDislikes: "+dislikes+
                                       "\nComment: "+comment);
                }
            }    
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.print("\nEnter video title or enter 'home' to go back: ");
        String option=s.nextLine();
        chosenVid(option);
    }
    
    public static void chosenVid(String title){
        Scanner s=new Scanner(System.in);
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        boolean status1=true;
        vidTitle=title;
        try{
            String SQL="SELECT * FROM public.videostats WHERE title=?";
            st = conn.prepareStatement(SQL); 
            st.setString(1, vidTitle);
            rs = st.executeQuery();
            if  (rs.next()) { 
                String filename = rs.getString("filename");
                out:
                while(status1){
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
                                commentVid();
                                break;
                            case 5:
                                break out;
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
    
    public static void searchChannel(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter channel name: ");
        username1=s.nextLine();
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        boolean flag=true;
        try{
            String SQL="SELECT * FROM public.credentials WHERE username=?";
            st = conn.prepareStatement(SQL); 
            st.setString(1, username1);
            rs = st.executeQuery();
            if  (rs.next()) {
                System.out.println("");
                String uname = rs.getString("username");
                int subscribers = rs.getInt("subscriberscount");
                int videos = rs.getInt("videoscount");
                System.out.println("Channel: "+uname+
                                   "\nSubscribers: "+subscribers+
                                   "\nVideos: "+videos);
                System.out.println("\n[1] Subscribe\n[2] Back to home");
                int choice=s.nextInt();
                    if(choice==1){
                        subscribeUser();
                    }else{
                        home();
                    }
            }else{
                System.out.println("Cannot find channel");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
