package model;
import java.util.*;
public class HousePOJO extends PropertyPOJO {
	
	private String type;
	private String used_for;
	private String applicable_for;
	private String available_from;
	private int no_of_bhk;
	private HashMap <String,ArrayList<String>> dd=new HashMap <String,ArrayList<String>>();
	
	
	public HousePOJO(String location, int area, String dtcp, String type, String used_for, String applicable_for,
			String available_from, int no_of_bhk, int cost) {
		super();
		this.type = type;
		this.used_for = used_for;
		this.applicable_for = applicable_for;
		this.available_from = available_from;
		this.no_of_bhk = no_of_bhk;
		addDropDown();
	}
	
	public HashMap<String, ArrayList<String>> getDd() {
		return dd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUsed_for() {
		return used_for;
	}
	public void setUsed_for(String used_for) {
		this.used_for = used_for;
	}
	public String getApplicable_for() {
		return applicable_for;
	}
	public void setApplicable_for(String applicable_for) {
		this.applicable_for = applicable_for;
	}
	public String getAvailable_from() {
		return available_from;
	}
	public void setAvailable_from(String available_from) {
		this.available_from = available_from;
	}
	public int getNo_of_bhk() {
		return no_of_bhk;
	}
	public void setNo_of_bhk(int no_of_bhk) {
		this.no_of_bhk = no_of_bhk;
	}
	
	public void addDropDown() {	
		ArrayList<String> location_dd=new ArrayList<>();
		location_dd.add("Chennai");
		location_dd.add("Thenkaasi");
		location_dd.add("Coimbatore");
		dd.put("location", location_dd);
		
		ArrayList<String> dtcp_dd= new ArrayList<>();
		dtcp_dd.add("yes");
		dtcp_dd.add("no");
		dd.put("dtcp",dtcp_dd);
		
		ArrayList<String> type_dd=new ArrayList<>();
		type_dd.add("PG");
		type_dd.add("Seperate house");
		type_dd.add("Appartment");
		type_dd.add("Commercial");
		type_dd.add("Villa");
		type_dd.add("Office");
		dd.put("type", type_dd);
		
		ArrayList<String> used_for_dd= new ArrayList<>();
		used_for_dd.add("Rent");
		used_for_dd.add("Lease");
		used_for_dd.add("Sale");
		dd.put("used_for", used_for_dd);
		
		ArrayList<String> prefered_for_dd=new ArrayList<>();
		prefered_for_dd.add("Mens only");
		prefered_for_dd.add("Womens only");
		prefered_for_dd.add("Family");
		prefered_for_dd.add("Commercial");
		dd.put("prefered_for", prefered_for_dd);
	}
	
	
}
