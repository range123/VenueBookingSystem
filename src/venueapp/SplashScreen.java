package venueapp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class SplashScreen extends JWindow {
	
	  static JProgressBar progressBar = new JProgressBar();
	  static int count = 1, TIMER_PAUSE = 25, PROGBAR_MAX = 100;
	  static Timer progressBarTimer;
	  ActionListener al = new ActionListener() {
	    @Override
	    public void actionPerformed(java.awt.event.ActionEvent evt) {
	      progressBar.setValue(count);
	      if (PROGBAR_MAX == count) {
	        progressBarTimer.stop();
	        SplashScreen.this.setVisible(false);
	        new LoginScreen();
	      }
	      count++;
	    }
	  };
	  public int getcount()
	  {
		  return count;
	  }

	  public SplashScreen() {
	    Container container = getContentPane();
	    setLocation(750,400);
	    JPanel panel = new JPanel();
	    panel.setBorder(new EtchedBorder());
	    container.add(panel, BorderLayout.CENTER);

	    JLabel label = new JLabel();
	    label.setIcon(new ImageIcon("C:/Users/Jayaraman/workspace/Venue_Booking_System/src/venueapp/SplashScreenImage.png"));
	    panel.add(label);

	    progressBar.setMaximum(PROGBAR_MAX);
	    container.add(progressBar, BorderLayout.SOUTH);
	    pack();
	    setVisible(true);
	    startProgressBar();
	  }
	  private void startProgressBar() {
	    progressBarTimer = new Timer(TIMER_PAUSE, al);
	    progressBarTimer.start();
	  }

	}
