package database;

import java.sql.SQLException;

public class Demo extends Conections {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		connect();
		int i=1;
		String query="Select name from buyers where id= ?;";
		pst=con.prepareStatement(query);
		//pst.setString(1,"name");
		while (true) {
			pst.setInt(1,i);
			rs=pst.executeQuery();
			if(!rs.next()) {
				break;
			}else {
				//rs.next() ;
				String name=rs.getString(1);
				System.out.println(name);
				i++;
			}
		}
	}

}
