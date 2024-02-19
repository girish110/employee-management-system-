package miniproject;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtAddPage extends Frame implements ActionListener {

	Button btSalesManager, btAdmin, btHR, btback;
	
	public BtAddPage()
	{
		btSalesManager=new Button("SalesManager");
		btAdmin=new Button("Admin");
		btHR=new Button("HR");
		btback=new Button("go back");
		
		this.setTitle("BtAdd Page");
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.setBounds(500, 200, 500, 200);
		this.setBackground(Color.magenta);
		btback.setForeground(Color.red);
		
		this.add(btSalesManager);
		this.add(btAdmin);
		this.add(btHR);
		this.add(btback);
		
		MyWindowListener mw=new MyWindowListener(this);
		this.addWindowListener(mw);
		
		btSalesManager.addActionListener(this);
		btHR.addActionListener(this);
		btAdmin.addActionListener(this);
		btback.addActionListener(this);
		
		btSalesManager.setPreferredSize(new Dimension(110,30));
		btSalesManager.setFont(new Font("arial", Font.PLAIN,15));
		btHR.setPreferredSize(new Dimension(50,30));
		btHR.setFont(new Font("arial", Font.PLAIN,15));
		btAdmin.setPreferredSize(new Dimension(60,30));
		btAdmin.setFont(new Font("arial", Font.PLAIN,15));
		btback.setPreferredSize(new Dimension(70,30));
		btback.setFont(new Font("arial", Font.PLAIN,15));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btSalesManager)
		{
			new SalesManager();
			BtAddPage.this.dispose();
		}
		
		if(e.getSource()==btHR)
		{
			new HR();
			BtAddPage.this.dispose();
		}
		
		if(e.getSource()==btAdmin)
		{
			new Admin();
			BtAddPage.this.dispose();
		}
		if(e.getSource()==btback)
		{
			new SuperUserHomePage();
			BtAddPage.this.dispose();
		}
		
	}
}
