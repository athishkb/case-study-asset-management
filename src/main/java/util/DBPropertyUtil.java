package util;

import java.sql.*;

public class DBPropertyUtil {
	private static Connection connection = null;
	
	public DBPropertyUtil(){
		try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assetmanagement", "root", "Server#1234");
            
		}
        catch(Exception e)
        {
        	System.out.println(e);
        }
 
	}
	
	public static Connection getconnect() {
		DBPropertyUtil c=new DBPropertyUtil();
		return connection;
	}
	
	
	
 
	}

