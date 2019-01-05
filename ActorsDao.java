package firstpractice;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;







public class ActorsDao {

	Connection myCon = null;
	public boolean check;
	HttpServletRequest request;
	HttpServletResponse response;
	
	public ActorsDao() {
	try {
	
		
	
		Class.forName("com.mysql.jdbc.Driver");
		
	String DbUrl = "jdbc:mysql://localhost:3306/jdbcdemo?ssL=false";	
	String username = "root";
	String pass = "honourable_222";
	
	myCon = DriverManager.getConnection(DbUrl, username, pass);
	
	}
	catch (Exception exp) {
		exp.printStackTrace();
	}
	}
	
	public void register(Actors actors) throws Exception {
					
			PreparedStatement myStmt = null;
			
			try {
				
					
			myStmt = myCon.prepareStatement("INSERT INTO jdbcdemo.personnels(`ID`, `firstname`, `lastname`, `film`, `emaill`)" 
			+ "VALUES (?, ?, ?, ?, ?)");
			
			myStmt.setInt(1, actors.getId());
			myStmt.setString(2, actors.getFirstname());
			myStmt.setString(3, actors.getLastname());
			myStmt.setString(4, actors.getFilm());
			myStmt.setString(5, actors.getEmail());
			
			myStmt.executeUpdate();
			
			myStmt.close();
			
		}
		catch (Exception exp) {
			exp.printStackTrace();
		}
		
	}
	
	public Actors search(String name) throws Exception {
		
		
		Actors theactors = new Actors();
		PreparedStatement stmt;
			try {	
		 stmt = myCon.prepareStatement("select * from jdbcdemo.personnels where firstname = ?");
		 stmt.setString(1, name);
		 ResultSet Rs = stmt.executeQuery();
		 
		 if (Rs.next()) {
			 theactors.setId(Rs.getInt("ID"));
			 theactors.setFirstname(Rs.getString("firstname"));
			 theactors.setLastname(Rs.getString("lastname"));
			 theactors.setFilm(Rs.getString("film"));
			 theactors.setEmail(Rs.getString("emaill")); 
			 
		 }
			}
		
		catch (Exception ep) {
			ep.printStackTrace();
		}
			return theactors;
	}
	
	

}