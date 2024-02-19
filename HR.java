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

public class HR extends Frame {

	Label lbId, lbName, lbSalary, lbCommission;
	TextField txtId, txtName, txtSalary, txtCommission;
	Button btSubmit, btback;
	
	public HR()
	{
		lbId=new Label("Id");
		lbName=new Label("Name");
		lbSalary=new Label("Salary");
		lbCommission=new Label("Commission");
		
		
		txtId=new TextField(20);
		txtName=new TextField(20);
		txtSalary=new TextField(20);
		txtCommission=new TextField(20);
		
		
		
		btSubmit=new Button("Submit");
		btback=new Button("back to LoginPage");
		
		this.setLayout(new FlowLayout(20, 20, 15));
		//this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("HR");
		this.setBounds(400, 300, 260, 600);
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.BLACK);
		
		btSubmit.setBackground(Color.white);
		
		btSubmit.setForeground(Color.black);
		btback.setForeground(Color.red);
		
		lbId.setFont(new Font("arial",Font.PLAIN,20));
		lbName.setFont(new Font("arial",Font.PLAIN,20));
		lbSalary.setFont(new Font("arial",Font.PLAIN,20));
		lbCommission.setFont(new Font("arial",Font.PLAIN,20));
		
        
		btSubmit.setPreferredSize(new Dimension(80,30));
		btback.setPreferredSize(new Dimension(150,30));
		
		btSubmit.setFont(new Font("Times New Roman",Font.PLAIN,15));
		btback.setFont(new Font("Times New Roman",Font.PLAIN,15));
		
		
		this.add(lbId);
		this.add(txtId);
		this.add(lbName);
		this.add(txtName);
		this.add(lbSalary);
		this.add(txtSalary);
		this.add(lbCommission);
		this.add(txtCommission);
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
					HR.this.dispose();
				}
				
			}
		});
		
		
		btSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				HRDao hr= new HRDao();
				hr.InsertHR(txtId.getText(), txtName.getText(), 
						txtSalary.getText(),  txtCommission.getText() );
			
				
				
				if(e.getSource()==btSubmit && (!txtId.getText().equals("") && !txtName.getText().equals("") && !txtSalary.getText().equals("") &&   !txtCommission.getText().equals("")))
				{
					JOptionPane.showMessageDialog(btSubmit, "details inserted successfully");
					HR.this.dispose();
				}
				
				else
				{
					JOptionPane.showMessageDialog(btSubmit, "enter all the values!");
					HR.this.dispose();
				}
				
				
				}

	});

	}
}
