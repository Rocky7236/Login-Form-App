package com.prog.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Get_Connection implements Connection_Information{
	
	static Connection con = null;
	
	public static Connection getConnection()
	{
		try {
			
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcUrl,jdbcUsername,jdbcPassword);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}

}
