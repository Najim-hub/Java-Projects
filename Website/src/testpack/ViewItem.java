package testpack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;



@WebServlet("/ViewItem")
public class ViewItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		if(uid == null) {
			// not logged in, send to Login with error message
			response.sendRedirect("Login?msg=have to login first...");
		}
		else {// show the home page
			DB_Access db = new DB_Access();
			String uname = db.getUserName(uid); 
			
			request.setAttribute("name", uname);
			
			String iid =  request.getParameter("id");
			
			
			
			ArrayList<Item> viewItems = db.viewItem(iid); 
			
			request.setAttribute("viewItems", viewItems);
			
			//ArrayList<Item> allItems = db.getAllUserItems(uid); 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/main/view.jsp");
			rd.forward(request, response);			
		}	

		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	}

}
