import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtil {

	static 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		String url="jdbc:mysql://localhost:3306/telusko_db";
		String username="root";
		String password="samiran752004";
		Connection con=null;
		try 
		{
			con=DriverManager.getConnection(url, username, password);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void closeresource(Connection con,PreparedStatement pst)
	{
		if(con!=null && pst!=null)
		{
			try 
			{
				pst.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
