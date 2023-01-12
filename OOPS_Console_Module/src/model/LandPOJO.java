package model;
import java.util.*;
public class LandPOJO extends PropertyPOJO {
	
	private String type;
	private String availabilitty;
	private HashMap <String,ArrayList<String>> dd=new HashMap <String,ArrayList<String>>();
	
	
	
	public LandPOJO(String location, int area, String dtcp, String type, String availabilitty, int cost) {
		super();
		this.type = type;
		this.availabilitty = availabilitty;
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



	public String getAvailabilitty() {
		return availabilitty;
	}



	public void setAvailabilitty(String availabilitty) {
		this.availabilitty = availabilitty;
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
		type_dd.add("Farming");
		type_dd.add("House Site");
		type_dd.add("Comercial");
		dd.put("type", type_dd);
		
		ArrayList<String> availability_dd= new ArrayList<>();
		availability_dd.add("yes");
		availability_dd.add("no");
	}
}
