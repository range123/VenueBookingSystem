package venueapp;

import java.awt.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginScreen extends JFrame {
	private JTextField uname;
	private JPasswordField pass;
	private JFrame jf = this;
	ArrayList<User> u = new ArrayList<>(); 

	public LoginScreen()
	{
		super("Venue Booking System");
		setSize(500,160);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(750,350);
		JPanel unamepass = new JPanel();
		this.add(unamepass);
		unamepass.setLayout(new BoxLayout(unamepass,BoxLayout.Y_AXIS));
		uname = new JTextField(20);
		uname.setText("Username");
		uname.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(uname.getText().equals("Username"))
					uname.setText("");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		pass = new JPasswordField(20);
		pass.setText("password");
		pass.addMouseListener(new MouseListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(pass.getText().equals("password"))
					pass.setText("");

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}



		});
		unamepass.add(uname);
		unamepass.add(pass);
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout());
		unamepass.add(buttonpanel);
		JButton login = new JButton("Login");

		login.addActionListener(new ActionListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(jf, "Invalid username or password");
				//CustomInputStream oi=null;
				ObjectInputStream oi=null;
				int y=1;
				try {
					FileInputStream fi = new FileInputStream("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System\\src\\venueapp\\files\\Users\\"+uname.getText()+".ser");
					oi = new ObjectInputStream(fi);
					//oi = new CustomInputStream(fi);
					User obj = null;

					Object o;
					while((o = oi.readObject())!=null)
					{
						obj = (User)o;
						if(obj.getUname().equals(uname.getText()) && obj.getPassword().equals(pass.getText())){
							y=0;
							JOptionPane.showMessageDialog(jf, "Logged In");
							if(obj.isIscustomer())
								new LoggedinScreen(obj);
							else
								new LoggedInSeller(obj);
							setVisible(false);
						}
					}
					if(y==1)
						JOptionPane.showMessageDialog(jf, "Invalid username or password");
				}
				catch (EOFException e) {
					if(y==1)
						JOptionPane.showMessageDialog(jf, "Invalid username or password");
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				catch(ClassNotFoundException e)
				{
					JOptionPane.showMessageDialog(jf, "Class not found");
				}
				catch(FileNotFoundException e)
				{
					JOptionPane.showMessageDialog(jf, "Invalid username or password");
				}
				catch(IOException e)
				{
					JOptionPane.showMessageDialog(jf, "IO");
					e.printStackTrace();
				}

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
