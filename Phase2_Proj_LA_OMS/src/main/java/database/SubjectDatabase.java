package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Subject;

public class SubjectDatabase {

	//--------------------------------------------------------------------------------
	public List<Subject> getAllSubjects() throws SQLException
	{
		List<Subject> subjects = new ArrayList<Subject>();
		
		String sql = "SELECT * FROM learnersacademy.subjects"; // query to get all Teachers;
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		Statement stat = conn.createStatement(); //2. Create the statement
		ResultSet rs = stat.executeQuery(sql); //3. Execute the query
		
		while (rs.next()) {

			Subject subject = new Subject();
			subject.setSubjectID(rs.getInt(1));
			subject.setSubjectName(rs.getString(2));
			subject.setClassID(rs.getInt(3));
			subjects.add(subject);
			
		}
		return subjects;
	}
	
	//--------------------------------------------------------------------------------
	public boolean updateSubjectClassByID(int subjectID, int classID) throws SQLException
	{
		String sql = "UPDATE learnersacademy.subjects SET class_id=? WHERE subject_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, classID);
		stat.setInt(2, subjectID);
		
		try {
			stat.execute(); //3. Execute the query
		}
		catch (Exception e) {
			System.out.println(" ---> ERROR!");
			return false;
		}
		return true;	
	}
	
	//--------------------------------------------------------------------------------
	public Subject getSubjectByID(int subjectID) throws SQLException
	{
		String sql = "SELECT * FROM learnersacademy.subjects WHERE subject_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, subjectID);
		
		Subject s = new Subject();
		ResultSet rs = stat.executeQuery(); //3. Execute the query
		
		while (rs.next()) {
			s.setSubjectID(rs.getInt(1));
			s.setSubjectName(rs.getString(2));
			s.setClassID(rs.getInt(3));
		}
		return s;	
	}
	
	//--------------------------------------------------------------------------------
	public String getSubjectNameByID(int subjectID) throws SQLException
	{
		return getSubjectByID(subjectID).getSubjectName();
	}
	
	
	
}

