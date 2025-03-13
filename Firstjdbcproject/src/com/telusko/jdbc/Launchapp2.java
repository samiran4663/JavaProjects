package com.telusko.jdbc;
import java.sql.*;
public class Launchapp2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//Load and Register
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Connection established
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="samiran752004";
		Connection connect=DriverManager.getConnection(url, user, password);
		
		//execute the query
		Statement st=connect.createStatement();
		String sql="delete from studentinfo where id='2'";
		int rowaffected=st.executeUpdate(sql);
		
		//process the result
		if(rowaffected==0) {
			System.out.println("Row not deleted");
		}
		else {
			System.out.println("Row is deleted succesfully");
		}
		//close the resources
		st.close();
		connect.close();

	}

}
