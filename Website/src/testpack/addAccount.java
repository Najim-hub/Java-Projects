package testpack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/addAccount")
public class addAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/addAccount.jsp");
		rd.forward(request, response);	
		
		
		
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_Access db = new DB_Access();
		
		if(Helper.isPassValid(request.getParameter("lname"))
				&& Helper.isUserValid(request.getParameter("fullName"))&& Helper.isFullName(request.getParameter("pass"))) {
	
		String loginName = request.getParameter("lname");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("pass");
		String passwordW = request.getParameter("pass2");
	
		
		
		User one = new User(1,loginName,fullName,password,passwordW);
		
	
		db.createUserAccount(one);
		
		response.sendRedirect("Login");
		
		
		}
		
		else {
			
			   String error = "There is a problem, please check your input!";
    		
	    	   request.setAttribute("error", error);
			
	    	   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/addAccount.jsp");
	   		   rd.forward(request, response);	
		}
		
	}

}
