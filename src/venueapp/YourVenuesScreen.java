package venueapp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class YourVenuesScreen extends JFrame {
	List<JPanel> venues;

	User user;
	YourVenuesScreen(User u)
	{
		user = u;
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout());
		JLabel name = new JLabel();
		JLabel loc = new JLabel();
		name.setText("Venue Name");
		name.setHorizontalAlignment(JLabel.CENTER);
		loc.setText("Address");
		loc.setHorizontalAlignment(JLabel.CENTER);
		pan.add(name);
		pan.add(loc);
		try{
			venues = new ArrayList<>();
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLocation(750,400);
			setSize(600,300);
			File f = new File("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System"
					+ "\\src\\venueapp\\files\\Venues\\venuelist.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String st;
			while(( st = br.readLine())!=null)
			{
				String s[] = st.split("&");
				if(s[0].equals(user.getUname()))
				{
					JPanel p =new JPanel();
					p.setSize(300,30);

					JLabel lb2 = new JLabel();
					JLabel lb = new JLabel();
					lb.setHorizontalAlignment(JLabel.CENTER);
					lb.setText(s[2]);
					lb2.setText(s[3]);
					lb2.setHorizontalAlignment(JLabel.CENTER);
					p.setLayout(new GridLayout());
					p.add(lb);
					p.add(lb2);
					venues.add(p);
				}
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
					new LoggedInSeller(user);


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
		list.setFixedCellHeight(40);
		list.setSelectedIndex(-1);

		list.setCellRenderer(new PanelRenderer());
		JScrollPane scroll1 = new JScrollPane(list);
		scroll1.setPreferredSize(new Dimension(580,280));
		// final JScrollBar scrollBar = scroll1.getVerticalScrollBar();


		container.add(scroll1);


	}

}

@SuppressWarnings("rawtypes")
class PanelRenderer implements ListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JPanel renderer = (JPanel) value;
		renderer.setBackground(isSelected ? Color.red : list.getBackground());
		return renderer;
	}
}

