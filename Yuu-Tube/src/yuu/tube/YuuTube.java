package yuu.tube;


import java.util.*;
import javax.swing.JFrame;
import java.awt.Desktop;
import java.io.*;
import java.sql.SQLException;

public class YuuTube {
       
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("WELCOME TO YUUTUBE");
        
        boolean status=true;
        main:
        while(status){
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
                    status=false;
                    break main;
                    
                default:
                    System.out.println("\nInvalid input\n");
            }
        }
        System.out.println("\nSee you later!");
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
                    UserOps c=new UserOps();
                    c.userProfile();
                    break;
                
                case 2:
                    Video d=new Video();
                    System.out.print("Search: ");
                    d.searchVid();
                    while(status){
                        System.out.println("\n[1] Play video\n[2] Like\n[3] Dislike\n[4] Comment\n[5] Back to Home");
                        int userchoiceVideo=s.nextInt();
                        switch(userchoiceVideo){
                            case 1:
                                d.playVideo();
                                break;
                            case 2:
                                d.likeVid();
                                break;
                            case 3:
                                d.dislikeVid();
                                break;
                            case 4:
                                break;
                            case 5:
                                break home;
                        }
                    }
                    break;
                        
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

