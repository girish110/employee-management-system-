package miniproject;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Admin extends Frame{

	Label lbId, lbName, lbSalary, lbAllowance;
	TextField txtId, txtName, txtSalary, txtAllowance;
	Button btSubmit, btback;
	
	public Admin()
	{
		lbId=new Label("Id");
		lbName=new Label("Name");
		lbSalary=new Label("Salary");
		lbAllowance=new Label("Allowance");
		
		
		txtId=new TextField(20);
		txtName=new TextField(20);
		txtSalary=new TextField(20);
		txtAllowance=new TextField(20);
		
		
		
		btSubmit=new Button("Submit");
		btback=new Button("back to LoginPage");
		
		
		btSubmit.setPreferredSize(new Dimension(70,40));
		btSubmit.setFont(new Font("arial", Font.PLAIN,15));
		btback.setPreferredSize(new Dimension(140,40));
		btback.setFont(new Font("arial", Font.PLAIN,15));
		
		btSubmit.setForeground(Color.black);
		btback.setForeground(Color.red);
		
		
		lbId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbSalary.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbAllowance.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		this.setLayout(new FlowLayout(20, 20, 20));
		//this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Admin");
		this.setBounds(400, 300, 250, 600);
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.BLACK);
		btSubmit.setBackground(Color.white);
		
		this.add(lbId);
		this.add(txtId);
		this.add(lbName);
		this.add(txtName);
		this.add(lbSalary);
		this.add(txtSalary);
		this.add(lbAllowance);
		this.add(txtAllowance);
		this.add(btSubmit);
		this.add(btback);
		
		MyWindowListener mw=new MyWindowListener(this);
		this.addWindowListener(mw);
		
		
		btback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(e.getSource()==btback)
				{
					new LoginPage();
					Admin.this.dispose();
				}
				
			}
		});
		btSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AdminDao ad = new AdminDao();
				ad.InsertAdmin(txtId.getText(), txtName.getText(), txtSalary.getText(), txtAllowance.getText());
				
				if(e.getSource()==btSubmit && (!txtId.getText().equals("") && !txtName.getText().equals("") && !txtSalary.getText().equals("") && !txtAllowance.getText().equals("")))
				{
					JOptionPane.showMessageDialog(btSubmit, "inserted success");
					new LoginPage();
					Admin.this.dispose();
				}
				else
				{
					
					//if(e.getSource()==btSubmit && (txtId.getText().equals("") || txtName.getText().equals("") || txtSalary.getText().equals("") || txtAllowance.getText().equals("")))
					//{
					//}
						JOptionPane.showMessageDialog(btSubmit, "please insert all the values");
					
				}
				
			}
		});
	}
}
