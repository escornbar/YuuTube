package yuu.tube;


import java.util.*;
import javax.swing.JFrame;
import java.awt.Desktop;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static yuu.tube.Video.*;
import static yuu.tube.Search.*;
import static yuu.tube.UserOps.*;

public class YuuTube {
       
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        boolean status=true;
        
        main:
        while(status){
            System.out.println("WELCOME TO YUUTUBE");
            System.out.println("\n[1] Login\n[2] Register for an account\n[3] Quit");
            System.out.print("What do you want to do today: ");
            int userchoiceMain=s.nextInt();
            switch(userchoiceMain){
                case 1:
                    LoginForm lgf=new LoginForm();
                    lgf.setVisible(true);
                    lgf.pack();
                    lgf.setLocationRelativeTo(null);
                    lgf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    System.out.print("Click ENTER when done");
                    s.nextLine();
                    s.nextLine();
                    home();
                    break;
               
                case 2:
                    RegisterForm rgf=new RegisterForm();
                    rgf.setVisible(true);
                    rgf.pack();
                    rgf.setLocationRelativeTo(null);
                    rgf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    System.out.print("Click ENTER when done");
                    s.nextLine();
                    s.nextLine();
                    home();
                    break;
                    
                case 3:
                    System.out.println("\nSee you later!");
                    System.exit(0);
                    break main;
                    
                default:
                    System.out.print("\nInvalid input\n");
                    break;
            }
        }
    }
    
    public static void home(){
        Scanner s = new Scanner(System.in);
        boolean status=true;
        while(status){
            System.out.println("\n--HOME--");
            System.out.println("[1] User Profile\n[2] Search\n[3] Logout");
            System.out.print("What do you want to do today: ");
            int userchoiceHome=s.nextInt();
            home:
            switch(userchoiceHome){
                case 1:
                    userProfile();
                    break;
                
                case 2:
                    searchVid();
                    while(status){
                    System.out.print("\nEnter video title or enter 'home' to go back: ");
                    s.nextLine();
                    String option=s.nextLine();
                    chosenVid(option);
                    if(option.equalsIgnoreCase("home")){
                        break home;
                    }else{
                        System.out.println("Invalid input");
                        break;
                    }}
                        
                case 3:
                status=false;
                break;
                        
                default:
                System.out.println("Invalid input");
                break;
            }
        }
    }
}

