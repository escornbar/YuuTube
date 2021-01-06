package yuu.tube;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import static yuu.tube.Video.*;
import static yuu.tube.RegisterForm.*;
import static yuu.tube.Search.*;

public class UserOps {
    static int subs=0, vids=0;
    
    public static void userProfile(){
        Scanner s = new Scanner(System.in);
        Video a=new Video();
        
        boolean status=true;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        while(status){
            System.out.println("\n--USER PROFILE-");
            try{
                String SQL="SELECT * FROM public.credentials WHERE username=?";
                st = conn.prepareStatement(SQL); 
                st.setString(1, username);
                rs = st.executeQuery();
                if  (rs.next()) { 
                    int subscount = rs.getInt("subscriberscount");
                    int vidscount = rs.getInt("videoscount");
                    System.out.println("Username: "+username+
                                       "\nSubscribers: "+subscount+
                                       "\nVideos: "+vidscount);
                } 
            } catch (SQLException ex) {
                Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.println("[1] Upload Video\n[2] Delete Video\n[3] User Settings\n[4] Return to home");
            System.out.print("What do you want to do today: ");
            int userchoice3=s.nextInt();
            switch(userchoice3){
                case 1:
                    a.uploadVideo();
                    break;
                case 2:
                    a.deleteVideo();
                    break;
                case 3:
                    userSettings();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            if(userchoice3==4){
                break;
            }
        }
    }
    
    public static void userSettings(){
        Scanner s = new Scanner(System.in);
        Video a=new Video();
        
        boolean status=true;
        while(status){
            System.out.println("\n--USER SETTINGS-");
            System.out.println("[1] Change Email\n[2] Change Password\n[3] Change Username\n[4] Delete Account\n[5] Return to profile");
            System.out.print("What do you want to do today: ");
            int userchoice3=s.nextInt();
            switch(userchoice3){
                case 1:
                    changeEmail();
                    break;
                case 2:
                    changePassword();
                    break;
                case 3:
                    changeUsername();
                    break;
                case 4:
                    System.out.print("\n[1] Yes\n[Any key] Cancel\nAre you sure to delete your account?: ");
                    int c=s.nextInt();
                    if(c==1){
                        deleteAccount();
                        System.out.println("Account deleted");
                    }else{
                        break;
                    }
                default:
                    System.out.println("Invalid input");
            }
            if(userchoice3==5){
                break;
            }
        }
    }
    
    public static void changeEmail(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password=s.nextLine();
        System.out.print("Enter your new email: ");
        String email=s.nextLine();
        PreparedStatement st;
        String SQL="UPDATE credentials "+"SET email = ?"+"WHERE password = ?";
        int rowsAffected=0;
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, email);
            st.setString(2, password);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
    }
    
    public static void changePassword(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email=s.nextLine();
        System.out.print("Enter your new password: ");
        String password=s.nextLine();
        PreparedStatement st;
        String SQL="UPDATE credentials "+"SET password = ?"+"WHERE email = ?";
        int rowsAffected=0;
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, password);
            st.setString(2, email);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
    } 
    
    public static void changeUsername(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password=s.nextLine();
        System.out.print("Enter your new username: ");
        String username=s.nextLine();
        PreparedStatement st;
        String SQL="UPDATE credentials "+"SET username = ?"+"WHERE password = ?";
        int rowsAffected=0;
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, username);
            st.setString(2, password);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
    }
    
    public static void deleteAccount(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email=s.nextLine();
        PreparedStatement st;
        String SQL="DELETE FROM public.credentials WHERE email = ?";
        int rowsAffected=0;
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, email);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
    }
    
    public static void likeVid(){
        int rowsAffected=0;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        try{
            String SQL="SELECT * FROM public.videostats WHERE title=?";
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, vidTitle);
            rs=st.executeQuery();
            if(rs.next()) {   
                vidLikes=rs.getInt("likes");
            }
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
                
        try{
            String SQL2="UPDATE videostats "+"SET likes = ?"+"WHERE title = ?";
            st=MyConnection.getConnection().prepareStatement(SQL2);
            st.setInt(1, vidLikes+1);
            st.setString(2, vidTitle);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        showVidStats();
    }
    
    public static void dislikeVid(){
        int rowsAffected=0;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null;
        ResultSet rs = null;
        conn = connection.getConnection();
        try{
            String SQL="SELECT * FROM public.videostats WHERE title=?";
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, vidTitle);
            rs=st.executeQuery();
            if(rs.next()) {
                vidDislikes=rs.getInt("dislikes");
            }
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        
        try{
            String SQL2="UPDATE videostats "+"SET dislikes = ?"+"WHERE title = ?";
            st=MyConnection.getConnection().prepareStatement(SQL2);
            st.setInt(1, vidDislikes+1);
            st.setString(2, vidTitle);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        showVidStats();
    }
    
    public static void showVidStats(){
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
                String comment = rs.getString("comments");
                System.out.println("Title: "+title+
                                   "\nViews: "+views+
                                   "\nLikes: "+likes+
                                   "\nDislikes: "+dislikes+
                                   "\nComment: "+comment);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void subscribeUser(){
        int rowsAffected=0;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        try{
            String SQL="SELECT * FROM public.credentials WHERE username=?";
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, username1);
            rs=st.executeQuery();
            if(rs.next()) {
                subs=rs.getInt("subscriberscount");
            }
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        
        try{
            String SQL="UPDATE credentials "+"SET subscriberscount = ?"+"WHERE username = ?";
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setInt(1, subs+1);
            st.setString(2, username1);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
    }
    
    public static void commentVid(){
        Scanner s=new Scanner(System.in);
        int rowsAffected=0;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null;
        conn = connection.getConnection();
        System.out.print("Enter your comment: ");
        vidComments=s.nextLine();
        try{
            String SQL2="UPDATE videostats "+"SET comments = ?"+"WHERE title = ?";
            st=MyConnection.getConnection().prepareStatement(SQL2);
            st.setString(1, vidComments);
            st.setString(2, vidTitle);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        showVidStats();
    }
    
    public static void showUserStats(){
        
    }
}