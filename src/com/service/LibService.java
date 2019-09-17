package com.service;

import java.util.ArrayList;

import com.bean.Book;
import com.bean.Book_Reader;
import com.bean.Reader;
import com.dao.LibDAO;

public class LibService {
	
	
	LibDAO dao = new LibDAO();
	public ArrayList<Book> getalldata()
	{
		return dao.getalldata();
	}
	public ArrayList<Book> getAllBooks()
	{
		return dao.getAllBooks();
	}
  
	
	public ArrayList<Reader> getallreader()
	{
		return dao.getallreader();
	}
	public void updatebook(int book_id)
	{
		dao.updatebook(book_id);
	}
	
	public boolean updateread(int book_id, int reader_id)
	{
		return dao.updateread(book_id,reader_id);
	}
	
	public ArrayList<Book_Reader> getallbookreader()
	{
		return dao.getallbookreader();
	}
	
	
}
