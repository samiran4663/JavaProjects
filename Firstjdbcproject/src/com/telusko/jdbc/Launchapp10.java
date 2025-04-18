package com.telusko.jdbc;
import java.sql.*;
public class Launchapp10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.getMessage();
		}
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="samiran752004";
		try(Connection conn=DriverManager.getConnection(url, user, password);Statement stmt=conn.createStatement())
		{
			String query1="update studentinfo set sage='24' where id=2";
			String query2="update studentinfo set sage='25' where id=4";
			String query3="update studentinfo set sage='26' where id=5";
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			int rowsaffected[]=stmt.executeBatch();
			System.out.println("Batch updated succesfull.Rows affected:"+rowsaffected.length);
			
			
		}
		catch(SQLException se)
		{
			se.getMessage();
		}
		catch(Exception e)
		{
			e.getMessage();
		}

	}

}
