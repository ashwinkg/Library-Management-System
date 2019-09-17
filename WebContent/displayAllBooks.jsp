<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import ="java.util.ArrayList" %>
<%@page import ="com.bean.Book" %>  
<%@page import ="com.bean.Reader" %>  
<%@page import ="com.bean.Book_Reader" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display all Books</title>
</head>
<body>
     <%ArrayList<Book> userNames= (ArrayList<Book>)request.getAttribute("allbooks");
      ArrayList<Reader> reader_list = (ArrayList<Reader>)request.getAttribute("allreader");
       ArrayList<Book_Reader> book_reader_list = (ArrayList<Book_Reader>)request.getAttribute("book_reader"); 
     
     if(userNames !=null && userNames.size()>0){
        	  %>
        	  
        	  <table border="1">
        	  <th>BOOK ID</th>
        	  <th>TITLE</th>
        	  <th>AUTHOR</th>
        	  <th>COST</th>
        	  <th>AVAILABILITY</th>
        	  <th>ISSUED TO</th>
        	  <th>CONTACT #</th>
        	  <th>ACTION</th>
        	  
        	  <% for (Book book:userNames){
        		  String readername="";
        		  String contact="";
        		  int readerid=0;
        		  String status_avail="Yes";
        		   if(book.getAvailability()==0)
        		   {
        			    status_avail="No";
        			   for(Book_Reader brl:book_reader_list)
        			   {
        				   if(brl.getBook_id()==book.getBookid())
        				   {
        			             readerid=brl.getReader_id(); 
        				          break;
        				   }
        			    }
        			   
        			   for(Reader r:reader_list)
        			   {
        				   if(readerid==0){
        					   readername="";
        					   break;
        				   }
        				   else if(r.getReaderid()==readerid){
        					   readername=r.getReadername();
        					   contact=Long.toString(r.getContact());
        					   break;
        				   }  
        			   }
        			   
        				  
        			   }
        		  
        		  
        		 
        			  
        			  
        		  
        		  %>
        	        <tr>
        	            <td><%=book.getBookid() %></td>
        	            <td><%=book.getTitle() %></td>
        	            <td><%=book.getAuthor() %></td>
        	            <td><%=book.getCost() %></td>
        	            <td><%=status_avail %></td>
        	            <td><%=readername %></td>
        	            <td><%=contact %></td>
        	            <%if(book.getAvailability()==0){%>
        	            <td><button>Return</button></td>
        	            <%}else{%>
        	            <td><button>Issue</button></td>
        	              <%} %>  
        	          </tr><%} %>
        	  
        	  
        	  </table>
        	  
        	  
         <%  } else{
        	 %>
        	 
        	 <h2 style =""color:red;>No Book Exists</h2>
        	 
         <% }
          
          
          %>
     
     
     
     
     
</body>
</html>