package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDao {

Connection con=null;
	
	
	
	public AdminDao()
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
	public  void InsertAdmin(String id , String name, String salary, String allowance)
	{
		PreparedStatement pstmt;
		try {
			
			pstmt=con.prepareStatement("insert into admindao (id, name, salary, allowance) values (?, ?, ?, ?)");
			//pstmt=con.prepareStatement("insert into admindao (id, name, salary, allowance) values (?, ?, ?, ?)");
			
			//pstmt=con.prepareStatement("Update admindao set id=?, name=?, salary=?, allowance=? ");  // this code should be written in edit page of admin
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, salary);
			pstmt.setString(4, allowance);
			
			pstmt.executeUpdate();
			
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
