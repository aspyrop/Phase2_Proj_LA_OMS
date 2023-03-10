package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection dbConn() {
		
		Connection conn = null;
		
		try {
			
			//1. Load the driver; driver knows how to communicate with the DB
//			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(" ---> Driver Loaded!");
			
			//2. Location or IP_address & port_number; connection with the DB
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnersacademy", "root", "agis");
			System.out.println(" ---> DB Connected!");
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
}
