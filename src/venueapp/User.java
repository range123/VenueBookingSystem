package venueapp;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String uname;
	private String password;
	private String email;
	private String phone;
	private String address;
	private boolean iscustomer=true;
	User(String u,String p,String e,String ph,String addr)
	{
		this.uname=u;
		this.password=p;
		this.email=e;
		this.phone=ph;
		this.setAddress(addr);
	}
	User(String u,String p,String e,String ph,String addr,boolean s)
	{
		this.uname=u;
		this.password=p;
		this.email=e;
		this.phone=ph;
		this.setAddress(addr);
		this.iscustomer=s;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		
		return uname+" : "+password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public boolean isIscustomer() {
		return iscustomer;
	}
	public void setIscustomer(boolean iscustomer) {
		this.iscustomer = iscustomer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
