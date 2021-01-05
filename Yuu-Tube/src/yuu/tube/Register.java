/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuu.tube;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author syaam
 */
public class Register {
    static String email, password, retypepassword, username;
    
    public Register() {
        this.email=email;
    }
    /*
    public String getUsername() {
        return username;
    }
    
    public void Register(){
        Scanner s=new Scanner(System.in);
        System.out.print("Email: ");
        email=s.nextLine();
        System.out.print("Username: ");
        username=s.nextLine();
        System.out.print("Password: ");
        password=String.valueOf(s.nextLine());
        System.out.print("Retype Password: ");
        retypepassword=String.valueOf(s.nextLine());
        
        if(email.equals("")){
            System.out.println("Email cannot be blank");
            Register();
        }
        else if(username.equals("")){
            System.out.println("Username cannot be blank");
            Register();
        }
        else if(password.equals("")){
            System.out.println("Password cannot be blank");
            Register();
        }
        else if(retypepassword.equals("")){
            System.out.println("Please retype your password");
            Register();
        }
        else if(!password.equals(retypepassword)){
            System.out.println("Password do not match");
            Register();
        }
        else{      
        PreparedStatement st;
        String SQL="INSERT INTO credentials(email, username, password)"+"values(?,?,?)";
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, email);
            st.setString(2, username);
            st.setString(3, password);
            
            if(st.executeUpdate()>0){
                System.out.println("New User Added Successfully\nPlease login again\n");
                Login a=new Login();
                a.Login();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/

    
}
