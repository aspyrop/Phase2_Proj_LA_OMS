package entity;

import java.sql.SQLException;
import java.util.List;

import database.SubjectDatabase;
import database.TeacherDatabase;

public class Subject {

	private int subjectID;
	private String subjectName;
	private int classID;
	private int teacherID;
	
	public Subject() {

	}

	public Subject(int subjectID, String subjectName) {
		super();
		this.subjectID = subjectID;
		this.subjectName = subjectName;
	}

	public int getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	@Override
	public String toString() {
		return "Subject [subjectID=" + subjectID + ", subjectName=" + subjectName + ", classID=" + classID
				+ ", teacherID=" + teacherID + "]";
	}	
	
	public int td_specializationSubjectID() throws SQLException {

		TeacherDatabase db = new TeacherDatabase(); //db.getAllTeachers();
		Teacher teacherObj = db.getTeacherByID(this.teacherID);
		int subjectID_from_Teachers_table = teacherObj.getSpecSubjectID();
		return subjectID_from_Teachers_table;
	}	
	
	public String td_specializationSubjectName() throws SQLException {

		int subjectID_from_Teachers_table = this.td_specializationSubjectID();
		SubjectDatabase dbs = new SubjectDatabase();
		String subjectName = dbs.getSubjectNameByID(subjectID_from_Teachers_table);
		return subjectName;
	}	
	
	public String td_teacherSurname() throws SQLException {

		TeacherDatabase db = new TeacherDatabase();
		Teacher teacherObj = db.getTeacherByID(this.teacherID);
		String teacherSurname = teacherObj.getSurname();
		return teacherSurname;
	}	
	
	public String td_teacherName() throws SQLException {

		TeacherDatabase db = new TeacherDatabase();
		Teacher teacherObj = db.getTeacherByID(this.teacherID);
		String teacherSurname = teacherObj.getName();
		return teacherSurname;
	}	
	
}

