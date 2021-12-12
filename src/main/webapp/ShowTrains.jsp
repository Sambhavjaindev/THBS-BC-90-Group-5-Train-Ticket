<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<html>
<head>
<title>The database table</title>
</head>
<body> 
 <h1>The view of database table</h1>
   
    <%
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetrain","root","Sj_12345");
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("select * from trains");
    %>  
    <Table border='1'>
    <tr>
    <th>Train_No</th>
    <th>Train_Name</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Ticket_Price</th>
    </tr>
    <%while(resultSet.next()){ %>
    <tr>
    <td><%=resultSet.getString(1) %></td>
    <td><%=resultSet.getString(2) %></td>
    <td><%=resultSet.getString(3) %></td>
    <td><%=resultSet.getString(4) %></td>
    <td><%=resultSet.getString(5) %></td>
    </tr>
    <%} %>
    
    </Table>
   		  
		  
    
</body>
</html>
