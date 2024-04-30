package utilisateur;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LogOutUser extends HttpServlet{

	    private static final long serialVersionUID = 1L;

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Invalidate the session
	        HttpSession session = request.getSession();
	        session.invalidate();
	        System.out.println("First");

	        // Redirect the user to the login page
	        response.sendRedirect("login.html");
	        System.out.println("Done");
	    }
	

}
