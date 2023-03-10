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
		
		int classID_a1 = 0, classID_a2 = 0, classID_a3 = 0;
		if (request.getParameter("classID_a1") != null)
			classID_a1 = Integer.parseInt(request.getParameter("classID_a1"));
		if (request.getParameter("classID_a2") != null)
			classID_a2 = Integer.parseInt(request.getParameter("classID_a2"));
		if (request.getParameter("classID_a3") != null)
			classID_a3 = Integer.parseInt(request.getParameter("classID_a3"));
		
		int classID = classID_a1 * 100 + classID_a2 * 10 + classID_a3;
		int teacherID = Integer.parseInt(request.getParameter("teacherID"));
		System.out.println("teacherID = " + teacherID + " | classID = " + classID);
		
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
	
	
//    //-----------------------------------------------------------------------------------
//	protected void xxxxxxxxxxxxxxxx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		System.out.println("> Entry AdminTeachersForClassServlet | doPost");
//		int classID = 0;
//		
//		if (request.getParameter("classID") != null) {
//			
//			classID = Integer.parseInt(request.getParameter("classID"));
//			
//			boolean class_a1 = false, class_a2 = false, class_a3 = false;
//			
//		    switch (classID) {
//	    	case 1: class_a1 = false; class_a2 = false; class_a3 = true; break;
//	    	case 10: class_a1 = false; class_a2 = true; class_a3 = false; break;
//	    	case 11: class_a1 = false; class_a2 = true; class_a3 = true; break;
//	    	case 100: class_a1 = true; class_a2 = false; class_a3 = false; break;
//	    	case 101: class_a1 = true; class_a2 = false; class_a3 = true; break;
//	    	case 110: class_a1 = true; class_a2 = true; class_a3 = false; break;
//	    	case 111: class_a1 = true; class_a2 = true; class_a3 = true; break;
//		    }
//			
//			
//			
//			int teacherID = Integer.parseInt(request.getParameter("teacherID"));
//			System.out.println("teacherID =" + teacherID + " | classID = " + classID);
//			
//			TeacherDatabase db = new TeacherDatabase();
//			try {
//				if (db.updateTeacherClassByID(teacherID, classID)) {
//					
//					List<Teacher> teachers = db.getAllTeachers();
//					request.setAttribute("teachers", teachers);
//					RequestDispatcher dis = request.getRequestDispatcher("AdminTeachersForClassPage.jsp"); //URL
//					dis.forward(request, response);
//					System.out.println("< Exit AdminTeachersForClassServlet | doPost");				
//				}
//				else
//					response.sendRedirect("AdminTeachersForClassPage.jsp?error=No class assignment performed");
//			}
//			catch (SQLException e) {
//				e.printStackTrace();
//				response.sendRedirect("AdminTeachersForClassPage.jsp?error=Something went wrong; contact administrator"); //URL
//			}
//			catch (IOException e) {
//				e.printStackTrace();
//				response.sendRedirect("AdminTeachersForClassPage.jsp?error=Something went wrong; contact administrator"); //URL
//			}
//
//		}
//		else {
//			TeacherDatabase db = new TeacherDatabase();
//			List<Teacher> teachers;
//			try {
//				teachers = db.getAllTeachers();
//				request.setAttribute("teachers", teachers);
//				RequestDispatcher dis = request.getRequestDispatcher("AdminTeachersForClassPage.jsp?error=No class assignment performed"); //URL
//				dis.forward(request, response);
//			}
//			catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//		}
//	}
	
	
	
}
