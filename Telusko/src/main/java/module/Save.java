package module;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String Table=session.getAttribute("UserType").toString();
		ArrayList values=new ArrayList();
		boolean flag = false;
		if(Table.equals("buyers")) {
			String email=request.getParameter("email");
			try {
				flag=db.DBC.checkRegister(email, Table);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}if (flag) {response.sendRedirect(Table+" reg.html");}
			else {
			values.add(email);
			String pass=request.getParameter("pass");values.add(pass);
			String name=request.getParameter("name");values.add(name);
			String age=request.getParameter("age");values.add(age);
			String gender=request.getParameter("gender");values.add(gender);
			String phno=request.getParameter("phno");values.add(phno);
			String desn=request.getParameter("desn");values.add(desn);
			
			try {
				db.DBC.insert(values,Table);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("login.html");
				}
			
		}else if(Table.equals("sellers")){
			String email=request.getParameter("email");values.add(email);
			try {
				flag=db.DBC.checkRegister(email, Table);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}if (flag) {response.sendRedirect(Table+" reg.html");}
			else {
			String pass=request.getParameter("pass");values.add(pass);
			String name=request.getParameter("name");values.add(name);
			String gender=request.getParameter("gender");values.add(gender);
			String phno=request.getParameter("phno");values.add(phno);
			
			try {
				db.DBC.insert(values,Table);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("login.html");
				}
		}
	}
}
