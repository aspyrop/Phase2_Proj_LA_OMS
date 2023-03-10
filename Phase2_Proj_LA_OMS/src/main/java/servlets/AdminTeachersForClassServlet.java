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

import database.TeacherDatabase;
import entity.Teacher;

@WebServlet("/AdminTeachersForClassPage")
public class AdminTeachersForClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTeachersForClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //-----------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("> Entry AdminTeachersForClassServlet | doGet");
		TeacherDatabase db = new TeacherDatabase();
		try {
			List<Teacher> teachers = db.getAllTeachers();
			
			request.setAttribute("teachers", teachers);
			RequestDispatcher dis = request.getRequestDispatcher("AdminTeachersForClassPage.jsp"); //URL
			dis.forward(request, response);
			System.out.println("teachers = " + teachers);
			System.out.println("< Exit AdminTeachersForClassServlet | doGet");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

    //-----------------------------------------------------------------------------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("> Entry AdminTeachersForClassServlet | doPost");
		int classID = 0;
		
		if (request.getParameter("classID") != null) {
			
			classID = Integer.parseInt(request.getParameter("classID"));
			int teacherID = Integer.parseInt(request.getParameter("teacherID"));
			System.out.println("teacherID =" + teacherID + " | classID = " + classID);
			
			TeacherDatabase db = new TeacherDatabase();
			try {
				if (db.updateTeacherClassByID(teacherID, classID)) {
					
					List<Teacher> teachers = db.getAllTeachers();
					request.setAttribute("teachers", teachers);
					RequestDispatcher dis = request.getRequestDispatcher("AdminTeachersForClassPage.jsp"); //URL
					dis.forward(request, response);
					System.out.println("< Exit AdminTeachersForClassServlet | doPost");				
				}
				else
					response.sendRedirect("AdminTeachersForClassPage.jsp?error=No class assignment performed");
			}
			catch (SQLException e) {
				e.printStackTrace();
				response.sendRedirect("AdminTeachersForClassPage.jsp?error=Something went wrong; contact administrator"); //URL
			}
			catch (IOException e) {
				e.printStackTrace();
				response.sendRedirect("AdminTeachersForClassPage.jsp?error=Something went wrong; contact administrator"); //URL
			}

		}
		else {
			TeacherDatabase db = new TeacherDatabase();
			List<Teacher> teachers;
			try {
				teachers = db.getAllTeachers();
				request.setAttribute("teachers", teachers);
				RequestDispatcher dis = request.getRequestDispatcher("AdminTeachersForClassPage.jsp?error=No class assignment performed"); //URL
				dis.forward(request, response);
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
