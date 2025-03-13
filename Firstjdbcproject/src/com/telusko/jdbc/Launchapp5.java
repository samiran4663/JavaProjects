package com.telusko.jdbc;
import java.util.*;
import java.sql.*;
public class Launchapp5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect=null;
		PreparedStatement ptsmt=null;
		Scanner sc=new Scanner(System.in);
		try {
			connect=JdbcUtil.getConnection();
			String query="insert into studentinfo (id,sname,sage,scity) values(?,?,?,?)";
			ptsmt=connect.prepareStatement(query);
			System.out.println("Enter the details to be entered in db");
			int i=1;
			while(i<=10) {
				System.out.println("Enter id:");
				 int id=sc.nextInt();
				System.out.println("Enter the name:");
				 String sname=sc.next();
				System.out.println("Enter the age:");
				 int age=sc.nextInt();
				System.out.println("Enter the city");
				String scity=sc.next();
				ptsmt.setInt(1, id);
				ptsmt.setString(2, sname);
				ptsmt.setInt(3,age);
				ptsmt.setString(4,scity);
				int rows=ptsmt.executeUpdate();
				if(rows==0) {
					System.out.println("Operation failed");
				}
				else {
					System.out.println("Operation successful");
				}
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			sc.close();
			try 
			{
				JdbcUtil.closeResources(connect, ptsmt);
			} catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
