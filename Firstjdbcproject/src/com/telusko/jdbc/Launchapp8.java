package com.telusko.jdbc;
import java.util.*;
import java.sql.*;
public class Launchapp8 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String password="samiran752004";
		//prepare the query
		String sql="select id,sname,scity from studentinfo where id=?";
		try(Scanner sc=new Scanner(System.in);
				Connection connect=DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt=connect.prepareStatement(sql))
		{
			//Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Enter the fields to retreive:");
			System.out.println("Enter the id:");
			int id=sc.nextInt();
			pstmt.setInt(1, id);
			try(ResultSet st=pstmt.executeQuery())
			{
				if(!st.isBeforeFirst())
				{
					System.out.println("No such record found with given id");
				}
				else {
					while(st.next())
					{
						System.out.println("ID:"+st.getInt(1)+" Name:"+st.getString(2)+" City:"+st.getString(3));
					}
				}
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
