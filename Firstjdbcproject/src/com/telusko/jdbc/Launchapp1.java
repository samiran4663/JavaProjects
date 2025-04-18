package com.telusko.jdbc;
import java.sql.*;
public class Launchapp1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//Load and Register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the Connection
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="samiran752004";
		Connection connect=DriverManager.getConnection(url, user, password);
		
		Statement statement = connect.createStatement();
		
		//execute the query
		String sql="update studentinfo set sname='Samiran Saha' where id='1'";
		int rowaffected=statement.executeUpdate(sql);
		//process the result
		if(rowaffected==0) {
			System.out.println("Record is not inserted properly");
		}
		else {
			System.out.println("Record is inserted successfully");
		}
		//closing the resources
		statement.close();
		connect.close();
		
		

	}

}
