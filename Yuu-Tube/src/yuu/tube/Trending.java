package yuu.tube;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.*;
import static yuu.tube.Video.fileDestination;
import static yuu.tube.Video.vidTitle;
import static yuu.tube.Video.vidViews;

public class Trending {
    
    public static void trendingVideos(){
   
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();

        //get number of videos in db
        //fetch number of videos in db and sort by views in descending order
        try{
            String SQL = "SELECT * FROM public.videostats ORDER BY views DESC LIMIT 5";
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            System.out.println("\n--Trending on YuuTube--");
            //loop to print top 5 videos with highest views
            for(int i=1;i<6;i++){
                if(rs.next()) {
                    int views = rs.getInt("views");
                    int likes = rs.getInt("likes"); 
                    int dislikes = rs.getInt("dislikes");
                    System.out.print("#" +i+" ");
                    System.out.println(rs.getString("title"));
                    System.out.println("Views: "+views+" Likes: "+likes+" Dislikes: "+dislikes);
                    System.out.println("");
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static void playTrendingVids(){
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        int rowsAffected=0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter trending video number: ");
        int trendingVidNum = s.nextInt();
        
        switch(trendingVidNum){
            case 1:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY views DESC LIMIT 1 OFFSET 0";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            vidTitle=rs.getString("title");
                            File f = new File(fileDestination + rs.getString("filename"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
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
                break;
                
            case 2:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY views DESC LIMIT 1 OFFSET 1";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            vidTitle=rs.getString("title");
                            File f = new File(fileDestination + rs.getString("filename"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
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
                break;

            case 3:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY views DESC LIMIT 1 OFFSET 2";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            vidTitle=rs.getString("title");
                            File f = new File(fileDestination + rs.getString("filename"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
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
                break;

            case 4:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY views DESC LIMIT 1 OFFSET 3";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            vidTitle=rs.getString("title");
                            File f = new File(fileDestination + rs.getString("filename"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
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
                break;
                
            case 5:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY views DESC LIMIT 1 OFFSET 4";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            vidTitle=rs.getString("title");
                            File f = new File(fileDestination + rs.getString("filename"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
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
                break;    

            default:
            System.out.println("Invalid input");
            break;
            }
    }
}
