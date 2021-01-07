package yuu.tube;

import java.sql.*;
import java.util.logging.*;

public class Trending {
    
    public static void trendingVideos(){
   
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
    
        //fetch number of videos in db and sort by views in descending order
        try{
            String SQL = "SELECT title FROM public.videostats ORDER BY views DESC LIMIT 5";
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            System.out.println("\n--Trending on YuuTube--");
            //loop to print top 5 videos with highest views
            for(int i=1;i<6;i++){
                if(rs.next()) {
                    System.out.print("#" +i+" ");
                    System.out.println(rs.getString("title"));
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
