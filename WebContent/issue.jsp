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
<title>Issue Book</title>
</head>
<body>
      <h2>Library Management Book</h2>
       <h3>Issue Book</h3> 
       
       
       
    
   <% ArrayList<Book> book_list = (ArrayList<Book>)request.getAttribute("book");%> 
   <% ArrayList<Reader> reader_list = (ArrayList<Reader>)request.getAttribute("reader");%> 
  
     
  
  
 
 <form action="lc"> 
   <table>
       <tr><td>Select Books</td><td><select name="book_id">
       <% for (Book book:book_list){%>
       <option value="<%=book.getBookid() %>"><%=book.getTitle() %></option>
       <%} %>
       </select></td></tr>
   
      <tr><td>Select Reader</td><td><select name="reader_id">
      <% for (Reader read:reader_list){%>
       <option value="<%=read.getReaderid() %>"><%=read.getReadername() %></option>
       <%} %>
       </select></td></tr>
   
   <tr>
     <td colspan="2">
         <input type="hidden" name="action" value="register"/>
         <input type="submit" value="Submit"></td>
         </tr>
   
   
   
   
   </table>  
  </form> 
   
</body>
</html>