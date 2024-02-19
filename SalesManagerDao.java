package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SalesManagerDao {

	
	
	Connection con=null;
	PreparedStatement pstmt=null;
	
	
	public SalesManagerDao()
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
	public  void InsertSalesManager(String id, String name, String salary, String incentive, String target)
	{
		
		try {
			pstmt=con.prepareStatement("insert into dao (id, name, salary, incentive, target) values (?, ?, ?, ?, ?)");
			pstmt=con.prepareStatement("insert into smdao (id, name, salary, incentive, target) values (?, ?, ?, ?, ?)");
			//pstmt=con.prepareStatement("insert into smdao (id, name, salary, incentive, target) values (?, ?, ?, ?, ?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, salary);
			pstmt.setString(4, incentive);
			pstmt.setString(5, target);
			pstmt.executeUpdate();
			
			
		} 
		
		catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "ID already taken! please enter a different id.");
			//e.printStackTrace();
		}
	}
	
	
	
	
	public void Receive(int id, String name, double salary, double incentive, double target)
	{
		try {
				pstmt=con.prepareStatement("update dao set name=?, salary=?, incentive=?, target=? where id=?");
			
				ResultSet rs = pstmt.executeQuery();
				
				rs.getString(2);
				rs.getString(3);
				rs.getString(4);
				rs.getString(5);
				rs.getString(1);
				
				
				pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	}
	
	

