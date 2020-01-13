package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Login")

public class Login extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lname = request.getParameter("lname");
		String lpass = request.getParameter("lpass");
		DB_Access db = new DB_Access();
		int uid = db.validateLogin(lname, lpass);
	
		
		
		
		if(Helper.isPassValid(request.getParameter("lname"))
				== false ||
				Helper.isFullName(request.getParameter("lpass")) == false) {
			
			
			String error = "Error! check input";
    		
	    	request.setAttribute("error", error);
	    	
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/Login.jsp");
			rd.forward(request, response);
		}
		
		
		else {
			// valid login attempt
			request.getSession().setAttribute("uid", uid);
		
			response.sendRedirect("Home");
			
		}
	}
}
