<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<html>
<title>The database table</title>
    <head>
         <style type="text/css">
        
   .navbar{
   margin: -20px;
    height: 60px;
    width: 100%;
    background: rgba(0,0,0,0.4);
}
.logo{
    width: 50px;
    height: auto;
    padding: 10px 10px;
}
.navbar ul{
    float: left;
    margin-right: 20px;
}
.navbar ul li{
    list-style: none;
    margin: 0 8px;
    display: inline-block;
    line-height: 60px;
}
.navbar ul li a{
    text-decoration: none;
    color: white;
    font-size: 20px;
    padding: 6px 13px;
    font-family: 'Roboto' , sans-serif;
    transition: .4s;
}
.navbar ul li a.active,
.navbar ul li a:hover{
    background: red;
    border-radius: 2px;
}
      </style>
   </head>
   <body>
      <div class="navbar">
      <ul>
                <li><a class="active" href="index.jsp">Home</a></li>
      </ul>
   </div>
    


<center> <h3>${messaged1}</h3> 
         <h3>${messaged2}</h3>   
         <h3>${messaged3}</h3>
        <h3>${messaget1}</h3> </center>
<body style="background-color:powderblue;">
<link rel="stylesheet" href="ShowTrainNewUser.css">
  <h1 align="center">Details Of Trains Available </h1>
   
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
    <th>Seats</th>
    </tr>
    <%while(resultSet.next()){ %>
    <tr>
    <td><%=resultSet.getString(1) %></td>
    <td><%=resultSet.getString(2) %></td>
    <td><%=resultSet.getString(3) %></td>
    <td><%=resultSet.getString(4) %></td>
    <td><%=resultSet.getString(5) %></td>
    <td><%=resultSet.getString(6) %></td>
    </tr>
    <%} %>
    
    </Table>
<br/>
    <form action="checktrains" class="tab red" method="post">
		Enter the Train Number &nbsp;<input type="number" name="trainno" required><br/><br/>
        
		  Enter the Date &nbsp; &nbsp; &nbsp;<input type="date" name="date" required ><br/><br/>

		<input type="submit" value=" Continue " ><br/>
	</form><br/>
    

		  
    
</body>
</html>
