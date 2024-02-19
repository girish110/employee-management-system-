package miniproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

public class BtRemovePage extends Frame  {

	Label lbId;
	TextField txtId;
	Button btSubmit,btback;
	
	
	Connection con=null;
	
	public BtRemovePage()
	{
		
		try 
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usersuperuserminiproject","root","Girish*@7");
			
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		lbId=new Label("enter Id to be removed:-");
		txtId=new TextField(20);
		btSubmit=new Button("Submit");
		btback=new Button("back");
		
		lbId.setFont(new Font("arial",Font.BOLD,20));
		
		
		this.setTitle("BtRemove Page");
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(300, 400, 400, 300);
		//this.setLayout(new FlowLayout());
		this.setBackground(Color.YELLOW);
		btback.setForeground(Color.red);
		this.setLayout(new FlowLayout(70, 80, 10));
		
		btSubmit.setFont(new Font("Times New Roman",Font.PLAIN,15));
		btback.setFont(new Font("Times New Roman",Font.PLAIN,15));
		
		
		
		this.add(lbId);
		this.add(txtId);
		this.add(btSubmit);
		this.add(btback);
		
		MyWindowListener mw=new MyWindowListener(this);
		this.addWindowListener(mw);
		
		btback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btback)
				{
					new SuperUserHomePage();
					BtRemovePage.this.dispose();
				}
				
			}
		});
		
		btSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int id = Integer.parseInt(txtId.getText());
				try 
				{
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usersuperuserminiproject","root","Girish*@7");
					PreparedStatement pstmt = con.prepareStatement("select * from dao where id=?");
					pstmt.setInt(1, id);
					ResultSet rs = pstmt.executeQuery();  // resultset should be used mandatorily to delete a record from database using rs.next()
					// exexcuteupdate() does not work on resultset, only executequery() works
					
					if(rs.next())
					{
						PreparedStatement stmt = con.prepareStatement("delete from dao where id=?");
						stmt.setInt(1, id);
						stmt.executeUpdate();
						JOptionPane.showMessageDialog(btSubmit, "ID deleted successfully!");
						BtRemovePage.this.dispose();
						
					}
					else if(e.getSource()==btSubmit && txtId.getText().equals(""))
					{
						JOptionPane.showMessageDialog(btSubmit, "please enter an ID");
					}
					else
					{
						JOptionPane.showMessageDialog(btSubmit, "ID not found");
					}
					
				} 
				catch (Exception e1) 
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
	}



	}
