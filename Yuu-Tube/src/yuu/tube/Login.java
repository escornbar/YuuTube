package yuu.tube;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login {
    private String email, password;

    public void Login(){
        Scanner s=new Scanner(System.in);
        PreparedStatement st;
        ResultSet rs;
        System.out.print("Email: ");
        email=s.nextLine();
        System.out.print("Password: ");
        password=String.valueOf(s.nextLine());
        String SQL="SELECT * FROM public.credentials WHERE email = ? AND password = ?";
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            st.setString(1, email);
            st.setString(2, password);
            rs=st.executeQuery();
            if(rs.next()){
                System.out.println("Login Successful!");
            }
            else{
                System.out.println("Wrong email or password entered");
                Login();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
