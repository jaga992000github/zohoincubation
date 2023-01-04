package controller_and_view;

import java.sql.SQLException;

interface Operations{
	public abstract void operate() throws ClassNotFoundException, SQLException;	
}
