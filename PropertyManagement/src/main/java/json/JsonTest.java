package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class JsonTest
 */
@WebServlet("/JsonTest")
public class JsonTest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String json=receiveJSON(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json="{\"firstname\" : \"jagadeesh\" }";
		JSONObject obj = new JSONObject(json);
		
		try {
			sendJSON(request,response,json);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public static String receiveJSON(HttpServletRequest request, HttpServletResponse response) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		//String json="[\"obj1\"]";
		//JSONArray arr = new JSONArray(json);
		//System.out.println(arr.getString(0));
		if(br != null){
			json = br.readLine();
			br=null;
			System.out.println(json);//working well
		}
		return json;
	}
	public static void sendJSON(HttpServletRequest request, HttpServletResponse response,String json_str) throws IOException, ParseException {
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write( json_str);
	}

	}

