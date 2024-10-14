import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded successfully");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "Root");
		System.out.println("Connection established successfully");
		//updating the data in the query
		String s = "update Student set name=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = scan.next();
		System.out.println("Enter the id");
		int id = scan.nextInt();
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		//updating ( means writing) use executeUpdate
		int rows = pstmt.executeUpdate();
		System.out.println(rows);	
	}
	
}
