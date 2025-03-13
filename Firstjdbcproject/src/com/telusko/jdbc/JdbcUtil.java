package com.telusko.jdbc;
import java.sql.*;
public class JdbcUtil {
	static 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection  getConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="samiran752004";
		return DriverManager.getConnection(url, user, password);
	}
	public static void closeResources(Connection connect,Statement stmt) throws SQLException
	{
		stmt.close();
		connect.close();
	}
}
