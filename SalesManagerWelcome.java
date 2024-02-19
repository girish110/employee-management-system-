package miniproject;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class SalesManagerWelcome extends Frame {

	Label lbwelcome;
	TextArea txtarea;
	
	public SalesManagerWelcome()
	{
		lbwelcome=new Label("WELCOME");
		
		this.setTitle("Welcome");
		this.setBounds(200, 200, 250, 200);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setResizable(false);
		this.setBackground(Color.getHSBColor(HEIGHT, ALLBITS, ABORT));
		//lbwelcome.setAlignment((int) CENTER_ALIGNMENT);
		
		this.add(lbwelcome);
		
		 MyWindowListener mw=new MyWindowListener(this);
		 this.addWindowListener(mw);
	}
}
