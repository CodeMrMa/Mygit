package com.ma.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class utis {
	private String Driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/demo";
	private String username="root";
	private String password="1314520";
	
	
	
	
	
	@Test
	public void  getText() throws ClassNotFoundException, SQLException{
		Class.forName(Driver);
		Connection connection = DriverManager.getConnection(url,username,password);
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement.executeQuery("select * from user");
		while(executeQuery.next()){
			System.out.println(executeQuery.getString("username"));
			
		}
		executeQuery.close();
		createStatement.close();
		connection.close();
		
	}
	
}
