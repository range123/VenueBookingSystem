package venueapp;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;

@SuppressWarnings("serial")
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
		user = u;
		venue = v;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,600);
		setLocation(750,300);
		
		vname = new JLabel(venue.getVname());
		vname.setHorizontalAlignment(JLabel.CENTER);
		imagelabel = new JLabel();
		Image img = Toolkit.getDefaultToolkit().getImage(venue.getPictureURL());
		imagelabel.setIcon(new ImageIcon(img.getScaledInstance(200, 200, Image.SCALE_FAST)));
		vtype = new JLabel(venue.getType());
		vtype.setHorizontalAlignment(JLabel.CENTER);
		vdec = new JLabel(venue.getDescription());
		vdec.setHorizontalAlignment(JLabel.CENTER);
		addr = new JLabel(venue.getLocation());
		addr.setHorizontalAlignment(JLabel.CENTER);
		cap = new JLabel(""+venue.getCapacity());
		cap.setHorizontalAlignment(JLabel.CENTER);
		rooms = new JLabel(""+venue.getRooms());
		rooms.setHorizontalAlignment(JLabel.CENTER);
		cost = new JLabel(""+venue.getCostperhour());
		cost.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		main.add(vname);
		
		JPanel imgtextpanel = new JPanel();
		imgtextpanel.setLayout(new GridLayout());
		imgtextpanel.add(imagelabel);
		JPanel textpanel = new JPanel();
		textpanel.setLayout(new BoxLayout(textpanel,BoxLayout.Y_AXIS));
		textpanel.add(vtype);
		textpanel.add(vdec);
		textpanel.add(addr);
		textpanel.add(cap);
		textpanel.add(rooms);
		textpanel.add(cost);
		imgtextpanel.add(textpanel);
		main.add(imgtextpanel);
		add(main);
		setVisible(true);
		
		
	}

}
