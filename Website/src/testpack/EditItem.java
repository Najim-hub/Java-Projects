package testpack;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditItem
 */
@WebServlet("/EditItem")
public class EditItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		
		//response.sendRedirect("EditItem?msg=hmm, Some values are wrong try again...&id="+
		//        Integer.parseInt(request.getParameter("iid")));
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/mod.jsp");
		rd.forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		DB_Access db = new DB_Access();
		//String uname = db.getUserName(uid);
		
		
        if(DB_Access.isItemValid(request.getParameter("iname")) != false
				&& DB_Access.isItemQtyValid(request.getParameter("iqty")) != false) {
			
			
      
		int id = Integer.parseInt(request.getParameter("iid"));
		
		
		String itemName= request.getParameter("iname");
		int quan= Integer.parseInt(request.getParameter("iqty"));
		
		
		
		response.sendRedirect("Home?msg= Done!!");
		db.modifyItem( id,  itemName, quan);
		
		}
		
        else {
        	
        	
        	
        	   String error = "There is a problem, please check your input!";
	    		
	    	   request.setAttribute("error", error);
	    	   
	    	   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/mod.jsp");
	   		rd.forward(request, response);	
        }
		
	}

}
