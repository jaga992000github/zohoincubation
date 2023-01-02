package module;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;

import db.DBC2;

/**
 * Servlet implementation class EditProperties
 */
@WebServlet("/EditProperties")
public class EditProperties extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json="";
		try {
			json=DBC2.PropertyDisplay(9,"land").toString();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//String json="[[\"chennai\",\"thenkasi\"],[hi]]";
		JSONArray arr = new JSONArray(json);
		try {
			sendJSON(request,response,json);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendJSON(HttpServletRequest request, HttpServletResponse response,String json_str) throws IOException, ParseException {
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write( json_str);
	}
}
