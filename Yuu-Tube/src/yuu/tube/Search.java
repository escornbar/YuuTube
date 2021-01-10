package yuu.tube;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import static yuu.tube.Video.*;
import static yuu.tube.UserOps.*;

public class Search {
    static String username1;
    
    //method to search vid, it will also display matching titles
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
        System.out.print("\nEnter chosen video title or enter 'home' to go back: ");
        String option=s.nextLine();
        chosenVid(option);
    }
    
    //method to choose vid after search, then display actions for chosen video
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
                video:
                while(status1){
                        System.out.println("\n[1] Play Video\n[2] Like\n[3] Dislike\n[4] Comment\n[5] Back to home");
                        System.out.print("Your choice: ");
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
                                break video;
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
    
    //method to search for channel, also display option to subscribe
    public static void searchChannel(){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter channel name: ");
        username1=s.nextLine();
        boolean status=true;
        MyConnection connection=new MyConnection();
        Connection conn = null; 
        PreparedStatement st = null; 
        ResultSet rs = null;
        conn = connection.getConnection();
        try{
            String SQL="SELECT * FROM public.credentials WHERE username=?";
            st = conn.prepareStatement(SQL); 
            st.setString(1, username1);
            rs = st.executeQuery();
            if  (rs.next()) {
                System.out.println("");
                String uname = rs.getString("username");
                int subscount = rs.getInt("subscriberscount");
                int vidscount = rs.getInt("videoscount");
                System.out.println("Channel: "+uname+
                                   "\nSubscribers: "+subscount+
                                   "\nVideos: "+vidscount+
                                   "\nBadges: ");
                if(subscount>=100000000){
                        System.out.println("People Favourite Diamond");
                    }else if(subscount>=10000000){
                        System.out.println("People Favourite Platinum");
                    }else if(subscount>=1000000){
                        System.out.println("People Favourite Gold");
                    }else if(subscount>=500000){
                        System.out.println("People Favourite Silver");
                    }else if(subscount>=100000){
                        System.out.println("People Favourite Bronze");
                    }else{
                        System.out.println("No badges earned");
                    }
                
                    if(vidscount>=5000){
                        System.out.println("Content Creator Diamond");
                    }else if(vidscount>=1000){
                        System.out.println("Content Creator Platinum");
                    }else if(vidscount>=100){
                        System.out.println("Content Creator Gold");
                    }else if(vidscount>=50){
                        System.out.println("Content Creator Silver");
                    }else if(vidscount>=10){
                        System.out.println("Content Creator Bronze");
                    }
                subscribe:
                while(status){
                    System.out.println("\n[1] Subscribe\n[2] Back to home");
                    System.out.print("Your choice: ");
                    int choice=s.nextInt();
                    switch(choice){
                        case 1:
                            subscribeUser();
                        case 2:
                            break subscribe;
                        default:
                            System.out.println("Invalid input");
                    }
                }
                System.out.println("");
            } else{
                System.out.println("Cannot find channel");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
