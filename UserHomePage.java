package miniproject;

import java.awt.*;
import java.awt.event.*;

public class UserHomePage extends Frame implements ActionListener{

	Button btSearch, btCalsal,btBack;
	
	public UserHomePage()
	{
		btSearch=new Button("Search");
		btCalsal=new Button("calculate salary");
		btBack=new Button("back");
		
		this.setLayout(new FlowLayout());
		this.setTitle("UserHomePage");
		this.setBounds(400,300,300,200);
		this.setVisible(true);
		this.setResizable(false);
		btSearch.setPreferredSize(new Dimension(70,50));
		btCalsal.setPreferredSize(new Dimension(70,30));
		
		btSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btCalsal.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		btBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		btBack.setForeground(Color.red);
		this.add(btSearch);
		this.add(btCalsal);
		this.add(btBack);
		
		MyWindowListener mw=new MyWindowListener(this);
		this.addWindowListener(mw);
		
		btBack.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btBack)
		{
			new LoginPage();
			UserHomePage.this.dispose();
		}
		
	}
}
