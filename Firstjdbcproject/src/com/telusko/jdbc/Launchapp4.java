package com.telusko.jdbc;
import java.sql.*;
public class Launchapp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connect=null;
		Statement stmt=null;
		
		try 
		{
			connect=JdbcUtil.getConnection();
			
			stmt=connect.createStatement();
			String sql="insert into studentinfo values(3,'Swapnil Das',21,'Pandua')";
			if(stmt.execute(sql)) 
			{
				ResultSet rs=stmt.getResultSet();
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			}
			else 
			{
				int rows=stmt.getUpdateCount();
				if(rows==0) 
				{
					System.out.println("Operation Failed");
				}
				else 
				{
					System.out.println("Operation successful");
				}
			}
			
			JdbcUtil.closeResources(connect, stmt);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		

	}

}
