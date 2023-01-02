package db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

public class DBC2 extends DBC {
	public static int NoOfCol(String Table) throws ClassNotFoundException, SQLException {
		connect();
		String query="SELECT count(*) as No_of_Column FROM information_schema.columns WHERE table_name ='"+Table+"';";
		rs=st.executeQuery(query);
		rs.next();
		String str_count = rs.getString(1);
		int count=Integer.parseInt(str_count);
		return count;
	}
	
	static int getLastId(String Table) throws SQLException, ClassNotFoundException {
		String id_col=getColumnNameByIndex(Table,1);
		String lastidQuery="SELECT "+id_col+" from "+Table+" ORDER BY landID desc ;";
		rs=st.executeQuery(lastidQuery);
		rs.next();
		String lastID = rs.getString(1);
		int id=Integer.parseInt(lastID);
		return id;
	}
	
	public static ArrayList PropertyDisplay(int seller_Id,String Table) throws ClassNotFoundException, SQLException {
		connect();
		int len= NoOfCol(Table);
		ArrayList row=new ArrayList<>();
		for(int i=3;i<=len;i++) {
			ArrayList col=new ArrayList<>();
			String query="SELECT "+getColumnNameByIndex(Table,i)+" FROM "+Table+" where sellersID= "+seller_Id+";";
			rs=st.executeQuery(query);
			while(rs.next()) {
				col.add("\""+rs.getString(1)+"\"");
			}row.add(col);
		}close();
		return row;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(PropertyDisplay(9,"land"));
	}
}
