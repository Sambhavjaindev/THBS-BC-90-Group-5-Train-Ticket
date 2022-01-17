<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
    
<title>Train Ticket Booking</title>
<style type="text/css">
	.navbar{
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
    line-height: 35px;
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
                <li><a class="active" href="ShowTrainNewUser">Back</a></li>
      </ul>
   </div>
<h1 align="center">Welcome to Train Ticket Booking</h1>
<br>
<link rel="stylesheet" href="NewBookingpage.css">

<script src="Validations.js"> </script>
<form action="booktrains" method="post">

		

<h3 align="center"> SELECT THE NO OF PASSENGERS : &nbsp                           

<select id="passenger_count" name="passenger_count" oninput="displayPassengerDetails()" required>
	<option> </option>
	<option>1</option>
	<option>2</option>
	<option>3</option>
	<option>4</option>
	<option>5</option>
	<option>6</option>	
</select>
</h3>
<br>
<center> <h3 id="label1"></h3></center>
<br>

<center><table id="passenger_table" border=0></table>
<script>

function deleteAllRows(table){
	var parent=table;
	while(parent.hasChildNodes()){
		parent.removeChild(parent.firstChild);
	}
}
function displayPassengerDetails(){
	let passenger_count = document.getElementById("passenger_count").value;
	document.getElementById("label1").innerHTML = "Passenger Details";

	var table = document.getElementById("passenger_table");		
	deleteAllRows(table);
	for(let i=0;i<passenger_count;i++){
		var row = table.insertRow(i);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		
		cell1.innerHTML=(i+1)+".";
		cell2.innerHTML="Passenger Name";
		
		var passengerName=document.createElement("input");
		passengerName.type="text";
		passengerName.id="name_"+(i+1);
		passengerName.name="name_"+(i+1);
		cell3.appendChild(passengerName);
		
		cell4.innerHTML="Age";
		var age=document.createElement("input");
		age.type="number";
		age.id="age_"+(i+1);
		age.name="age_"+(i+1);
		cell5.appendChild(age);
		cell6.innerHTML="Gender";
		
		var gender1 = document.createElement("input");
		
		gender1.type="radio";
		gender1.value="Male";
		
		gender1.name="gender_"+(i+1);
		gender1.id="gender_"+(i+1);
		gender1.name="gender_"+(i+1);
		cell7.appendChild(gender1);
		
		var male_label1 = document.createElement("label");
		male_label1.innerHTML="Male";		
		cell7.appendChild(male_label1);
		
		var gender2 = document.createElement("input");
		gender2.type="radio";
	
		gender2.value="Female"
		gender2.id="gender_"+(i+1);
		gender2.name="gender_"+(i+1);
		cell7.appendChild(gender2);
		var female_label1 = document.createElement("label");
		female_label1.innerHTML="Female";		
		cell7.appendChild(female_label1);

		var gender3 = document.createElement("input");
		gender3.type="radio";
		gender3.value="Others";
		gender3.id="gender_"+(i+1);
		gender3.name="gender_"+(i+1);		
		cell7.appendChild(gender3);
		var others_label1 = document.createElement("label");
		others_label1.innerHTML="Others";		
		cell7.appendChild(others_label1);
		
	}	
}
</script></center>
<div align="center">

		<br><input type="submit" value=" Book Now " onclick="checkBook" class = "button-21"> <br/></div>
</form>

</body>
</html>