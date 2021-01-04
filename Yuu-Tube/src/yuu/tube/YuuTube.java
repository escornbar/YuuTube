package yuu.tube;


import java.util.*;
import javax.swing.JFrame;
import java.awt.Desktop;
import java.io.*;

public class YuuTube {
       
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("WELCOME TO YUUTUBE");
        
        boolean status=true;
        firstlevel:
        while(status){
            System.out.println("[1] Login\n[2] Register for an account\n[3] Quit");
            System.out.print("What do you want to do today: ");
            int userchoice1=s.nextInt();
            switch(userchoice1){
                case 1:
                    LoginForm lgf=new LoginForm();
                    lgf.setVisible(true);
                    lgf.pack();
                    lgf.setLocationRelativeTo(null);
                    lgf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    break;
               
                case 2:
                    RegisterForm rgf=new RegisterForm();
                    rgf.setVisible(true);
                    rgf.pack();
                    rgf.setLocationRelativeTo(null);
                    rgf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    break;
                    
                case 3:
                    break firstlevel;
                    
                default:
                    System.out.println("\nInvalid input\n");
            }
            
            System.out.print("Click ENTER when done");
            s.nextLine();
            s.nextLine();
            
            while(status){
                System.out.println("\n--HOME--");
                System.out.println("[1] User Profile\n[2] Search\n[3] Quit");
                System.out.print("What do you want to do today: ");
                int userchoice2=s.nextInt();
                switch(userchoice2){
                    case 1:
                        UserOps c=new UserOps();
                        c.userProfile();
                        break;
                
                    case 2:
                        Search d=new Search();
                        System.out.print("Enter video title: ");
                        d.searchVid(s.nextLine());
                        break;
                        
                    case 3:
                        status=false;
                        break firstlevel;
                        
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        }
        System.out.println("See you later!");
    }
}

