package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.Book;
import com.bean.Book_Reader;
import com.bean.Reader;
import com.util.DBUtil;

public class LibDAO {
	
	public ArrayList<Book> getalldata()
	{
		ArrayList<Book> book_list = new ArrayList<Book>();
		Connection con= DBUtil.getConnection();
		
		String sql= "select * from book_tbl where availability=1";
		try
		{ 
		   PreparedStatement pst = con.prepareStatement(sql);
		   ResultSet rs= pst.executeQuery();
			
			while(rs.next())
			{
				Book b= new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getInt(5));
				book_list.add(b);
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection();
		}
		return book_list;
	}
	
	
	
	public ArrayList<Book> getAllBooks()
	{
		Connection con=DBUtil.getConnection();
		String sql="select bookid,title,author,cost,availability from book_tbl";
		ArrayList<Book> arr = new ArrayList<Book>();
		try {
			     Statement stmt = con.createStatement();
			     ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				Book u = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getInt(5));
			     arr.add(u);	 
			}	
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			DBUtil.closeConnection();
		}
		return arr;
			
	}
	
	
   public ArrayList<Reader> getallreader()
   {
	   Connection con=DBUtil.getConnection();
	   String sql="select * from reader_tbl";
	   ArrayList<Reader> arr = new ArrayList<Reader>();
	   try {
		     Statement stmt = con.createStatement();
		     ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			Reader u = new Reader(rs.getInt(1),rs.getString(2),rs.getLong(3),rs.getString(4));
		     arr.add(u);	 
		}	
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally {
		DBUtil.closeConnection();
	}
	return arr;
	   
	   
   }
	
   public void updatebook(int book_id)
   {
	   Connection con=DBUtil.getConnection();
	   String sql="update book_tbl set availability=0 where bookid=?";
	   try {
		   PreparedStatement pst = con.prepareStatement(sql);
		   pst.setInt(1, book_id);
		   int count=pst.executeUpdate();
	     }
        catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally {
		DBUtil.closeConnection();
	}
	   
	   
   }
   
   public boolean updateread(int book_id,int reader_id)
   {
	   Connection con=DBUtil.getConnection(); 
	   String sql="insert into reader_book_tbl values(?,?)";
	   boolean status=false;
	   try {
		   PreparedStatement pst = con.prepareStatement(sql);
		   pst.setInt(1, book_id);
		   pst.setInt(2,reader_id);
		   int count=pst.executeUpdate();
		   if(count>0)
			   status=true;
		   else
			   status=false;
	     }
        catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally {
		DBUtil.closeConnection();
	}
	   
	   
	   return status;
	   
   }
	
	
   public ArrayList<Book_Reader> getallbookreader()
   {
	   Connection con=DBUtil.getConnection();
	   String sql="select * from reader_book_tbl";
	   ArrayList<Book_Reader> arr = new ArrayList<Book_Reader>();
	   try {
		     Statement stmt = con.createStatement();
		     ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next())
		{
			Book_Reader u = new Book_Reader(rs.getInt(1),rs.getInt(2));
		     arr.add(u);	 
		}	
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally {
		DBUtil.closeConnection();
	}
	return arr;
	   
	   
	   
   }
   
   
   
}
