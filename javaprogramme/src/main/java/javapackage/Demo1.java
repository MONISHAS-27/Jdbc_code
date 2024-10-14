package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) throws Exceptions, SQLException {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded successfully");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "Root");
		System.out.println("Connection established");
		con.setAutoCommit(false);
		Scanner scan = new Scanner(System.in);
		String s1 = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(s1);
		System.out.println("Enter id");
		int id = scan.nextInt();
		System.out.println("Enter name");
		String name = scan.next();
		System.out.println("Enter marks1");
		int m1 = scan.nextInt();
		System.out.println("Enter marks2");
		int m2 = scan.nextInt();
		System.out.println("Enter marks3");
		int m3 = scan.nextInt();
		pstmt1.setInt(1, id);
		pstmt1.setString(2, name);
		pstmt1.setInt(3, m1);
		pstmt1.setInt(4, m2);
		pstmt1.setInt(5, m3);
		pstmt1.executeUpdate();
		con.commit();		
		Scanner scan = new Scanner(System.in);
		String s2 = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(s2);
		System.out.println("Enter id");
		int id2 = scan.nextInt();
		System.out.println("Enter name");
		String name2 = scan.next();
		System.out.println("Enter marks1");
		int m12 = scan.nextInt();
		System.out.println("Enter marks2");
		int m22 = scan.nextInt();
		System.out.println("Enter marks3");
		int m33 = scan.nextInt();
		pstmt2.setInt(1, id);
		pstmt2.setString(2, name);
		pstmt2.setInt(3, m1);
		pstmt1.setInt(4, m2);
		pstmt1.setInt(5, m3);
		pstmt1.executeUpdate();
		
	}

}
