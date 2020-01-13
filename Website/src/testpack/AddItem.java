package testpack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AddItem")
public class AddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/add.jsp");
		rd.forward(request, response);	
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		DB_Access db = new DB_Access();
 
		 if(DB_Access.isItemValid(request.getParameter("iname")) != false
					&& DB_Access.isItemQtyValid(request.getParameter("qnum")) != false) {
				
		
		String itemName =  request.getParameter("iname");
		
		int uid = (Integer) request.getSession().getAttribute("uid");
		
		
		String quantity = request.getParameter("qnum");
		
		db.addItem(itemName, quantity, uid);
		
		response.sendRedirect("Home");
		 }
		 
		 else {
			 
			   String error = "There is a problem, please check your input!";
	    		
	    	   request.setAttribute("error", error);
	    	   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/add.jsp");
	   		rd.forward(request, response);	
	   		
			 
		 }
		
		
	}
}


