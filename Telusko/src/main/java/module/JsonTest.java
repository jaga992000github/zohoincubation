package module;
import org.json.JSONException;
import org.json.JSONObject;  
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JsonTest")
public class JsonTest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonStr = "{\"name\":\"SK\",\"arr\":{\"a\":\"1\",\"b\":\"2\"}}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        PrintWriter out=response.getWriter();
        out.print(jsonObj);
	}
	
}
