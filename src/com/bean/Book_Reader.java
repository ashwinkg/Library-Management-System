package com.bean;

public class Book_Reader {
    private int book_id;
    private int reader_id;
	public Book_Reader(int book_id, int reader_id) {
		this.book_id = book_id;
		this.reader_id = reader_id;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public int getReader_id() {
		return reader_id;
	}
	public void setReader_id(int reader_id) {
		this.reader_id = reader_id;
	}
	
}
