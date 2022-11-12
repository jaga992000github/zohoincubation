package hOPD;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//Class.forName("com.mysql.jdbc.driver");
			response.setContentType("text/html");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "992000");
			PrintWriter out =response.getWriter();
			
			String email=request.getParameter("textemail");
			String pass=request.getParameter("textPass");
			PreparedStatement pst=con.prepareStatement("select email from register where email=? and password=?");
			pst.setString(1, email);
			pst.setString(2, pass);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd=request.getRequestDispatcher("/welcome.html");
				rd.forward(request, response);
			}else {
				out.println("Wrong password or email");
				out.println("<a href=HomePage.html>Try again</a>");
				//System.out.println("Wrong");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
