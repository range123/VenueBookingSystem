package venueapp;

public class Venue {
	private String sname;
	private String sphn;
	private String vname;
	private String location;
	private String pictureURL;
	private int costperhour;
	public Venue(String sname, String sphn, String vname, String location,String pictureURL, int costperhour) {
		super();
		this.sname = sname;
		this.sphn = sphn;
		this.vname = vname;
		this.location = location;
		this.pictureURL = pictureURL;
		this.costperhour = costperhour;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphn() {
		return sphn;
	}
	public void setSphn(String sphn) {
		this.sphn = sphn;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public int getCostperhour() {
		return costperhour;
	}
	public void setCostperhour(int costperhour) {
		this.costperhour = costperhour;
	}
	@Override
	public String toString() {
		return sname+"&"+sphn+"&"+vname+"&"+location+"&"+pictureURL+"&"+costperhour;
	}

	
	

}
