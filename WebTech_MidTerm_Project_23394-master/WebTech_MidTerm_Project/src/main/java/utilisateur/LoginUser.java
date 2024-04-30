package utilisateur;

import java.io.IOException;
import java.io.PrintWriter;

import dao.UtilisateurDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Utilisateur;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public void LoginServlet(){
		super();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("dropdown");

		if (email != null || password!=null ||role!=null) {

			//session.setAttribute("role", role);

			UtilisateurDao userLogin = new UtilisateurDao();

			Utilisateur authenticatedUser = userLogin.loginUtilisateur(email, password, role);

			if (authenticatedUser != null) {

				System.out.println("Success");
				HttpSession session = request.getSession();
				session.setAttribute("authenticatedUser", authenticatedUser);
				// Redirect to a success page or do further processing

				// Setting the session's maximum inactive interval based on role

				if (role.equals("Admin")) { System.out.println();
					session.setMaxInactiveInterval(60); } else if (role.equals("Teacher")) {
					session.setMaxInactiveInterval(60); } else if (role.equals("Student")) {
					session.setMaxInactiveInterval(60); }

				if (role.equals("Admin")) {

					//session.setAttribute("lastInteractionTime", System.currentTimeMillis());

					RequestDispatcher rd =request.getRequestDispatcher("home.html");
					rd.forward(request, response);



				} else if (role.equals("Teacher")) {
					RequestDispatcher rd =request.getRequestDispatcher("home.html");
					rd.forward(request, response);




				} else if (role.equals("Student")) {
					RequestDispatcher rd =request.getRequestDispatcher("home.html");
					rd.forward(request, response);


				}
			}

			else {
				// Authentication failed, redirect back to login page with error message
				response.sendRedirect("forgot.html");

			}
		}else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("Fill all fields");

		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Handling GET requests, e.g., redirecting to login.html after 3 seconds of inactivity
		HttpSession session = request.getSession();
		Long lastInteractionTime = (Long) session.getAttribute("lastInteractionTime");
		if (lastInteractionTime != null) {
			long currentTime = System.currentTimeMillis();
			long inactiveDuration = currentTime - lastInteractionTime;
			if (inactiveDuration > 3000) {
				response.sendRedirect("login.html"); // Redirect to login page after 3 seconds of inactivity
			}
		}
	}

}

