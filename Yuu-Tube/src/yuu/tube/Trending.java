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
    
        //get number of videos in db
        try{
            String SQL = "SELECT title FROM public.videostats ORDER BY views DESC LIMIT 5";
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            System.out.println("\n--Trending on YuuTube--");
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
