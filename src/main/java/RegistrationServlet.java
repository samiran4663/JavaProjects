

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String upassword=request.getParameter("password");
		String Gender=request.getParameter("gender");
		String Country=request.getParameter("country");
		String url="jdbc:mysql://localhost:3306/telusko_db";
		String username="root";
		String password="samiran752004";
		Connection con=null;
		PreparedStatement pst=null;
		int rows=0;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			pst=con.prepareStatement("insert into personalinfo (fullname,email,passowrd,gender,country) values(?,?,?,?,?)");
			pst.setString(1, fullname);
			pst.setString(2, email);
			pst.setString(3, upassword);
			pst.setString(4, Gender);
			pst.setString(5, Country);
			rows=pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			PrintWriter pw=response.getWriter();
			if(rows!=0)
			{
				pw.println("Registration Successful");
			}
			else {
				pw.println("Registration Failed");
			}
			pw.close();
			try 
			{
				con.close();
				pst.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
