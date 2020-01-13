package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditAccount
 */
@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/Edit account.jsp");
		rd.forward(request, response);	

	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB_Access db = new DB_Access();
		//String uname = db.getUserName(uid);
		
       if((Integer)request.getSession().getAttribute("uid") == 0) {
			
			response.sendRedirect("Login?msg= must login first");
			
		}
		
		
			

        if(Helper.isPassValid(request.getParameter("iname"))
					&& Helper.isUserValid(request.getParameter("fullName"))&& 
					Helper.isFullName(request.getParameter("pass")) != false) {
		
        
		int id = (Integer)request.getSession().getAttribute("uid");
		String fullName = request.getParameter("fullName");
		String uname= request.getParameter("iname");
		String pass= request.getParameter("pass");
		
		db.modifyAccount(id, uname, fullName, pass);
		 
		 response.sendRedirect("Login");
		 
		}
       
       else {
    	   
          String error = "There is a problem, please check your input!";
    		
    	   request.setAttribute("error", error);
    	   
   		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/Edit account.jsp");
   		rd.forward(request, response);	
    	   
    	   
       }
		
}
}
