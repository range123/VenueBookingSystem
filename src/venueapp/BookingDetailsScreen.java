package venueapp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class BookingDetailsScreen extends JFrame{
	private JFrame jf = this;
	
	
	private User user;
	private Venue venue;
	private JFormattedTextField people;
	private JTextField from;
	private JTextField to;
	private JCheckBox isfoodreq;
	private JButton confirm;
	
	public BookingDetailsScreen(User u ,Venue v)
	{
		super("Venue Booking System");
		setLocation(750,350);
		setSize(400,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
		user=u;
		venue=v;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		people = new JFormattedTextField(NumberFormat.getIntegerInstance());
		people.setText("Estimated number of people");
		from = new JTextField();
		from.setText("From date DD/MM/YYYY");
		from.setHorizontalAlignment(JFormattedTextField.CENTER);
		to = new JTextField();
		to.setHorizontalAlignment(JFormattedTextField.CENTER);
		to.setText("To date DD/MM/YYYY");
	    isfoodreq = new JCheckBox("Food Required?");
	    confirm = new JButton("Confirm Booking");
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main,BoxLayout.Y_AXIS));
		JPanel temp = new JPanel();
		temp.add(people);
		main.add(temp);
		JPanel datepanel = new JPanel();
		datepanel.setLayout(new FlowLayout());
		datepanel.add(from);
		datepanel.add(to);
		main.add(datepanel);
		//main.add(isfoodreq);
		isfoodreq.setHorizontalAlignment(JCheckBox.CENTER);
		confirm.setHorizontalAlignment(JButton.CENTER);
		//main.add(confirm);
		JPanel fin = new JPanel();
		JPanel fin2 = new JPanel();
		fin.setLayout(new FlowLayout());
		fin2.setLayout(new FlowLayout());
		fin.add(isfoodreq);
		fin2.add(confirm,BorderLayout.PAGE_END);
		main.add(fin);
		main.add(fin2);
		setVisible(true);
		add(main);
		
		
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
				int total_cost;
				Date f = sdf.parse(from.getText().replaceAll("/", "-"));
				Date t = sdf.parse(to.getText().replaceAll("/", "-"));
				Calendar c = Calendar.getInstance();
				c.setTimeInMillis(t.getTime()-f.getTime());
				int no_of_days = c.get(Calendar.DAY_OF_MONTH);
				total_cost = no_of_days * venue.getCostperhour();
				if(isfoodreq.isSelected())
				{
					Random r = new Random();
					total_cost = total_cost + ((r.nextInt(400)+100) * Integer.parseInt(people.getText().replaceAll(",", "")));
				}
				File file = new File("C:\\Users\\Jayaraman\\workspace\\Venue_Booking_System"
						+ "\\src\\venueapp\\files\\Transactions\\"+user.getUname()+".txt");
				Transaction trans = new Transaction(user,venue,from.getText(),to.getText(),no_of_days,total_cost);
				BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
				bw.write(trans.toString());
				bw.newLine();
				bw.flush();
				bw.close();
				JOptionPane.showMessageDialog(jf, "Booking Confirmed, Estimated Cost is Rs"+total_cost);
				setVisible(false);
				new LoggedinScreen(user);
			}catch(ParseException | IOException e)
			{
				JOptionPane.showMessageDialog(jf,"Enter date in proper format");
				
			}
			}
			
		});
	    
		
	}

}
