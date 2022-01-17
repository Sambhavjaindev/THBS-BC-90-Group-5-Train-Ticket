<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import= "com.torryharris.model.Ticket1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Generator</title>
</head>
<body>
<link rel="stylesheet" href="TicketPrint.css">

<h1>Your Train Ticket Information</h1>

<%Ticket1 ticket = (Ticket1)request.getAttribute("ticket");%>
<% StringBuilder ticketOutput = ticket.generateTicket();%>
<pre id="ticket"><%= ticketOutput.toString() %></pre>
<form action="Payment.html" method="post">
<div align="center">
              <input type="submit"  value="Payment"  class = "button-21"></div>
              </form>
              



</body>
</html>