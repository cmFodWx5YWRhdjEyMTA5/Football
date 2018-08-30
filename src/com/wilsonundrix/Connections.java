package com.wilsonundrix;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connections {
	static Connection conn;
	public static Connection MySql(){
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully....");
			String url = "jdbc:mysql://localhost:3306/football";
			conn = DriverManager.getConnection(url,"root","");
			System.out.println("Connection successful....");
			
		}catch(Exception e){e.printStackTrace();}
		
		
		return conn;
	}
}
