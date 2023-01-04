package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

public class AdminOperationsDB extends Conections{
	public ArrayList<Integer> readLand() throws SQLException, ClassNotFoundException {
		connect();
		ArrayList<Integer> prop_id= new ArrayList<Integer>();
		String query="SELECT * from land ;";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();
		fmt.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n" ,"landID","sellersID","location","area","dtcp","type","availability","cost"); 
		System.out.println(fmt);
		makeLine('=');
		System.out.println();
		while(rs.next()) {
			prop_id.add(rs.getInt(1));
			Formatter val = new Formatter();  
			val.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
			System.out.println(val);
			makeLine('-');
			System.out.println();
		}
		close();
		return prop_id; 
	}
	public ArrayList<Integer> readHouse() throws SQLException, ClassNotFoundException {
		connect();
		ArrayList<Integer> prop_id= new ArrayList<Integer>();
		String query="SELECT * from house ;";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();
		fmt.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n" ,"HouseID","sellersID","location","area","dtcp","type","Used For","Applicable for","Available from","No.Of.BHK","HighLights","Cost"); 
		System.out.println(fmt);
		makeLine('=');
		System.out.println();
		while(rs.next()) {
			prop_id.add(rs.getInt(1));
			Formatter val = new Formatter(); 
			val.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n", rs.getString(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
			System.out.println(val);
			makeLine('-');
			System.out.println();
		}
		close();
		return prop_id; 
	}
	
	public ArrayList<Integer> readBuyers() throws SQLException, ClassNotFoundException {
		connect();
		ArrayList<Integer> buyer_id= new ArrayList<Integer>();
		String query="SELECT * from buyers ;";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();
		fmt.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n" ,"BuyersID","email","name","age","gender","phno","designation"); 
		System.out.println(fmt);
		makeLine('=');
		System.out.println();
		while(rs.next()) {
			buyer_id.add(rs.getInt(1));
			Formatter val = new Formatter(); 
			val.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n", rs.getString(1), rs.getString(2), 
					rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			System.out.println(val);
			makeLine('-');
			System.out.println();
		}
		close();
		return buyer_id; 
	}
	public ArrayList<Integer> readSellers() throws SQLException, ClassNotFoundException {
		connect();
		ArrayList<Integer> sellers_id= new ArrayList<Integer>();
		String query="SELECT * from sellers ;";
		rs=st.executeQuery(query);
		Formatter fmt = new Formatter();
		fmt.format("|%20s |%20s |%20s |%20s |%20s|\n" ,"SellersID","email","name","gender","phno"); 
		System.out.println(fmt);
		makeLine('=');
		System.out.println();
		while(rs.next()) {
			sellers_id.add(rs.getInt(1));
			Formatter val = new Formatter(); 
			val.format("|%20s |%20s |%20s |%20s |%20s |%20s |%20s|\n", rs.getString(1), rs.getString(2), 
					rs.getString(4), rs.getString(5), rs.getString(6));
			System.out.println(val);
			makeLine('-');
			System.out.println();
		}
		close();
		return sellers_id; 
	}
	private  void makeLine(char pattern) throws SQLException, ClassNotFoundException {
		int len=500;
		for(int i=1;i<=len;i++) {
			System.out.print(pattern);
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AdminOperationsDB aodb=new AdminOperationsDB();
		aodb.readBuyers();
	}
}
