package database;

import java.sql.Connection;

public class TestDB {

	public static void main(String[] args) {
		
		//DBConnection.dbConn();
		
		
		//
		Connection conn = DBConnection.dbConn();
		System.out.println("conn = " + conn);
		
		
	}
	
	
}
