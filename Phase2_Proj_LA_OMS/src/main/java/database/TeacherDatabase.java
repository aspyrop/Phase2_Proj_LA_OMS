package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Teacher;

public class TeacherDatabase {

	//--------------------------------------------------------------------------------
	public List<Teacher> getAllTeachers() throws SQLException
	{
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		String sql = "SELECT * FROM learnersacademy.Teachers"; // query to get all Teachers;
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		Statement stat = conn.createStatement(); //2. Create the statement
		ResultSet rs = stat.executeQuery(sql); //3. Execute the query
		
		while (rs.next()) {

			//System.out.println(" > " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			
			Teacher teach = new Teacher();
			teach.setId(rs.getInt(1));
			teach.setSurname(rs.getString(2));
			teach.setName(rs.getString(3));
			teach.setSubjectID(rs.getInt(5));
			teach.setClassID(rs.getInt(5));
			teachers.add(teach);
			
		}
		return teachers;
	}
	
	//--------------------------------------------------------------------------------
	public int maxTeacherID() throws SQLException
	{
		int id = 0;
		String sql = "SELECT MAX(Teacher_id) FROM learnersacademy.teachers";
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		Statement stat = conn.createStatement(); //2. Create the statement
		ResultSet rs = stat.executeQuery(sql); //3. Execute the query
		if (rs.next()) id = rs.getInt(1);
		return id;
	}
	
	//--------------------------------------------------------------------------------
	public boolean insertTeacher(Teacher teacher) throws SQLException
	{
		String sql = "INSERT INTO learnersacademy.teachers VALUES(?,?,?,?,?)";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, teacher.getId());
		stat.setString(2, teacher.getSurname());
		stat.setString(3, teacher.getName());
		stat.setInt(4, teacher.getSubjectID());
		stat.setInt(5, teacher.getClassID());
		
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
	public boolean updateTeacherByID(int id, String surname, String name, String middlename, int subjectID, int classID) throws SQLException
	{
		String sql = "UPDATE learnersacademy.teachers SET teacher_surname=?, teacher_name=?, teacher_middlename=?, class_id=? WHERE teacher_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setString(1, surname);
		stat.setString(2, name);
		stat.setString(3, middlename);
		stat.setInt(4, subjectID);
		stat.setInt(5, classID);
		
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
	public boolean updateTeacherClassByID(int teacherID, int classID) throws SQLException
	{
		String sql = "UPDATE learnersacademy.teachers SET class_id=? WHERE teacher_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, classID);
		stat.setInt(2, teacherID);
		
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
	public boolean deleteTeacherByID(int id) throws SQLException
	{
		String sql = "DELETE FROM learnersacademy.teachers WHERE teacher_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, id);
		
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
	public Teacher getTeacherByID(int id) throws SQLException
	{
		String sql = "SELECT * FROM learnersacademy.teachers WHERE teacher_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, id);
		
		Teacher t = new Teacher();
		ResultSet rs = stat.executeQuery(); //3. Execute the query
		
		while (rs.next()) {
			t.setId(rs.getInt(1));
			t.setSurname(rs.getString(2));
			t.setName(rs.getString(3));
			t.setSubjectID(rs.getInt(4));
			t.setClassID(rs.getInt(5));
		}
		return t;	
	}
	
}
