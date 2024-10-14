package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) throws Exceptions, SQLException {
		System.out.println("1.New user(Register)");
		System.out.println("2.Existing user(Login)");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n) {
		case 1:register();
		break;
		case 2:login();
		break;
		default:System.out.println("Invalid choice");
		break;
		}
	}
	static void register() throws Exceptions, SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Root");
		System.out.println("Connection established successfully");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scan.next();
		System.out.println("Enter username");
		String username = scan.next();
		
		while(true) {
			String s = "select * from user where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				System.out.println("Username is already taken. Please try another");
				username = scan.next();
			}
			else {
				break;
			}
		}
		String password;
		String confirm;
		do {
		System.out.println("Enter password");
	    password = scan.next();
		System.out.println("Confirm password");
	    confirm = scan.next();
		}while(!password.equals(confirm));
		
		System.out.println("Enter email");
		String email = scan.next();
		
		String s1 = "insert into user values(?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(s1);
		pstmt1.setString(1, name);
		pstmt1.setString(2, username);
		pstmt1.setString(3, password);
		pstmt1.setString(4, email);
		pstmt1.executeUpdate();
		
	}
		
		static void login() throws Exceptions, SQLException {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "Root");
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter username");
			String username = scan.next();
			System.out.println("Enter password");
			String password = scan.next();
			String s2 = "select * from user where username=?";
			PreparedStatement ppstmt = con.prepareStatement(s2);
			ppstmt.setString(1, username);
			
			ResultSet res = ppstmt.executeQuery();
			if(res.next()) {
				if(password.equals(res.getString(3))) {
					System.out.println("Login successful");
				}
			    else {
				     System.out.println("Invalid Password");
			    }			   
			}			
		}
}
