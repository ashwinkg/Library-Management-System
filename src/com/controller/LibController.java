package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
import com.bean.Book_Reader;
import com.bean.Reader;
import com.service.LibService;

/**
 * Servlet implementation class LibController
 */
public class LibController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LibService service = new LibService();
	RequestDispatcher rd=null; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		if(action.equals("issue"))
		{
			ArrayList<Book> book_list=service.getalldata();
		    ArrayList<Reader> reader_list=service.getallreader();
			request.setAttribute("book", book_list);
			request.setAttribute("reader", reader_list);
			rd=request.getRequestDispatcher("issue.jsp");
		}
		else if(action.equals("allbooks"))
		{
			ArrayList<Book> allbooks=service.getAllBooks();
			ArrayList<Reader> allreader =service.getallreader();
			ArrayList<Book_Reader> book_reader=service.getallbookreader();
			 request.setAttribute("allbooks", allbooks);
			 request.setAttribute("allreader", allreader);
			 request.setAttribute("book_reader", book_reader);
				rd=request.getRequestDispatcher("displayAllBooks.jsp");
		}
		
		
		if(action.contentEquals("register"))
		{
			int book_id =Integer.parseInt(request.getParameter("book_id"));
			int reader_id =Integer.parseInt(request.getParameter("reader_id"));
			service.updatebook(book_id);
			boolean c=service.updateread(book_id,reader_id);
			System.out.println(c);
			String msg="";
			if(c)
			{
				msg="Registration was success";	
			}
			else
			{
				msg="Unable to issue this book";
			}
			request.setAttribute("msg", msg);
			rd=request.getRequestDispatcher("success.jsp");
			
			
		}
		
		
		rd.forward(request, response);
		
	}

}
