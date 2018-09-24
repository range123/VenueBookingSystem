package venueapp;

public class Transaction {
	private User user;
	private Venue venue;
	private String from;
	private String to;
	private int no_of_days;
	private int total_cost;
	
	
	public Transaction(User user, Venue venue, String from, String to,
			int no_of_days, int total_cost) {
		super();
		this.user = user;
		this.venue = venue;
		this.from = from;
		this.to = to;
		this.no_of_days = no_of_days;
		this.total_cost = total_cost;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public int getNo_of_days() {
		return no_of_days;
	}


	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}


	public int getTotal_cost() {
		return total_cost;
	}


	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return venue.toString()+"@"+from+"#"+to+"#"+no_of_days+"#"+total_cost;
	}
	
	
	

}
