package venueapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.io.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class RegisterScreen extends JFrame {
	private JTextField uname;
	private JTextField email;
	private JPasswordField pass;
	private JPasswordField confirmpass;
	private JFormattedTextField phone;
	private JTextArea address;
	private JButton register;
	private JCheckBox isseller;
	private JFrame jf = this;
	public RegisterScreen()
	{
		super("Venue Booking System");
		setLocation(750,400);
		setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel textpanel = new JPanel();
		textpanel.setLayout(new BoxLayout(textpanel,BoxLayout.Y_AXIS));
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
		email = new JTextField(20);
		email.setText("E-mail");
		email.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(email.getText().equals("E-mail"))
					email.setText("");

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
		confirmpass = new JPasswordField(20);
		confirmpass.setText("password");
		confirmpass.addMouseListener(new MouseListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(confirmpass.getText().equals("password"))
					confirmpass.setText("");

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
		phone = new JFormattedTextField(NumberFormat.getInstance());
		phone.setText("Phone");
		phone.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(phone.getText().equals("Phone"))
					phone.setText("");

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
		address = new JTextArea();
		address.setText("Address");
		address.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(address.getText().equals("Address"))
					address.setText("");

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
		isseller = new JCheckBox();
		JLabel jl = new JLabel("Are you a Seller? ");
		JPanel check = new JPanel();
		check.setLayout(new BoxLayout(check,BoxLayout.X_AXIS));
		check.add(jl);
		check.add(isseller);
		jl.setLabelFor(isseller);
		textpanel.add(uname);
		textpanel.add(email);
		textpanel.add(pass);
		textpanel.add(confirmpass);
		textpanel.add(phone);
		textpanel.add(address);
		textpanel.add(check);

		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new BoxLayout(buttonpanel,BoxLayout.X_AXIS));
		register = new JButton("Register");

		register.addActionListener(new ActionListener(){

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					/*TODO check for unique username
					 * 
					 */
					File f =new File("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System\\src\\venueapp\\files\\Users\\"+uname.getText()+".ser");
					if(f.exists())
						JOptionPane.showMessageDialog(jf, "Username already Exists");
					else
					{
						User u = new User(uname.getText(),pass.getText(),email.getText(),phone.getText().replaceAll(",",""),address.getText(),!isseller.isSelected());
						FileOutputStream fo = new FileOutputStream("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System\\src\\venueapp\\files\\Users\\"+uname.getText()+".ser");
						//CustomOutputStream oo = new CustomOutputStream(fo);
						ObjectOutputStream oo = new ObjectOutputStream(fo);
						oo.writeObject(u);
						oo.flush();
						oo.close();
						fo.close();
						setVisible(false);
						new LoginScreen();
						//System.out.println(new File("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System\\src\\venueapp\\files\\login.ser").length());
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}


		});
		buttonpanel.add(register);
		textpanel.add(buttonpanel);
		add(textpanel);
		setVisible(true);
	}

}
