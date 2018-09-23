package venueapp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.NumberFormat;

import javax.swing.*;


@SuppressWarnings("serial")
public class AddVenueScreen extends JFrame {
	private User user;
	private JFrame jf = this;
	private JTextField vname;
	private JTextField addr;
	private JTextField photo;
	private JFormattedTextField cost;
	private JButton add;

	AddVenueScreen(User u)
	{
		user = u;
		setLocation(750,400);
		setSize(350,200);
		vname = new JTextField(20);
		vname.setText("Venue Name");
		addr = new JTextField(20);
		addr.setText("Venue Address");
		photo = new JTextField(20);
		photo.setText("Photo Url");
		cost = new JFormattedTextField(NumberFormat.getNumberInstance());
		cost.setText("Cost per Hour");
		add = new JButton("Add Venue");
		JPanel p =new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		add.setHorizontalAlignment(JButton.CENTER);
		p1.add(add);



		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Venue v = new Venue(user.getUname(),user.getPhone(),vname.getText(),addr.getText()
							,photo.getText(),Integer.parseInt(cost.getText().replaceAll(",","")));
					File f = new File("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System"
							+ "\\src\\venueapp\\files\\Venues\\venuelist.txt");
					BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
					PrintWriter p = new PrintWriter(bw);
					p.println(v.toString());
					JOptionPane.showMessageDialog(jf, "Venue Added");
					setVisible(false);
					p.close();
					new LoggedInSeller(user);

				}catch(IOException e)
				{

				}
			}

		});


		p.add(vname);
		p.add(addr);
		p.add(photo);
		p.add(cost);
		p.add(p1);
		//p.add(add);
		add(p);
		//pack();
		setVisible(true);

	}

}
