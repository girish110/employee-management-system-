package miniproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginPage extends Frame implements ActionListener {

	TextField txtUsername, txtPassword;
	Label lbUsername, lbPassword;
	Button btLogin, btClear;
	
	public LoginPage()
	{
		txtUsername=new TextField(20);
		txtPassword=new TextField(20);
		lbUsername=new Label("Username");
		lbPassword=new Label("Password");
		btLogin=new Button("Login");
		btClear=new Button("Clear");
		
		this.setTitle("LoginPage");
		this.setLayout(new FlowLayout(10, 40, 15));  // new flowlayout() takes the parameters (int align, int horizontalgap, int vertical gap) , the gap mentioned is between the components
		//this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setBounds(500, 300, 400, 400);
		this.setResizable(false);
		//this.setBackground(Color.cyan);
		this.setForeground(Color.black);
		txtPassword.setEchoChar('*');
		btLogin.setPreferredSize(new Dimension(70,30));
		txtUsername.setBounds(100, 60, 120, 50);
		
		
		btLogin.setPreferredSize(new Dimension(70,40));
		btLogin.setFont(new Font("arial", Font.PLAIN,20));
		btClear.setPreferredSize(new Dimension(120,40));
		btClear.setFont(new Font("arial", Font.PLAIN, 20));
		
		btLogin.setForeground(Color.BLUE);
		btClear.setForeground(Color.BLUE);
		
		
		lbUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		this.add(lbUsername);
		this.add(txtUsername);
		this.add(lbPassword);
		this.add(txtPassword);
		
		this.add(btLogin);
		this.add(btClear);
		
		MyWindowListener mw=new MyWindowListener(this);
		this.addWindowListener(mw);
		
		btClear.addActionListener(this);
		btLogin.addActionListener(this);
	}

	void clear()
	{
		txtUsername.setText("");
		txtPassword.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String Username = txtUsername.getText();
		String Password = txtPassword.getText();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(e.getSource()==btLogin )
		{
			new SuperUserHomePage();
			LoginPage.this.dispose();   // now we want to redirect to superuserhomepage, But after redirecting we dont't want the previous frame so  we nned to follow a syntax to dispose it.
													  //  gui.this.dispose;  here gui to be disposed is LoginPage so we write LoginPage.this.dispose;
		}
		
		if(e.getSource()==btClear)
		{
			clear();
		}
		/*
		if(e.getSource()==btLogin && (Username.equals("Girish1102") && Password.equals("Girish")))
		{
			new SuperUserHomePage();
			LoginPage.this.dispose();   // now we want to redirect to superuserhomepage, But after redirecting we dont't want the previous frame so  we nned to follow a syntax to dispose it.
													  //  gui.this.dispose;  here gui to be disposed is LoginPage so we write LoginPage.this.dispose;
		}
		if(e.getSource()==btLogin && (!Username.equals("Girish1102") && !Password.equals("Girish") ))
		{
		
			JOptionPane.showMessageDialog(btLogin, "incorrect username or password!");
				
		}*/
		
		
		
		
	}

	
}

class MainClass
{
	public static void main(String[] args) {
		
		LoginPage lp=new LoginPage();
	}
	
}
