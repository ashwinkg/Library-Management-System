package com.bean;

public class Book {
	private int bookid;
	private String title;
	private String author;
	private long cost;
	private int availability;
	public Book(int bookid, String title, String author, long cost, int availability) {
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.cost = cost;
		this.availability = availability;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	
	
	

}
