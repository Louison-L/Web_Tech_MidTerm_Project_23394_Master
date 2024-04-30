package utilisateur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Utilisateur;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UtilisateurDao;


@WebServlet(urlPatterns = "/signUp")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String emailUser = request.getParameter("email");
		String pass = request.getParameter("password");
		String confirmPass = request.getParameter("confirmPassword");
		String type = request.getParameter("dropdown");
		
		
		
		if(pass.equals(confirmPass)) {
			UtilisateurDao userSave = new UtilisateurDao();
			Utilisateur newUser = new Utilisateur(emailUser, pass, type);
			
			userSave.registerUtilisateur(newUser);
			System.out.println("Inserted into Database");
			//response.sendRedirect("displayStudents");
			response.sendRedirect("login.html");
		}else {
			PrintWriter out = response.getWriter();
			out.println("Passwords don't match");
		}
		
	}

}
