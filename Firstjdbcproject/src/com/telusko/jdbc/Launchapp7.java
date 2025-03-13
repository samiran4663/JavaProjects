package com.telusko.jdbc;
import java.util.*;
import java.sql.*;
public class Launchapp7 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="samiran752004";
		
		//prepare the query
		String query="delete from studentinfo where id=?";
		try(Scanner sc=new Scanner(System.in);
				Connection connect=DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt=connect.prepareStatement(query))
		{
			//Load and Register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//user-input for taking the id
			System.out.println("Enter the id for deleting");
			int id=sc.nextInt();
			pstmt.setInt(1, id);
			int rowsaffected=pstmt.executeUpdate();
			if(rowsaffected==0)
			{
				System.out.println("Delete operation failed");
			}
			else {
				System.out.println(rowsaffected+"row deleted succesfully");
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
