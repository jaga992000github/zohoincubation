package database;

import java.sql.SQLException;
import java.util.ArrayList;

public class CRUD extends Conections {
	public static String getColumnNameByIndex(String Table,int index) throws SQLException {
		String col_nameQuery="select column_name \r\n" + 
				"from information_schema.columns \r\n" + 
				"where table_name = '"+Table+"' and ordinal_position ="+index+";";
		rs=st.executeQuery(col_nameQuery);
		rs.next();
		return rs.getString(1);
	}
	public static int getColumnCount(String Table) throws SQLException, ClassNotFoundException {
		String query="SELECT COUNT(*) AS NUMBEROFCOLUMNS FROM INFORMATION_SCHEMA. COLUMNS WHERE table_name = '"+Table+"';";
		rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	
	public static void insert(ArrayList values,String Table) throws SQLException, ClassNotFoundException  {
		connect();
		String insertquery;
		String col_1= null;//first column
		String lastID=null;//last prime key
		col_1=getColumnNameByIndex(Table,1);
			insertquery="insert into "+Table+"("+col_1+") value('0');";
			st.executeUpdate(insertquery);
			String lastidQuery="SELECT "+col_1+" from "+Table+" ORDER BY "+col_1+" desc ;";
			rs=st.executeQuery(lastidQuery);
			rs.next();
			lastID = rs.getString(1);
		for(int i=2;i<=values.size()+1;i++) {
			String col=getColumnNameByIndex(Table,i);//new colmn_name
			insertquery="update "+Table+" set "+col+"='"+values.get(i-2)+"' where "+col_1+"="+lastID+";";
			st.executeUpdate(insertquery);
		}close();
	}
	public static void update(String new_value,String Table,String col,int id) throws ClassNotFoundException, SQLException {
		connect();
		String col_1=getColumnNameByIndex(Table,1);
		String query="update "+Table+" set "+col+"='"+new_value+"' where "+col_1+"="+id+";";
		st.executeUpdate(query);close();
	}
	public static ArrayList readRow(String Table,int id) throws ClassNotFoundException, SQLException {
		connect();
		ArrayList values=new ArrayList();
		int col_count=getColumnCount(Table);
		String col_1=getColumnNameByIndex(Table,1);
		String query="select * from "+Table+" where "+col_1+"="+id+";";
		rs=st.executeQuery(query);
		rs.next();
		for(int i=2;i<=col_count;i++) {
			String value=rs.getString(i);
			//System.out.println(getColumnNameByIndex(Table,i)+": "+value);
			values.add(value);
		}
		return values;
	}
	public static void deleteRow(int id,String Table) throws SQLException, ClassNotFoundException {
		connect();
		String col_1=getColumnNameByIndex(Table,1);
		String query="DELETE FROM "+Table+" WHERE "+col_1+"="+id+";";
		st.executeUpdate(query);close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		deleteRow(6,"land");
	}
	
}
