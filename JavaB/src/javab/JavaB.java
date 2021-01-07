
package javab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JavaB {

    public static void trendingVideos(){
   
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();

        //get number of videos in db
        //fetch number of videos in db and sort by views in descending order
        try{
            String SQL = "SELECT title FROM public.videostats ORDER BY views DESC LIMIT 5";
            st = conn.prepareStatement(SQL);
            rs = st.executeQuery();
            System.out.println("\n--Trending on YuuTube--");
            //loop to print top 5 videos with highest views
            for(int i=1;i<6;i++){
                int views = rs.getInt("views");
                int likes = rs.getInt("likes"); 
                int dislikes = rs.getInt("dislikes");
                if(rs.next()) {
                    System.out.print("#" +i+" ");
                    System.out.println(rs.getString("title"));
                    System.out.println("Views: "+views+" Likes: "+likes+" Dislikes: "+dislikes);
                }
            }
        }catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


