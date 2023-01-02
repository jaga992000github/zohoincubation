package core_module;

import java.sql.SQLException;

interface Operations{
	public abstract void operate() throws ClassNotFoundException, SQLException;	
}
