package venueapp;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class PreviousBookingScreen extends JFrame {
	private User user;
	List<JPanel> venues;
	ArrayList<Venue> vlist;
	@SuppressWarnings("resource")
	PreviousBookingScreen(User u)
	{
		super("Venue Booking System");
		venues = new ArrayList<>();
		vlist = new ArrayList<>();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		user = u;
		
		setLocation(750,400);
		setSize(450,350);

		try{
			File file = new File("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System"
					+ "\\src\\venueapp\\files\\Transactions\\"+user.getUname()+".txt");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while((st = br.readLine()) != null)
			{
				String s[] = st.split("@");
				String v[] = s[0].split("&");
				String det[] = s[1].split("#");
				vlist.add(new Venue(v[0],v[1],v[2],v[3],v[4],v[5],Integer.parseInt(v[6]),v[7],Integer.parseInt(v[8]),Integer.parseInt(v[9])));
				JPanel p =new JPanel();
				p.setSize(280,100);

				JLabel vnamelabel = new JLabel(v[2].toUpperCase());
				vnamelabel.setFont(new Font("",Font.BOLD,14));
				JLabel vtypelabel = new JLabel(v[3]);
				JPanel vnamepanel = new JPanel();
				JPanel vtypepanel = new JPanel();
				vnamepanel.add(vnamelabel);
				vtypepanel.add(vtypelabel);
				JLabel vfrom = new JLabel(det[0]);
				vfrom.setHorizontalAlignment(JLabel.CENTER);
				JLabel cto = new JLabel(det[1]);
				cto.setHorizontalAlignment(JLabel.CENTER);
				JLabel cost = new JLabel("Cost Rs"+det[3]);
				cost.setHorizontalAlignment(JLabel.CENTER);
				JPanel datepanel = new JPanel();
				datepanel.setLayout(new FlowLayout());
				datepanel.add(vfrom);
				datepanel.add(cto);
				vnamelabel.setHorizontalAlignment(JLabel.CENTER);
				vtypelabel.setHorizontalAlignment(JLabel.CENTER);
				p.setLayout(new GridLayout());
				JPanel p1 = new JPanel();
				p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
				p1.add(vnamepanel);
				p1.add(vtypepanel);
				p1.add(datepanel);
				JPanel costl = new JPanel();
				costl.add(cost);
				p1.add(costl);
				Image img = Toolkit.getDefaultToolkit().getImage(v[5]);
				JLabel imglabel = new JLabel();
				imglabel.setIcon(new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_FAST)));
				imglabel.setHorizontalAlignment(JLabel.CENTER);
				p.add(imglabel);
				p.add(p1);
				venues.add(p);
				
				
			}
			JPanel last =new JPanel();
			ShowItemList(venues,last);
			add(last);
			JButton back = new JButton("Go Back");
			back.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
					new LoggedinScreen(user);


				}

			});
			add(back,BorderLayout.PAGE_END);
			setVisible(true);
		}
		catch(IOException e)
		{
			
		}
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void ShowItemList(List<JPanel> paneList, JPanel container) {


		DefaultListModel model = new DefaultListModel();

		for (JPanel pane:paneList) {

			model.addElement(pane);

		}
		final JList list = new JList(model);
		list.setSize(600, 300);
		list.setFixedCellHeight(100);
		list.setSelectedIndex(-1);



		list.setCellRenderer(new PanelRenderer());
		JScrollPane scroll1 = new JScrollPane(list);
		scroll1.setPreferredSize(new Dimension(420,300));


		container.add(scroll1);


	}

}
