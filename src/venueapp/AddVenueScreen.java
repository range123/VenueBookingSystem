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
	private JTextField type;
	private JTextField addr;
	private JTextField photo;
	private JFormattedTextField cost;
	private JTextField desc;
	private JFormattedTextField capacity;
	private JFormattedTextField rooms;
	
	private JButton add;
	private JButton cancel;

	AddVenueScreen(User u)
	{
		user = u;
		setLocation(750,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		vname = new JTextField(20);
		vname.setText("Venue Name");
		type = new JTextField(20);
		type.setText("Type");
		addr = new JTextField(20);
		addr.setText("Venue Address");
		photo = new JTextField(20);
		photo.setText("Photo Url");
		cost = new JFormattedTextField(NumberFormat.getNumberInstance());
		cost.setText("Cost per Hour");
		desc = new JTextField(20);
		desc.setText("Description");
		capacity = new JFormattedTextField(NumberFormat.getIntegerInstance());
		capacity.setText("Capacity");
		rooms = new JFormattedTextField(NumberFormat.getIntegerInstance());
		rooms.setText("No. of Rooms");
		add = new JButton("Add Venue");
		cancel = new JButton("Cancel");
		JPanel p =new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		add.setHorizontalAlignment(JButton.CENTER);
		cancel.setHorizontalAlignment(JButton.CENTER);
		p1.add(add);
		p1.add(cancel);



		cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new LoggedInSeller(user);
				
			}
			
		});
		
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Venue v = new Venue(user.getUname(),user.getPhone(),vname.getText(),type.getText(),addr.getText()
							,photo.getText(),Integer.parseInt(cost.getText().replaceAll(",","")),desc.getText(),
							Integer.parseInt(capacity.getText().replaceAll(",", "")),Integer.parseInt(rooms.getText().replaceAll(",", "")));
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
		p.add(type);
		p.add(desc);
		p.add(addr);
		p.add(photo);
		p.add(capacity);
		p.add(rooms);
		p.add(cost);
		p.add(p1);
		//p.add(add);
		add(p);
		//pack();
		setVisible(true);

	}

}
