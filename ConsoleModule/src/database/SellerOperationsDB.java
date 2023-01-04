package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

public class SellerOperationsDB extends Conections {
	public void readLand(int sellersID) throws SQLException, ClassNotFoundException {
		connect();
		String query="SELECT * from land where sellersID="+sellersID+";";
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
	public void readHouse(int sellersID) throws SQLException, ClassNotFoundException {
		connect();
		String query="SELECT * from house where sellersID="+sellersID+";";
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
	public ArrayList readRow(String Table,int id) throws ClassNotFoundException, SQLException {
		connect();
		ArrayList values=new ArrayList();
		int col_count=CRUD.getColumnCount(Table);
		String col_1=CRUD.getColumnNameByIndex(Table,1);
		String query="select * from "+Table+" where "+col_1+"="+id+";";
		rs=st.executeQuery(query);
		rs.next();
		for(int i=3;i<=col_count;i++) {
			String value=rs.getString(i);
			//System.out.println(getColumnNameByIndex(Table,i)+": "+value);
			values.add(value);
		}
		return values;
	}
	public ArrayList<Integer> getPropertyIDs(String Table,int sellerID) throws ClassNotFoundException, SQLException {
		ArrayList<Integer> prop_id=new ArrayList<Integer>();
		connect();
		String query="select "+Table+"ID "+"from "+Table+" where sellersID="+sellerID+";";
		rs=st.executeQuery(query);
		while(rs.next()) {
			prop_id.add(rs.getInt(1));
		}
		//System.out.println(prop_id);
		return prop_id;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	}
}
