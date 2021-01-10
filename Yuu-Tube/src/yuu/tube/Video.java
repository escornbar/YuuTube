package yuu.tube;

import java.awt.Desktop;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.*;
import static yuu.tube.UserOps.*;
import static yuu.tube.RegisterForm.*;

public class Video {
    static String vidTitle, filename;
    static int vidLikes, vidDislikes;
    static String vidComments;
    static int vidViews;
    final static String fileDestination = "C:\\Video Files\\";

    public Video() {
        this.vidLikes=0;
        this.vidDislikes=0;
        this.vidViews=0;
        this.vidTitle=null;
        this.filename=null;
        this.vidComments=null;
    }

    //Method to upload a video
    public static void uploadVideo(){
        boolean flag1=true;
        File f = new File("C:\\Video Files\\");
        if(!f.exists()){
            f.mkdir();
        }
         
        //display guide to upload and prompt user for needed details
        final int BUFFERSIZE = 4 * 1024;
        Scanner s = new Scanner(System.in);
        System.out.println("\n--VIDEO UPLOAD GUIDE--");
        System.out.println("Enter the file path of the video to be uploaded: C:/My_Folder/Videos");
        System.out.println("Enter the name of the video: test.mp4");
        System.out.println("\n--YUUTUBE VIDEO UPLOAD--");
        System.out.print("Enter the file path of the folder the video is in: ");
        String sourceFilePath = s.nextLine();
        System.out.print("Enter the file name: ");
        String outputFilePath = s.nextLine();
        System.out.print("Enter video title: ");
        vidTitle=s.nextLine();
        
        //upload the video
        try(
            FileInputStream fin = new FileInputStream(new File(sourceFilePath + "/" + outputFilePath));
            FileOutputStream fout = new FileOutputStream(new File(fileDestination + outputFilePath));
            ){
            byte[] buffer = new byte[BUFFERSIZE];
            System.out.println("Upload completed");
            while(fin.available() != 0) {
                fin.read(buffer);
                fout.write(buffer);
            }
            
        } catch(Exception e) {
            System.out.println("Something went wrong! Reason: " + e.getMessage());
            flag1=false;
            }
        
        //if upload successful, the details will uploaded to the db
        if(flag1==true){
        PreparedStatement st;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        int rowsAffected=0;
        String SQL="INSERT INTO videostats(title, likes, dislikes, views, filename)"+"values(?,?,?,?,?)";
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, vidTitle);
            st.setInt(2, vidLikes);
            st.setInt(3, vidDislikes);
            st.setInt(4, vidViews);
            st.setString(5, outputFilePath);
            rowsAffected=st.executeUpdate();
            } catch (SQLException ex) {
            System.out.println("Error in uploading to database");
            }
        
        //fetch the initial videos uploaded of a user from the db
        try{
            String SQL2="SELECT * FROM public.credentials WHERE username=?";
            st=MyConnection.getConnection().prepareStatement(SQL2);
            st.setString(1, username);
            rs=st.executeQuery();
            if(rs.next()) {
                vids=rs.getInt("videoscount");
            }
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        
        //update the number of videos uploaded into the db
        try{
            String SQL3="UPDATE credentials "+"SET videoscount = ?"+"WHERE username = ?";
            st=MyConnection.getConnection().prepareStatement(SQL3);
            st.setInt(1, vids+1);
            st.setString(2, username);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        }
    }
    
    //Method to play video
    public static void playVideo(){
        int rowsAffected=0;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        
        //fetch the number of views of a video from db
        try{
            String SQL="SELECT * FROM public.videostats WHERE title=?";
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, vidTitle);
            rs=st.executeQuery();
            if(rs.next()){
                vidViews=rs.getInt("views");}
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        
        //update the number of views into the db
        try{
            String SQL="UPDATE videostats "+"SET views = ?"+"WHERE title = ?";
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setInt(1, vidViews+1);
            st.setString(2, vidTitle);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error updating to database");
            }
        
        //fetch the filename from db and play video
        try{
            String SQL="SELECT * FROM public.videostats WHERE title=?";
            st = conn.prepareStatement(SQL);
            st.setString(1, vidTitle);
            rs = st.executeQuery();
            if(rs.next()){
                filename=rs.getString("filename");
            }
            File f = new File(fileDestination+filename);
            Desktop.getDesktop().open(f);
        } catch(IOException e1){
        } catch (SQLException ex) {
          Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Method to delete video
    public static void deleteVideo(){
        Scanner s =new Scanner(System.in);
        System.out.print("Enter name of video: ");
        String video = s.nextLine();
        PreparedStatement st;
        String SQL="DELETE FROM public.videostats WHERE filename = ?";
        int rowsAffected=0;
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, video);
            rowsAffected = st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error deleting in database");
        }
        File f = new File(fileDestination + video); 
        if (f.delete()) { 
            System.out.println("Video Deleted: " + f.getName());
        } else {
            System.out.println("Failed to delete the video");
        }
    }
}
