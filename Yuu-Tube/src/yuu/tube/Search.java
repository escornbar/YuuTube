/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yuu.tube;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author syaam
 */
public class Search {

    public Search() {
        
    }
    
    public void searchVid(String a){
        Scanner s=new Scanner(System.in);
        a=s.nextLine();
        PreparedStatement st;
        ResultSet rs;
        String vidTitle=a;
        String SQL="SELECT * FROM public.credentials WHERE title=? AND likes=? AND dislikes=? AND views=?";
        try{
            st=MyConnection.getConnection().prepareStatement(SQL);
            rs=st.executeQuery();
            int i=0;
            while(rs.next()){
                i++;
                System.out.println(i);
                System.out.print("Video Title: ");
                System.out.println(rs.getString("title"));
                System.out.print("Views: ");
                System.out.println(rs.getString("views"));
                System.out.print("Likes: ");
                System.out.println(rs.getInt("likes"));
                System.out.print("Dislikes: ");
                System.out.println(rs.getInt("dislikes"));
                System.out.println("Comments:");
            }
               
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
