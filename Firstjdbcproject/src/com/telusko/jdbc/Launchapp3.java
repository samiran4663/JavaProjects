package com.telusko.jdbc;
import java.sql.*;
public class Launchapp3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Load and Register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Establish the connection
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="samiran752004";
		Connection connect=DriverManager.getConnection(url, user, password);
		
		//execute the query
		Statement st=connect.createStatement();
		String sql="insert into studentinfo values(2,'Soumik Dutta','21','Sahaganj')";
		if(st.execute(sql)) {
			// select
			System.out.println("If block executed");
			ResultSet rs=st.getResultSet();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			rs.close();
		}
		// insert , update , delete
		else 
		{
			System.out.println("Else block executed");
			int rows=st.getUpdateCount();
			if(rows==0) {
				System.out.println("Operation failed");
			}
			else {
				System.out.println("Operation successful");
			}
		}
		// close the resources
		st.close();
		connect.close();
		

	}

}
