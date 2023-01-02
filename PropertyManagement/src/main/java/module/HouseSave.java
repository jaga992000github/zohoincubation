package module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

/**
 * Servlet implementation class HouseSave
 */
@WebServlet("/HouseSave")
public class HouseSave extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HouseSave called"); 
		try {
			house(request, response);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}	
	protected void house(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, SQLException {
		String house_json=receiveJSON(request,response);
		JSONArray arr = new JSONArray(house_json);
		ArrayList a=(ArrayList) arr.toList();
		System.out.println(arr);
		HttpSession session=request.getSession();
		String email=session.getAttribute("email").toString();
		String Table=session.getAttribute("UserType").toString();
		int id=db.DBC.GetId(Table, email);
		ArrayList house_values=new ArrayList();
		house_values.add(id);
		for(int i=0;i<a.size();i++) {
			house_values.add(a.get(i));
		}
		db.DBC.insert(house_values,"house");
	}
	
	public static String receiveJSON(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
			br=null;
			//System.out.println(json);
		}
		return json;
	}
}

