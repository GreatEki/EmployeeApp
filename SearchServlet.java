package firstpractice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("txtSearch").toString();
		try {
			
		ActorsDao actorsdao = new ActorsDao();
		Actors theactors = actorsdao.search(name);
		
		request.setAttribute("Actors", theactors);
		
		RequestDispatcher rd = request.getRequestDispatcher("RegistrationResponsePage.jsp");
		rd.forward(request,  response);
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	 
	
}
