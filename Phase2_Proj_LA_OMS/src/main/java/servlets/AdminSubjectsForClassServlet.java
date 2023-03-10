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

import database.SubjectDatabase;
import entity.Subject;

@WebServlet("/AdminSubjectsForClassPage")
public class AdminSubjectsForClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//-----------------------------------------------------------------------------------
    public AdminSubjectsForClassServlet() {
        super();
    }

    //-----------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("> Entry AdminSubjectsForClassServlet | doGet");
		SubjectDatabase db = new SubjectDatabase();
		try {
			List<Subject> subjects = db.getAllSubjects();
			
			request.setAttribute("subjects", subjects);
			RequestDispatcher dis = request.getRequestDispatcher("AdminSubjectsForClassPage.jsp"); //URL
			dis.forward(request, response);
			System.out.println("subjects = " + subjects);
			System.out.println("< Exit AdminSubjectsForClassServlet | doGet");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//-----------------------------------------------------------------------------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("> Entry AdminSubjectsForClassServlet | doPost");
		
		int classID_a1 = 0, classID_a2 = 0, classID_a3 = 0;
		if (request.getParameter("classID_a1") != null)
			classID_a1 = Integer.parseInt(request.getParameter("classID_a1"));
		if (request.getParameter("classID_a2") != null)
			classID_a2 = Integer.parseInt(request.getParameter("classID_a2"));
		if (request.getParameter("classID_a3") != null)
			classID_a3 = Integer.parseInt(request.getParameter("classID_a3"));
		
		int classID = classID_a1 * 100 + classID_a2 * 10 + classID_a3;
		int subjectID = Integer.parseInt(request.getParameter("subjectID"));
		System.out.println("subjectID = " + subjectID + " / classID = " + classID);
		
		SubjectDatabase db = new SubjectDatabase();
		try {
			if (db.updateSubjectClassByID(subjectID, classID)) {
				
				List<Subject> subjects = db.getAllSubjects();
				request.setAttribute("subjects", subjects);
				RequestDispatcher dis = request.getRequestDispatcher("AdminSubjectsForClassPage.jsp"); //URL
				dis.forward(request, response);
				System.out.println("< Exit AdminSubjectsForClassServlet | doPost");				
			}
			else
				response.sendRedirect("AdminSubjectsForClassPage.jsp?error=Note: No class assignment performed.");
		}
		catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("AdminSubjectsForClassPage.jsp?error=Error! Something went wrong; contact administrator."); //URL
		}
		catch (IOException e) {
			e.printStackTrace();
			response.sendRedirect("AdminSubjectsForClassPage.jsp?error=Error! Something went wrong; contact administrator."); //URL
		}
	}
}
