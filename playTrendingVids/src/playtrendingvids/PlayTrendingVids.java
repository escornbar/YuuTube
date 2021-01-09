
package playtrendingvids;

import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlayTrendingVids {

    
    public static void main(String[] args) {
        //Update in the main class
        while(status){
            System.out.println("\n--HOME--");
            System.out.println("[1] User Profile\n[2] Search a Video\n[3] Search a Channel\n[4] Play a Trending Video\n[5] Logout");
            System.out.print("What do you want to do today: ");
            int userchoiceHome=s.nextInt();
            home:
            switch(userchoiceHome){
                case 1:
                    userProfile();
                    break;
                
                case 2:
                    searchVid();
                    break;
                        
                case 3:
                    searchChannel();
                    break;
                    
                case 4:
                    playTrendingVids();
                    break;
                
                case 5:
                    System.out.println("See you later, "+username+"!");
                    break main;
                    
                default:
                System.out.println("Invalid input");
                break;
            }
        }
    }
    
    //Method to play trending videos, input is the number at which a video is trending.
    static void playTrendingVids(){
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter trending video number: ");
        int trendingVidNum = s.nextInt();
        
        switch(trendingVidNum){
            case 1:
                try{
                    String SQL = "SELECT * FROM public.videostats WHERE views=(SELECT MAX(views) FROM public.videostats)";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            File f = new File("C:/Users/user/YuuTube/" + rs.getString("title"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case 2:
                try{
                    String SQL = "SELECT * FROM public.videostats WHERE views="
                                 + "(SELECT MAX(views) FROM public.videostats WHERE views NOT IN "
                                 + "(SELECT MAX(views) FROM public.videostats))";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            File f = new File("C:/Users/user/YuuTube/" + rs.getString("title"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case 3:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY DESC views LIMIT 2,1";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            File f = new File("C:/Users/user/YuuTube/" + rs.getString("title"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case 4:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY DESC views LIMIT 3,1";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            File f = new File("C:/Users/user/YuuTube/" + rs.getString("title"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
            case 5:
                try{
                    String SQL = "SELECT * FROM public.videostats ORDER BY DESC views LIMIT 4,1";
                    st = conn.prepareStatement(SQL);
                    rs = st.executeQuery();
                    if(rs.next()) {
                        try{
                            File f = new File("C:/Users/user/YuuTube/" + rs.getString("title"));
                            Desktop.getDesktop().open(f);
                        }catch(IOException e1){
                        }
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;    

            default:
                System.out.println("Invalid input");
                break;
        }
    }
    
}








