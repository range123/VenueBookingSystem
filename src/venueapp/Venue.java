package venueapp;

public class Venue {
	private String sname;
	private String sphn;
	private String vname;
	private String type;
	private String location;
	private String pictureURL;
	private int costperhour;
	private String description;
	private int capacity;
	private int rooms;

	public Venue(String sname, String sphn, String vname, String type,
			String location, String pictureURL, int costperhour,
			String description, int capacity, int rooms) {
		super();
		this.sname = sname;
		this.sphn = sphn;
		this.vname = vname;
		this.type = type;
		this.location = location;
		this.pictureURL = pictureURL;
		this.costperhour = costperhour;
		this.description = description;
		this.capacity = capacity;
		this.rooms = rooms;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return sname+"&"+sphn+"&"+vname+"&"+type+"&"+location+"&"+pictureURL+"&"+costperhour+"&"+description+"&"+capacity+"&"+rooms;
	}

	
	

}
