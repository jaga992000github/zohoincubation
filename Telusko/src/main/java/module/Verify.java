package module;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBC;
/**
 * Servlet implementation class Verify
 */
@WebServlet("/Verify")
public class Verify extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Verify called");
		String email=request.getParameter("email");
	String pass=request.getParameter("pass");
	System.out.println(email+"\n"+pass);
	HttpSession session =request.getSession();
	String Table=session.getAttribute("UserType").toString();
	DBC dbc =new DBC();
	
	try {
		if(dbc.authenticate(Table, email, pass)&&email!="") {
			System.out.println("verified");
			session.setAttribute("email",email );
			response.sendRedirect("loged_"+Table+".jsp");
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
	} catch (SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
