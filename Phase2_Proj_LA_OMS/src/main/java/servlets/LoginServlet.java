package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

import database.AdminDatabase;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginPage")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//-------------------------------------------------------------------------------------
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//-------------------------------------------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("LoginPage.html");
	}

	//-------------------------------------------------------------------------------------
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Inside LoginServlet | doPost | username = " + username);
		System.out.println("Inside LoginServlet | doPost | password = " + password);
		
		AdminDatabase db = new AdminDatabase();
				
		try {
			if (db.validateAdmin(username, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username); //important: we set here the param to be passed on to other JSPs or servlets
				response.sendRedirect("AdminPage.jsp"); //URL
			}
			else {
				response.sendRedirect("LoginPage.jsp?error=Error! Invalid admin credentials.");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("LoginPage.jsp?error=Error! Something went wrong; contact administrator."); //URL
		}
	}
}
