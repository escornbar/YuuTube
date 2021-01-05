package yuu.tube;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UserOps {
    
    public void userProfile(){
        Scanner s = new Scanner(System.in);
        Video a=new Video();
        
        boolean status=true;
        while(status){
            System.out.println("\n--USER PROFILE-");
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
            }
            if(userchoice3==4){
                break;
            }
        }
    }
    
    public void userSettings(){
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
    
    public void changeEmail(){
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
    
    public void changePassword(){
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
    
    public void changeUsername(){
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
    
    public void deleteAccount(){
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
}
