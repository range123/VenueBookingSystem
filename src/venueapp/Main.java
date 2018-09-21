package venueapp;



import javax.swing.*;


public class Main {
	Main() throws InterruptedException
	{
		new SplashScreen();
	}



	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				try {
					new Main();
				} catch (Exception e) {
					//Interrupted
					e.printStackTrace();
				}
				
			}
			
		});
		
	}

}
