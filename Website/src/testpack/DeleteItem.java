package testpack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






@WebServlet("/DeleteItem")
public class DeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession sess = request.getSession();
		    
	   	 int uid = (Integer)  sess.getAttribute("uid");
	   	
	   	String iid = request.getParameter("id");
	   	
		 DB_Access db = new DB_Access();
		

		 db.deleteItem(iid);
		 if(db.deleteItem(iid) == true) {
			 
			 System.out.println("Successfully deleted!!");
		 }
		 
		 
		 
		
		
		response.sendRedirect("Home");
		
		
		}

	

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
	}

}
