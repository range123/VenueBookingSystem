package venueapp;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginScreen extends JFrame {
	private JTextField uname;
	private JPasswordField pass;
	private JFrame jf = this;
	
	public LoginScreen()
	{
		super("Venue Booking System");
		setSize(500,160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(750,300);
		JPanel unamepass = new JPanel();
		this.add(unamepass);
		unamepass.setLayout(new BoxLayout(unamepass,BoxLayout.Y_AXIS));
		uname = new JTextField(20);
		pass = new JPasswordField(20);
		unamepass.add(uname);
		unamepass.add(pass);
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout());
		unamepass.add(buttonpanel);
		JButton login = new JButton("Login");
		
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(jf, "Invalid username or password");
				
			}
			
		});
		
		JButton register = new JButton("Register");
		
		register.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				jf.setVisible(false);
				new RegisterScreen();
				
			}
			
		});
		buttonpanel.add(login);
		buttonpanel.add(register);
		setVisible(true);
		
	}

}
