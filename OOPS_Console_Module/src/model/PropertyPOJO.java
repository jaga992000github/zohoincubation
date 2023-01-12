package model;

public abstract class PropertyPOJO {
	private String location;
	private int area;
	private String dtcp;
	private int cost;
	
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getDtcp() {
		return dtcp;
	}
	public void setDtcp(String dtcp) {
		this.dtcp = dtcp;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
}
