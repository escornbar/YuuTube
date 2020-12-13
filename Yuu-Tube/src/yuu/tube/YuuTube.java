package yuu.tube;


import java.util.*;
import javax.swing.JFrame;
public class YuuTube {
       
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("PRESS:\n1 TO LOGIN\n2 TO REGISTER FOR A NEW ACCOUNT\n");
        int userchoice=s.nextInt();
        if(userchoice==1){
            LoginForm lgf=new LoginForm();
            lgf.setVisible(true);
            lgf.pack();
            lgf.setLocationRelativeTo(null);
            lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        else if(userchoice==2){
            RegisterForm rgf=new RegisterForm();
            rgf.setVisible(true);
            rgf.pack();
            rgf.setLocationRelativeTo(null);
            rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    
    }
}

