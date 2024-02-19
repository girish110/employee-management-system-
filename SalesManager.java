package miniproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SalesManager extends Frame {

	Label lbId, lbName, lbSalary, lbIncentive, lbTarget;
	TextField txtId, txtName, txtSalary, txtIncentive, txtTarget;
	Button btSubmit, btback;
	//TextArea txtarea;
	
	
	public Label getLbId() {
		return lbId;
	}
	public void setLbId(Label lbId) {
		this.lbId = lbId;
	}
	public Label getLbName() {
		return lbName;
	}
	public void setLbName(Label lbName) {
		this.lbName = lbName;
	}
	public Label getLbSalary() {
		return lbSalary;
	}
	public void setLbSalary(Label lbSalary) {
		this.lbSalary = lbSalary;
	}
	public Label getLbIncentive() {
		return lbIncentive;
	}
	public void setLbIncentive(Label lbIncentive) {
		this.lbIncentive = lbIncentive;
	}
	public Label getLbTarget() {
		return lbTarget;
	}
	public void setLbTarget(Label lbTarget) {
		this.lbTarget = lbTarget;
	}
	public TextField getTxtId() {
		return txtId;
	}
	public void setTxtId(TextField txtId) {
		this.txtId = txtId;
	}
	public TextField getTxtName() {
		return txtName;
	}
	public void setTxtName(TextField txtName) {
		this.txtName = txtName;
	}
	public TextField getTxtSalary() {
		return txtSalary;
	}
	public void setTxtSalary(TextField txtSalary) {
		this.txtSalary = txtSalary;
	}
	public TextField getTxtIncentive() {
		return txtIncentive;
	}
	public void setTxtIncentive(TextField txtIncentive) {
		this.txtIncentive = txtIncentive;
	}
	public TextField getTxtTarget() {
		return txtTarget;
	}
	public void setTxtTarget(TextField txtTarget) {
		this.txtTarget = txtTarget;
	}
	public Button getBtSubmit() {
		return btSubmit;
	}
	public void setBtSubmit(Button btSubmit) {
		this.btSubmit = btSubmit;
	}
	public Button getBtback() {
		return btback;
	}
	public void setBtback(Button btback) {
		this.btback = btback;
	}
	
	
	Connection con=null;
	
	public SalesManager()
	{
		//txtarea=new TextArea("enter the following details:-");
		
		lbId=new Label("Id");
		lbName=new Label("Name");
		lbSalary=new Label("Salary");
		lbIncentive=new Label("Incentive");
		lbTarget=new Label("Target");
		
		txtId=new TextField(20);
		txtName=new TextField(16);
		txtSalary=new TextField(15);
		txtIncentive=new TextField(15);
		txtTarget=new TextField(15);
		
		
		btSubmit=new Button("Submit");
		btback=new Button("back to LoginPage");
		
		this.setLayout(new FlowLayout(20, 20, 30));
		
//		lbId.setLocation(50,50);
//		txtId.setLocation(50, 50);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Salesmanager");
		this.setBounds(400, 300,350, 500);
		this.setBackground(Color.LIGHT_GRAY);
		this.setForeground(Color.BLACK);
		btSubmit.setBackground(Color.white);
		
		
		lbId.setFont(new Font("arial",Font.PLAIN,20));
		lbName.setFont(new Font("arial",Font.PLAIN,20));
		lbSalary.setFont(new Font("arial",Font.PLAIN,20));
		lbIncentive.setFont(new Font("arial",Font.PLAIN,20));
		lbTarget.setFont(new Font("arial",Font.PLAIN,20));
        
		btSubmit.setPreferredSize(new Dimension(80,30));
		btback.setPreferredSize(new Dimension(150,30));
		
		btSubmit.setFont(new Font("Times New Roman",Font.PLAIN,15));
		btback.setFont(new Font("Times New Roman",Font.PLAIN,15));
		btback.setForeground(Color.red);
		/*btAdd.setPreferredSize(new Dimension(50,30));
		btAdd.setFont(new Font("arial", Font.PLAIN,15));
		btRemove.setPreferredSize(new Dimension(80,30));
		btRemove.setFont(new Font("arial", Font.PLAIN,15));
		btEdit.setPreferredSize(new Dimension(50,30));
		btEdit.setFont(new Font("arial", Font.PLAIN,15));
		btBack.setPreferredSize(new Dimension(50,30));
		btBack.setFont(new Font("arial", Font.PLAIN,15));*/
		
		//this.add(txtarea);
		this.add(lbId);
		this.add(txtId);
		this.add(lbName);
		this.add(txtName);
		this.add(lbSalary);
		this.add(txtSalary);
		this.add(lbIncentive);
		this.add(txtIncentive);
		this.add(lbTarget);
		this.add(txtTarget);
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
					SalesManager.this.dispose();
				}
				
			}
		});// action listener ends here
		
		
		btSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
					SalesManagerDao smd= new SalesManagerDao();
					smd.InsertSalesManager(txtId.getText(), txtName.getText(), 
							txtSalary.getText(), txtIncentive.getText(), txtTarget.getText() );
			
				
					if(e.getSource()==btSubmit && (!txtId.getText().equals("") && !txtName.getText().equals("") && !txtSalary.getText().equals("") && !txtIncentive.getText().equals("") && !txtTarget.getText().equals("")))
					{
						JOptionPane.showMessageDialog(btSubmit, "details inserted successfully");
						new LoginPage();
						SalesManager.this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(btSubmit, "enter all the values!");
					}
				}
				
				
		});// action listener ends here
		
	}// SalesManager constructor ends here
}	 // class SalesManager ends here
