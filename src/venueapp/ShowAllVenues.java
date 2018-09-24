package venueapp;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ShowAllVenues extends JFrame{
	private User user;
	List<JPanel> venues;
	ArrayList<Venue> v;
	JFrame jf = this;
	public ShowAllVenues(User u)
	{
		super("Venue Booking System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		user=u;
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout());
		JLabel name = new JLabel();
		JLabel loc = new JLabel();
		name.setText("Venue Name");
		name.setHorizontalAlignment(JLabel.CENTER);
		loc.setText("Address");
		loc.setHorizontalAlignment(JLabel.CENTER);
		//pan.add(name);
		//pan.add(loc);
		try{
			venues = new ArrayList<>();
			v = new ArrayList<>();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocation(750,400);
			setSize(340,350);

			File f = new File("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System"
					+ "\\src\\venueapp\\files\\Venues\\venuelist.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(f));
			String st;
			while(( st = br.readLine())!=null)
			{
				String s[] = st.split("&");
				v.add(new Venue(s[0],s[1],s[2],s[3],s[4],s[5],Integer.parseInt(s[6]),s[7],Integer.parseInt(s[8]),Integer.parseInt(s[9])));
				
				JPanel p =new JPanel();
				p.setSize(280,100);

				JLabel vnamelabel = new JLabel(s[2]);
				JLabel vtypelabel = new JLabel(s[3]);
				vnamelabel.setHorizontalAlignment(JLabel.CENTER);
				vtypelabel.setHorizontalAlignment(JLabel.CENTER);
				p.setLayout(new GridLayout());
				JPanel p1 = new JPanel();
				p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
				p1.add(vnamelabel);
				p1.add(vtypelabel);
				Image img = Toolkit.getDefaultToolkit().getImage(s[5]);
				JLabel imglabel = new JLabel();
				imglabel.setIcon(new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_FAST)));
				imglabel.setHorizontalAlignment(JLabel.RIGHT);
				p.add(imglabel);
				p.add(p1);
				venues.add(p);

			}
			JPanel last =new JPanel();
			ShowItemList(venues,last);
			add(pan,BorderLayout.NORTH);
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
		}catch(IOException e)
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
		list.setFixedCellHeight(60);
		list.setSelectedIndex(-1);

		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex()!=-1){
					new VenueIndividualScreen(user,v.get(list.getSelectedIndex()));

					
			}
			}

		});

		list.setCellRenderer(new PanelRenderer());
		JScrollPane scroll1 = new JScrollPane(list);
		scroll1.setPreferredSize(new Dimension(325,300));
		// final JScrollBar scrollBar = scroll1.getVerticalScrollBar();


		container.add(scroll1);


	}

}


