package com.telusko.jdbc;
import java.util.*;
import java.sql.*;
public class Launchapp9 {

	public static void main(String[] args) {
		//load and Register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/jdbclearning";
		String user="root";
		String passowrd="samiran752004";
		String sql="insert into studentinfo (id,sname,sage,scity) values(?,?,?,?)";
		try(Scanner sc=new Scanner(System.in);Connection conn=DriverManager.getConnection(url, user, passowrd);PreparedStatement pstmt=conn.prepareStatement(sql))
		{
			System.out.println("Enter the fields to enter ");
			System.out.print("Enter the id");
			int id1=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the name:");
			String name1=sc.nextLine();
			System.out.print("Enter the age:");
			int age1=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the city:");
			String city1=sc.nextLine();
			pstmt.setInt(1, id1);
			pstmt.setString(2, name1);
			pstmt.setInt(3, age1);
			pstmt.setString(4, city1);
			pstmt.addBatch();
			
			System.out.print("Enter the id");
			int id2=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the name:");
			String name2=sc.nextLine();
			System.out.print("Enter the age:");
			int age2=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the city:");
			String city2=sc.nextLine();
			pstmt.setInt(1, id2);
			pstmt.setString(2, name2);
			pstmt.setInt(3, age2);
			pstmt.setString(4, city2);
			pstmt.addBatch();
			
			System.out.print("Enter the id");
			int id3=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the name:");
			String name3=sc.nextLine();
			System.out.print("Enter the age:");
			int age3=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter the city:");
			String city3=sc.nextLine();
			pstmt.setInt(1, id3);
			pstmt.setString(2, name3);
			pstmt.setInt(3, age3);
			pstmt.setString(4, city3);
			pstmt.addBatch();
			
			int [] rows=pstmt.executeBatch();
			System.out.println("Batch Update successfull. Rows affected:"+rows.length);
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
