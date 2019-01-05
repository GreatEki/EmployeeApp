package firstpractice;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
		{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String fname = (String) request.getParameter("firstname");
		String lname = (String) request.getParameter("lastname");
		String movie = (String) request.getParameter("film");
		String mail = (String) request.getParameter("email");
		
		
		ActorsDao actorsdao = new ActorsDao();
		Actors actors = new Actors();
			
			
			actors.setId(id);
			actors.setFirstname(fname);
			actors.setLastname(lname);
			actors.setFilm(movie);
			actors.setEmail(mail);
			 
				
			actorsdao.register(actors);
						
			request.setAttribute("FirstName", fname);
			
				
			RequestDispatcher rd = request.getRequestDispatcher("RegistrationResponsePage.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
		
	}

}
