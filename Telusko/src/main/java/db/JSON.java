package db;
import org.json.JSONException;
import org.json.JSONObject;    
public class JSON {
	public static void main(String[] args) throws JSONException {
        // TODO Auto-generated method stub

        String jsonStr = "{\"name\":\"SK\",\"arr\":{\"a\":\"1\",\"b\":\"2\"}}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        String name = jsonObj.getString("name");
        System.out.println(name);

        String first = jsonObj.getJSONObject("arr").getString("a");
        System.out.println(first);
	    }
	}
