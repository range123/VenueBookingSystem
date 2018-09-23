package venueapp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoggedInSeller extends JFrame{
	private User user;
	private JFrame jf = this;
	LoggedInSeller(User u)
	{
		setSize(400,450);
		user = u;
		setLocation(750,330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		Container main = this.getContentPane();
		JLabel wel = new JLabel();
		JButton viewprev = new JButton("Your Venues");
		//viewprev.setHorizontalAlignment(JButton.EAST);
		JButton book = new JButton("Add Venue");
		//book.setHorizontalAlignment(JButton.CENTER);
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(jf, "Logged Out");
				setVisible(false);
				new LoginScreen();

			}

		});
		viewprev.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new YourVenuesScreen(user);
				
			}
			
		});
		
		book.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new AddVenueScreen(user);
				
			}
			
		});

		//logout.setHorizontalAlignment(JButton.EAST);
		wel.setText("Welcome, "+user.getUname());
		wel.setHorizontalAlignment(JLabel.CENTER);
		wel.setFont(new Font("Welcome, "+user.getUname(),Font.ITALIC,25));

		JLabel img = new JLabel();
		Image i = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System\\src\\venueapp\\images\\download.jpg");
		img.setIcon(new ImageIcon(i.getScaledInstance(400, 300, Image.SCALE_FAST)));
		JPanel p =new JPanel();
		p.add(Box.createVerticalGlue());
		p.add(viewprev);
		p.add(Box.createVerticalGlue());
		p.add(book);
		p.add(Box.createVerticalGlue());
		p.add(logout);
		p.add(Box.createVerticalGlue());
		//p.setAlignmentY(this.getMinimumSize().height/3);
		main.add(wel,BorderLayout.NORTH);
		main.add(img);
		//main.add(viewprev,BorderLayout.PAGE_END);
		//main.add(book,BorderLayout.PAGE_END);
		main.add(p,BorderLayout.SOUTH);
		//pack();
		setVisible(true);


	}

}

