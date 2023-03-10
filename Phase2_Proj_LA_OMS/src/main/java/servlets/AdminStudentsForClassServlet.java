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
import javax.servlet.http.HttpSession;

import database.StudentDatabase;
import entity.Student;

@WebServlet("/AdminStudentsForClassPage")
public class AdminStudentsForClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStudentsForClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //-----------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("> Entry AdminStudentsForClassServlet | doGet");
		StudentDatabase db = new StudentDatabase();
		try {
			List<Student> students = db.getAllStudents();
			
			request.setAttribute("students", students);
			RequestDispatcher dis = request.getRequestDispatcher("AdminStudentsForClassPage.jsp"); //URL
			dis.forward(request, response);
			System.out.println("< Exit AdminStudentsForClassServlet | doGet");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

    //-----------------------------------------------------------------------------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("> Entry AdminStudentsForClassServlet | doPost");
		int classID = 0;
		
		if (request.getParameter("classID") != null) {
			
			classID = Integer.parseInt(request.getParameter("classID"));
			int studentID = Integer.parseInt(request.getParameter("studentID"));
			System.out.println("studentID = " + studentID + " | classID = " + classID);
			
			StudentDatabase db = new StudentDatabase();
			try {
				if (db.updateStudentClassByID(studentID, classID)) {
					
					List<Student> students = db.getAllStudents();
					request.setAttribute("students", students);
					RequestDispatcher dis = request.getRequestDispatcher("AdminStudentsForClassPage.jsp"); //URL
					dis.forward(request, response);
					System.out.println("< Exit AdminStudentsForClassServlet | doPost");
				}
				else
					response.sendRedirect("AdminStudentsForClassPage.jsp?error=No class assignment performed");
			}
			catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect("AdminStudentsForClassPage.jsp?error=Something went wrong; contact administrator"); //URL
			}
			catch (IOException e) {
				e.printStackTrace();
				response.sendRedirect("AdminStudentsForClassPage.jsp?error=Something went wrong; contact administrator"); //URL
			}

		}
		else {
			StudentDatabase db = new StudentDatabase();
			List<Student> students;
			try {
				students = db.getAllStudents();
				request.setAttribute("students", students);
				RequestDispatcher dis = request.getRequestDispatcher("AdminStudentsForClassPage.jsp?error=No class assignment performed"); //URL
				dis.forward(request, response);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
