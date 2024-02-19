package miniproject;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class SuperUserHomePage extends Frame implements ActionListener{

	Button btAdd, btRemove, btEdit,btBack;
	
	public SuperUserHomePage()
	{
		btAdd=new Button("Add");
		btRemove=new Button("Remove");
		btEdit=new Button("Edit");
		btBack=new Button("back");
		
		
		this.setLayout(new FlowLayout(0, 20, 10));
		
		this.setTitle("SuperUserHomePage");
		this.setResizable(false);
		//this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setBounds(800, 300, 300, 300);
		this.setBackground(Color.YELLOW);
		this.setForeground(Color.black);
		btBack.setForeground(Color.red);
		//Panel p1=new Panel(new BorderLayout());
		
		/*p1.add(btAdd , BorderLayout.NORTH);
		p1.add(btRemove , BorderLayout.CENTER);
		p1.add(btEdit , BorderLayout.SOUTH);*/
		
		btAdd.setPreferredSize(new Dimension(50,30));
		btAdd.setFont(new Font("arial", Font.PLAIN,15));
		btRemove.setPreferredSize(new Dimension(80,30));
		btRemove.setFont(new Font("arial", Font.PLAIN,15));
		btEdit.setPreferredSize(new Dimension(50,30));
		btEdit.setFont(new Font("arial", Font.PLAIN,15));
		btBack.setPreferredSize(new Dimension(50,30));
		btBack.setFont(new Font("arial", Font.PLAIN,15));
		
		
		
		this.add(btAdd);
		this.add(btRemove);
		this.add(btEdit);
		this.add(btBack);
		
		MyWindowListener mw=new MyWindowListener(this);
		this.addWindowListener(mw);
		
		btAdd.addActionListener(this);
		btRemove.addActionListener(this);
		btEdit.addActionListener(this);
		btBack.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btAdd)
		{
			new BtAddPage();
			SuperUserHomePage.this.dispose();
		}
		if(e.getSource()==btRemove) {
			new BtRemovePage();
			SuperUserHomePage.this.dispose();
		}
		if(e.getSource()==btEdit) {
			new BtEditPage(null, null, null, null);
			SuperUserHomePage.this.dispose();
		}
		if(e.getSource()==btBack) {
			new LoginPage();
			SuperUserHomePage.this.dispose();
		}
		
		
	}
}
