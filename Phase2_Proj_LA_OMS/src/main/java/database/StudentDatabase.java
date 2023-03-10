package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Student;


public class StudentDatabase {

	//--------------------------------------------------------------------------------
	public List<Student> getAllStudents() throws SQLException
	{
		List<Student> students = new ArrayList<Student>();
		
		String sql = "SELECT * FROM learnersacademy.students"; // query to get all students;
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		Statement stat = conn.createStatement(); //2. Create the statement
		ResultSet rs = stat.executeQuery(sql); //3. Execute the query
		
		while (rs.next()) {

			//System.out.println(" > " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			
			Student stu = new Student();
			stu.setId(rs.getInt(1));
			stu.setSurname(rs.getString(2));
			stu.setName(rs.getString(3));
			stu.setMiddlename(rs.getString(4));
			stu.setClassID(rs.getInt(5));
			students.add(stu);
			
		}
		return students;
	}
	
	//--------------------------------------------------------------------------------
	public int maxStudentID() throws SQLException
	{
		int id = 0;
		String sql = "SELECT MAX(student_id) FROM learnersacademy.students";
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		Statement stat = conn.createStatement(); //2. Create the statement
		ResultSet rs = stat.executeQuery(sql); //3. Execute the query
		if (rs.next()) id = rs.getInt(1);
		return id;
	}
	
	//--------------------------------------------------------------------------------
	public boolean insertStudent(Student student) throws SQLException
	{
		String sql = "INSERT INTO learnersacademy.students VALUES(?,?,?,?,?)";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, student.getId());
		stat.setString(2, student.getSurname());
		stat.setString(3, student.getName());
		stat.setString(4, student.getMiddlename());
		stat.setInt(5, student.getClassID());
		
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
	public boolean updateStudentByID(int id, String surname, String name, String middlename, int classID) throws SQLException
	{
		String sql = "UPDATE learnersacademy.students SET student_surname=?, student_name=?, student_middlename=?, class_id=? WHERE student_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setString(1, surname);
		stat.setString(2, name);
		stat.setString(3, middlename);
		stat.setInt(4, classID);
		
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
	public boolean updateStudentClassByID(int studentID, int classID) throws SQLException
	{
		String sql = "UPDATE learnersacademy.students SET class_id=? WHERE student_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, classID);
		stat.setInt(2, studentID);
		
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
	public boolean deleteStudentByID(int id) throws SQLException
	{
		String sql = "DELETE FROM learnersacademy.students WHERE student_id=?";
		
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
	public Student getStudentByID(int id) throws SQLException
	{
		String sql = "SELECT * FROM learnersacademy.students WHERE student_id=?";
		
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, id);
		
		Student s = new Student();
		ResultSet rs = stat.executeQuery(); //3. Execute the query
		
		while (rs.next()) {
			s.setId(rs.getInt(1));
			s.setSurname(rs.getString(2));
			s.setName(rs.getString(3));
			s.setMiddlename(rs.getString(4));
			s.setClassID(rs.getInt(5));
		}
		return s;	
	}
	
	//--------------------------------------------------------------------------------
	public List<Student> getAllStudentsByClassID(int classID) throws SQLException
	{
		List<Student> students = new ArrayList<Student>();

		String sql = "SELECT * FROM learnersacademy.students WHERE class_id=?";
		Connection conn = DBConnection.dbConn(); //1. DB Connection
		PreparedStatement stat = conn.prepareStatement(sql); //2. Create the statement
		stat.setInt(1, classID);

		ResultSet rs = stat.executeQuery(); //3. Execute the query		
		
		while (rs.next()) {
			
			Student stu = new Student();
			stu.setId(rs.getInt(1));
			stu.setSurname(rs.getString(2));
			stu.setName(rs.getString(3));
			stu.setMiddlename(rs.getString(4));
			stu.setClassID(rs.getInt(5));
			students.add(stu);
		}
		return students;

	}
	
}
