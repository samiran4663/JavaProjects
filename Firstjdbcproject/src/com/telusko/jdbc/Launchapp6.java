package com.telusko.jdbc;
import java.sql.*;
import java.util.Scanner;
public class Launchapp6 {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection connect=null;
		PreparedStatement ptsmt=null;
		try {
			sc=new Scanner(System.in);
			//Load and Register
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish the connection
			String url="jdbc:mysql://localhost:3306/jdbclearning";
			String user="root";
			String password="samiran752004";
			connect=DriverManager.getConnection(url, user, password);
			
			String query="update studentinfo set scity= ? where id=3";
			ptsmt=connect.prepareStatement(query);
			
			System.out.println("Enter the new city:");
			String city=sc.next();
			ptsmt.setString(1,city);
			int rows=ptsmt.executeUpdate();
			if(rows==0) {
				System.out.println("Operation failed");
			}
			else {
				System.out.println("Operation successful");
			}
		
			
		}
		catch(SQLException e) {
			
		}
		catch(Exception e) {
			
		}
		finally {
			sc.close();
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
