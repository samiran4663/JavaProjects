

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String upassword=request.getParameter("password");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		
		Model model=new Model();
		model.setFullname(uname);
		model.setEmail(email);
		model.setPassword(upassword);
		model.setGender(gender);
		model.setPassword(country);
		int rows=model.register();
		
		request.setAttribute("rowsaffected", rows);
		RequestDispatcher rqd=request.getRequestDispatcher("response.jsp");
		rqd.forward(request, response);
		
	}

}
