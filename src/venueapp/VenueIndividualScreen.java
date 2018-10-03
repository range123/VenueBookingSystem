package venueapp;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings({"serial","unused"})
public class VenueIndividualScreen extends JFrame{
	private User user;
	private Venue venue;
	private JLabel imagelabel;
	private JLabel vname;
	private JLabel vtype;
	private JLabel vdec;
	private JLabel addr;
	private JLabel cap;
	private JLabel rooms;
	private JLabel cost;
	
	private JLabel sname;
	private JLabel sphone;
	
	private JButton back;
	private JButton book;
	
	
	VenueIndividualScreen(User u, Venue v)
	{
		super("Venue Booking System");
		user = u;
		venue = v;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,600);
		setLocation(750,200);
		
		vname = new JLabel(venue.getVname().toUpperCase());
		vname.setFont(new Font("Venue Name : "+venue.getVname(),Font.ROMAN_BASELINE,32));
		vname.setHorizontalAlignment(JLabel.CENTER);
		imagelabel = new JLabel();
		Image img = Toolkit.getDefaultToolkit().getImage(venue.getPictureURL());
		imagelabel.setIcon(new ImageIcon(img.getScaledInstance(300, 300, Image.SCALE_FAST)));
		vtype = new JLabel("VENUE TYPE : "+venue.getType());
		vtype.setFont(new Font("VENUE TYPE : "+venue.getType(),Font.PLAIN,18));
		
		vtype.setHorizontalAlignment(JLabel.CENTER);
		vdec = new JLabel("DESC : "+venue.getDescription());
		vtype.setFont(new Font("DESC : "+venue.getDescription(),Font.PLAIN,18));
		vdec.setHorizontalAlignment(JLabel.CENTER);
		addr = new JLabel("ADDRESS : "+venue.getLocation());
		addr.setFont(new Font("",Font.PLAIN,18));
		addr.setHorizontalAlignment(JLabel.CENTER);
		cap = new JLabel("CAPACITY : "+venue.getCapacity());
		cap.setFont(new Font("",Font.PLAIN,18));
		cap.setHorizontalAlignment(JLabel.CENTER);
		rooms = new JLabel("ROOMS : "+venue.getRooms());
		rooms.setFont(new Font("ROOMS : ",Font.PLAIN,18));
		rooms.setHorizontalAlignment(JLabel.CENTER);
		cost = new JLabel("COST PER DAY : Rs"+venue.getCostperhour());
		cost.setFont(new Font("COST PER DAY",Font.PLAIN,18));
		cost.setHorizontalAlignment(JLabel.CENTER);
		book = new JButton("Book Now");
		book.setHorizontalAlignment(JButton.CENTER);
		back = new JButton("Close");
		back.setHorizontalAlignment(JButton.CENTER);
		JPanel butpanel = new JPanel();
		butpanel.setLayout(new FlowLayout());
		butpanel.add(book);
		butpanel.add(back);
		
		
		book.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				new BookingDetailsScreen(user,venue);
				
			}
			
		});
		back.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
			
		});
		
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		//imagelabel.setHorizontalAlignment(JLabel.CENTER);
		main.add(vname,BorderLayout.NORTH);
		main.add(imagelabel);
		
		main.add(vtype);
		main.add(vdec);
		main.add(addr);
		main.add(cap);
		main.add(rooms);
		main.add(cost);
		main.add(butpanel,BorderLayout.PAGE_END);
		add(main);
		setVisible(true);
		
		
	}

}
