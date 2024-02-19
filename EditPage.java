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

public class EditPage extends Frame {

	TextField  txtid, txtname, txtsalary, txtincentive, txttarget, txtallowance, txtcommission;
	Label  lbid, lbname, lbsalary, lbincentive, lbtarget, lballowance, lbcommission;
	Button btUpdate;
	
	
	
	public EditPage()
	{
		txtid = new TextField(20);
		txtname = new TextField(20);
		txtsalary = new TextField(20);
		txtincentive = new TextField(20);
		txttarget = new TextField(20);
		txtallowance = new TextField(20);
		txtcommission = new TextField(20);
		
		lbid = new Label("ID");
		lbname = new Label("Name");
		lbsalary = new Label("Salary");
		lbincentive = new Label("Incentive");
		lbtarget = new Label("Target");
		lballowance = new Label("Allowance");
		lbcommission = new Label("Comm");
		
		
		btUpdate = new Button("Update");
		
		this.setTitle("Edit Page");
		this.setLayout(new FlowLayout(30,20,30));
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(200, 300, 400, 600);
		
		
		lbid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbsalary.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtsalary.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbincentive.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtincentive.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbtarget.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txttarget.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lballowance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtallowance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbcommission.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtcommission.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btUpdate.setFont(new Font("arial", Font.PLAIN,20));
		btUpdate.setPreferredSize(new Dimension(100, 40));
		btUpdate.setForeground(Color.magenta);
		
		this.add(lbid);
		this.add(txtid);
		this.add(lbname);
		this.add(txtname);
		this.add(lbname);
		this.add(txtname);
		this.add(lbsalary);
		this.add(txtsalary);
		this.add(lbincentive);
		this.add(txtincentive);
		this.add(lbtarget);
		this.add(txttarget);
		this.add(lballowance);
		this.add(txtallowance);
		this.add(lbcommission);
		this.add(txtcommission);
		this.add(btUpdate);
		
		MyWindowListener mw = new MyWindowListener(this);
		this.addWindowListener(mw);
		
		btUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				Connection con = null;
				
				String id = txtid.getText();
				String name = txtname.getText();
				String salary = txtsalary.getText();
				String incentive = txtincentive.getText();
				String target = txttarget.getText();
				String allowance = txtallowance.getText();
				String commission = txtcommission.getText();
				
				
				try 
				{
					
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usersuperuserminiproject","root","Girish*@7");
					
					/*if(sm.getTxtId().equals(id))
					{
						System.out.println("salesmanager");
					}*/
					PreparedStatement pstmt = con.prepareStatement("update dao set name=?, salary=?, incentive=?, target=?, allowance=?, commission=? where id=?");
					pstmt.setString(1, name);
					pstmt.setString(2, salary);
					pstmt.setString(3, incentive);
					pstmt.setString(4, target);
					pstmt.setString(5, allowance);
					pstmt.setString(6, commission);
					pstmt.setString(7, id);
					
					
					pstmt.executeUpdate(); 
					
					
					
					
					
					/*if(rs.next())
					{
						
						JOptionPane.showMessageDialog(btUpdate, "info updated");
						
						
					}*/
					
					 if(e.getSource()==btUpdate && (!name.equals("") && !salary.equals("") && !incentive.equals("") && !target.equals("") && !allowance.equals("") && !commission.equals("") && !id.equals("")))
					{
						JOptionPane.showMessageDialog(btUpdate, "updated");
					}
					
					else
					{
						JOptionPane.showMessageDialog(btUpdate, "please enter all details!");
					}
					
				} 
				
				
				catch (Exception e1) 
				{
					//JOptionPane.showMessageDialog(btSubmit,"please enter only numbers!");
					
					e1.printStackTrace();
				}
				
			}
		});
		
	}
}
