package yuu.tube;

import java.util.*;
import javax.swing.JFrame;
import static yuu.tube.Search.*;
import static yuu.tube.UserOps.*;
import static yuu.tube.Trending.*;
import static yuu.tube.RegisterForm.*;

public class YuuTube {
       
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        boolean status=true;
        
        main:
        while(status){
            System.out.println("");
            System.out.println("****   ****  ****  ****  ****  ****  ************  ****  ****  *******    ************");
            System.out.println(" *  * *  *   *  *  *  *  *  *  *  *  *****  *****  *  *  *  *  *  * *  *  *  *********");
            System.out.println("  *  *  *    *  *  *  *  *  *  *  *      *  *      *  *  *  *  *  * *  *  *  *       ");
            System.out.println("   *   *     *  *  *  *  *  *  *  *      *  *      *  *  *  *  *      *   *  ******");
            System.out.println("    * *      *  *  *  *  *  *  *  *      *  *      *  *  *  *  *      *   *  ******");
            System.out.println("    * *      *  *  *  *  *  *  *  *      *  *      *  *  *  *  *  * *  *  *  *");
            System.out.println("    * *      *  ****  *  *  ****  *      *  *      *  ****  *  *  * *  *  *  *********");
            System.out.println("    ***      **********  **********      ****      **********  *******    ************");
            System.out.println("[1] Login\n[2] Register for an account\n[3] Quit");
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
        trendingVideos();
        main:
        while(status){
            System.out.println("\n--HOME--");
            System.out.println("[1] User Profile\n[2] Search a Video\n[3] Search a Channel\n[4] Play Trending Video\n[5] Logout");
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
}

