package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BuyerOperationsDB extends Conections {
	static Scanner scan=new Scanner(System.in);

	public void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//readLand("ch",10,10000,10,10000,"farm");
	}
	
	public void readLand(String location_regexp,int cost_start,int cost_end,int area_start,int area_end,String type_regexp) throws ClassNotFoundException, SQLException {
		connect();
		String query="SELECT * FROM land WHERE "
				+ "location REGEXP '"+location_regexp+"' "
				+ "AND area BETWEEN "+area_start+" AND "+area_end+" "
				+ "AND type REGEXP '"+type_regexp+"' "
				+ "AND cost BETWEEN "+cost_start+" AND "+cost_end+" "
				+ "AND availability='yes';";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();
		fmt.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n" ,"landID","location","area","dtcp","type","availability","cost"); 
		System.out.println(fmt);
		makeLine('=');
		System.out.println();
		while(rs.next()) {
			Formatter val = new Formatter();  
			val.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n", rs.getString(1), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
			System.out.println(val);
			makeLine('-');
			System.out.println();
		}
		close(); 
	}
	public void readHouse(String location_regexp,int area_start,int area_end,String type_regexp,String used_for_regexp,String applicable_for_regexp_,int bhk_count,int cost_start,int cost_end,String current_date) throws SQLException, ClassNotFoundException {
		connect();
		String query="SELECT * from house where "
				+ "location REGEXP '"+location_regexp+"' "
				+ "AND area BETWEEN "+area_start+" AND "+area_end+" "
				+ "AND type REGEXP '"+type_regexp+"' "
				+ "AND used_for REGEXP '"+used_for_regexp+"' "
				+ "AND applicable_for REGEXP '"+applicable_for_regexp_+"' "
				+ "AND bhk_count ="+bhk_count+" "
				+ "AND cost BETWEEN "+cost_start+" AND "+cost_end+" "
				+ "AND available_from <= '"+current_date+"' ;";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();
		fmt.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n" ,"HouseID","location","area","dtcp","type","Used For","Applicable for","Available from","No.Of.BHK","HighLights","Cost"); 
		System.out.println(fmt);
		makeLine('=');
		System.out.println();
		while(rs.next()) {
			Formatter val = new Formatter();  
			val.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n", rs.getString(1), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			System.out.println(val);
			makeLine('-');
			System.out.println();
		}
		close(); 
	}
	private  void makeLine(char pattern) throws SQLException, ClassNotFoundException {
		int len=500;
		for(int i=1;i<=len;i++) {
			System.out.print(pattern);
		}

	}
}