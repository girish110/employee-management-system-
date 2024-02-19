package miniproject;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import miniproject.*;
public class BtEditPage extends Frame {

	Label lbId;
	TextField txtId;
	Button btSubmit;
	
	
	Connection con=null;
	
	void clear()
	{
		txtId.setText("");
		
	}
	public BtEditPage(TextField inputid,SalesManager sm, Admin as, HR hr)
	{
		lbId=new Label("enter ID to be edited:-");
		
		btSubmit=new Button("Submit");
		txtId=new TextField(20);
		this.setLayout(new FlowLayout(30, 80, 20));
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("BtEditPage");
		//this.setLayout(new FlowLayout());
		this.setBounds(300,300,350,300);
		
		lbId.setFont(new Font("Times New Roman", Font.BOLD ,15 ));
		
		btSubmit.setFont(new Font("Times New Roman", Font.BOLD ,15 ));
		btSubmit.setForeground(Color.BLUE);
		this.add(lbId);
		this.add(txtId);
		this.add(btSubmit);
		
		MyWindowListener mw=new MyWindowListener(this);
		this.addWindowListener(mw);
		
		btSubmit.addActionListener(new ActionListener() {
					
			
				
				public void actionPerformed(ActionEvent e) {
					
					
				String id = txtId.getText();
				
				
				//int i=Integer.parseInt(id);
				//int id = Integer.parseInt(txtId.getText());
				try 
				{
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usersuperuserminiproject","root","Girish*@7");
					PreparedStatement pstmt = con.prepareStatement("select * from dao where id=?");
					pstmt.setString(1, id);
					
					ResultSet rs = pstmt.executeQuery(); 
					
					int i=Integer.parseInt(id);
					
					
					
						
						if(rs.next())
						
						{
							
							JOptionPane.showMessageDialog(btSubmit, "ID found!");
							BtEditPage.this.dispose();
						}
						
						/*else if(e.getSource()==btSubmit && txtId.getText().equals(""))
						{
							JOptionPane.showMessageDialog(btSubmit, "please enter an ID");
						}*/
						else
						{
							JOptionPane.showMessageDialog(btSubmit, "ID not found");
							clear();
						}
					} 
					
					catch (Exception e1) 
					{
						if(e.getSource()==btSubmit && txtId.getText().equals(""))
						{
							JOptionPane.showMessageDialog(btSubmit,"This field cannot be empty!");
						}
						else
						{
							JOptionPane.showMessageDialog(btSubmit, "enter only numbers!");
							clear();
						}
					}
				}
			});
			
			
	}

	
}
