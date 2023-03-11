package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDatabase {

	//--------------------------------------------------------------------------------
	public boolean validateAdmin(String username, String password) throws SQLException
	{
		boolean isValidAdmin = false;

System.out.println("before db conn");		
		
		Connection connx = DBConnection.dbConn(); //1. DB Connection
		System.out.println(	"connx = " + connx);
		System.out.println("after db conn");		
		
		String sql = "SELECT * FROM learnersacademy.admins WHERE admin_username=?";
		PreparedStatement stat = connx.prepareStatement(sql); //2. Create the statement
		stat.setString(1, username);
		ResultSet rs = stat.executeQuery(); //3. Execute the query
		
		if (rs.next()) {
			String pass = rs.getString(2);
			if (pass.contentEquals(password)) isValidAdmin = true;
		}
		System.out.println("isValidAdmin =" + isValidAdmin);
		
		return isValidAdmin;
	}
	
}
