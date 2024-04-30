package utilisateur;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;
//@WebServlet(urlPatterns = "filterAcademic")
public class AcademicServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Utilisateur authenticatedUser = (Utilisateur) session.getAttribute("authenticatedUser");
        
        if (authenticatedUser != null) {
            
            
            String role = authenticatedUser.getRole();
            if (role.equals("Teacher")) {
            	System.out.println("Yeah");
            	response.sendRedirect("DeniedAccess.html");
            }else {
            	response.sendRedirect("academicSoftware.html");
            }
            
            // Do further processing with the user object
        } else {
        	response.sendRedirect("login.html");
            
        }
    }
	

}
