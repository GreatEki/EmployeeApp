package firstpractice;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;





/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/signin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ActorsDao actorsDao = new ActorsDao();
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("Usernametxt");
		String pass = request.getParameter("passwordtxt");
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "root");
			PreparedStatement stmt = con.prepareStatement("select * from jdbcdemo.login where Username = ? and Password = ?");
				stmt.setString(1, user);
				stmt.setString(2, pass);
				
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					String name = (String) rs.getString("Username");
					String pword = (String) rs.getString("Password");
					
					
				
				if (name.equals(user) && pword.equals(pass)) {
					HttpSession session = request.getSession();
					session.setAttribute("User", user);
					response.sendRedirect("FirstPractice.jsp");
				}
				else {
					response.sendRedirect("login.jsp");
				}
			}
				else {
					response.sendRedirect("login.jsp");
				}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
}