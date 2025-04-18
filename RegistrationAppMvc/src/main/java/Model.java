import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {

	private String fullname;
	private String email;
	private String password;
	private String gender;
	private String country;
	private Connection con;
	private PreparedStatement pst;
	private int rows;
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int register()
	{
		con=JdbcUtil.getConnection();
		if(con!=null)
		{
			try 
			{
				pst=con.prepareStatement("insert into personalinfo(fullname,email,passowrd,gender,country) values(?,?,?,?,?)");
				pst.setString(1, fullname);
				pst.setString(2, email);
				pst.setString(3, password);
				pst.setString(4, gender);
				pst.setString(5, country);
				rows=pst.executeUpdate();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				JdbcUtil.closeresource(con, pst);
			}
		}
		return rows;
	}
	
}
