package com.bean;

public class Reader {
	private int readerid;
	private String readername;
	private long contact;
	private String email;
	
	
	
	
	public Reader(int readerid, String readername, long contact, String email) {
		this.readerid = readerid;
		this.readername = readername;
		this.contact = contact;
		this.email = email;
	}
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
