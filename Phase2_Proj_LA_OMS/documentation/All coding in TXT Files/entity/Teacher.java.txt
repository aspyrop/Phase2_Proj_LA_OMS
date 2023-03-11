package entity;

import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;

import database.SubjectDatabase;

public class Teacher {

	private int id;
	private String surname;
	private String name;
	private int specSubjectID;
	private int classID;
	
	
	public Teacher() {

	}

	public Teacher(int id, String surname, String name, int specSubjectID, int classID) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.specSubjectID = specSubjectID;
		this.classID = classID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpecSubjectID() {
		return specSubjectID;
	}

	public void setSpecSubjectID(int specSubjectID) {
		this.specSubjectID = specSubjectID;
	}

	public int getClassID() {
		return classID;
	}

	public void setClassID(int classID) {
		this.classID = classID;
	}

	public String specializationSubjectName() throws SQLException {

		SubjectDatabase db = new SubjectDatabase();
		Subject subjObj = db.getSubjectByID(this.specSubjectID);
		String subjName = subjObj.getSubjectName();
		return subjName;
		
	}
	
}
