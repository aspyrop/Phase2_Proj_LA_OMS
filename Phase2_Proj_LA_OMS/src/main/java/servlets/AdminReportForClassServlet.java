package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.StudentDatabase;
import entity.Student;
import database.SubjectDatabase;
import entity.Subject;

@WebServlet("/AdminReportForClassPage")
public class AdminReportForClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminReportForClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("> Entry AdminReportForClassServlet | doGet");
		StudentDatabase db;
		SubjectDatabase db2;
		
		try {
			
			db = new StudentDatabase();
			List<Student> students1 = db.getAllStudentsByClassID(1); // classID = 1
			request.setAttribute("students1", students1);
			
			db = new StudentDatabase();
			List<Student> students2 = db.getAllStudentsByClassID(2); // classID = 2
			request.setAttribute("students2", students2);
			
			db = new StudentDatabase();
			List<Student> students3 = db.getAllStudentsByClassID(3); // classID = 3
			request.setAttribute("students3", students3);
			
			db2 = new SubjectDatabase();
			List<Subject> subjects1 = db2.getAllSubjectsByClassID(1); // classID = 1
			request.setAttribute("subjects1", subjects1);
			
			db2 = new SubjectDatabase();
			List<Subject> subjects2 = db2.getAllSubjectsByClassID(2); // classID = 2
			request.setAttribute("subjects2", subjects2);
			
			db2 = new SubjectDatabase();
			List<Subject> subjects3 = db2.getAllSubjectsByClassID(3); // classID = 3
			request.setAttribute("subjects3", subjects3);
			
			RequestDispatcher dis = request.getRequestDispatcher("AdminReportForClassPage.jsp"); //URL
			dis.forward(request, response);
			System.out.println("< Exit AdminReportForClassServlet | doGet");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
		response.sendRedirect("AdminReportForClassPage.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
