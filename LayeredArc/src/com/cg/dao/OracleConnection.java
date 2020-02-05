package com.cg.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleConnection {
	static private OracleConnection conn ;
	private OracleConnection()
	{
		super();
	}
	
	public static OracleConnection getInstance(){
		if(conn == null)
			return new OracleConnection();
		return null;
	} 
	public Connection getConnection()throws SQLException, IOException{
		Properties dbProp = null;
		FileReader fr = null;
		fr = new FileReader("resources/oracle.properties");
		dbProp = new Properties();
		dbProp.load(fr);
		fr.close();
		System.out.println(dbProp.getProperty("jdbc.url"));
		Connection conn = DriverManager.getConnection(dbProp.getProperty("jdbc.url"), dbProp.getProperty("jdbc.user"), dbProp.getProperty("jdbc.password"));
		return conn;
	}
}
