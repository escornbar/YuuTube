package yuu.tube;

import java.util.*;
import java.sql.*;
public class YuuTube {
       
    
    public static void main(String[] args) {
        Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;
        
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:1527/User Credentials", "student" , "student");
			
            // 2. Create a statement
            myStmt = myConn.createStatement();
			
            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from employees");
			
            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
                }
            }
		catch (Exception exc) {
			exc.printStackTrace();
        Random r=new Random();
        Scanner s=new Scanner(System.in);
        
        System.out.println("-----Welcome to Yuu-Tube-----");
        System.out.println("[1] LOGIN\n[2] SIGN UP FOR AN ACCOUNT");
        int logs = s.nextInt();
        if(logs == 1 ){
            System.out.print("Username: ");
            String username=s.nextLine();
            System.out.print("Password: ");
            String password=s.nextLine();
        }
        else if(logs == 2){
            System.out.print("Username: ");
            String username=s.nextLine();
            System.out.print("Email: ");
            String email=s.nextLine();
            System.out.println("Make sure you use a strong password for your account.");
            System.out.print("Password: ");
            String password=s.nextLine();
        }
        else{
            System.out.println("Invalid Input");
        }
        /*// 2. Create a statement
	String sql = "insert into employees " + " (last_name, first_name, email)" + " values (?, ?, ?)";

	myStmt = myConn.prepareStatement(sql);

	// set param values
	myStmt.setString(1, username);
	myStmt.setString(2, email);
	myStmt.setString(3, password);

	// 3. Execute SQL query
	myStmt.executeUpdate()*/
    }
    
}
}

