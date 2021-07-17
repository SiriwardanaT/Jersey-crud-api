package com.dev.crudapid.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	Connection con;
	
	
	public  Connection getConnection() {
		Constants constant =  Constants.getConstant();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url =constant.URL;
			con = DriverManager.getConnection(url,constant.ROOT,constant.PASSWORD);
			return con;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	public static void main(String[] args) {
		DatabaseConnection db = new DatabaseConnection();
		//database connection successfully
		System.out.println(db.getConnection());
	}

}
