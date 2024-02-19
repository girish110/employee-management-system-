package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HRDao extends HR {

	
	Connection con=null;
	
	public HRDao()
	{
		try 
		{
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usersuperuserminiproject","root","Girish*@7");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public  void InsertHR(String id, String name, String salary, String commission)
	{
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement("insert into dao (id, name, salary, commission) values (?, ?, ?, ?)");
			
			//pstmt=con.prepareStatement("insert into hrdao (id, name, salary, commission) values (?, ?, ?, ?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, salary);
			pstmt.setString(4, commission);
			pstmt.executeUpdate();
			
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
