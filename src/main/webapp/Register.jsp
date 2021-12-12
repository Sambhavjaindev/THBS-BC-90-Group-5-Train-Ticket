<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

 <!DOCTYPE html>   
<html>   
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">  
<title> Login Page </title>  
<style>  


    span.new{

        float: right;

        padding-top: 16px;

    }

    span .new{

            display: block;

            float: none;

        }



Body {  
  background-image: url(train.jpg);
  background-image: no-repeat;
  background-size: 100% 150%;
}  
button {   
       background-color: #4CAF50;   
       width: 75%;  
        color: orange;   
        padding: 15px;   
        margin: 10px 0px;
        margin-left:20px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 1px solid #f1f1f1;   
    }   
 input[type=text],input[type=number]{   
        width: 60%;   
        margin: 8px 0; 
        margin-left:32px; 
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 input[type=password] {
 	    width: 60%;   
        margin: 8px 0; 
        margin-left:32px; 
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;	
 
 }
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
    a{
     text-decoration: none;

        color:yellow;

        border-color: white;
    }   
    label{
    color:yellow;
    } 
     
 .container {   
        padding: 25px;   
        max-width: 38em;

            padding: 1em 3em 2em 3em;

            margin: 0em auto;

            border-radius: 4.2px;

            box-shadow: 0px 3px 10px -2px rgba(0, 0, 0, 0.2); 
  
</style>   
</head> 
<script src="Validations.js"> </script>
<body>    
    <center> <h1> Ticket Booking System </h1> </center>   
    <form name="form1" action="register" method="post">  
        <div class="container">
        
<h3>${message}</h3>   
            <label>Username : </label>   
            <input type="text" placeholder="Enter Username" id="username" name="userid" required>  <br><br>
            <label>FullName : </label>   
            <input type="text" placeholder="Enter FullName" id="fname" name="fname" required > <br><br> 
            <label>Password : </label>   
            <input type="password" placeholder="Enter Password" id="password1" name="password1" required> <br><br> 
            <label>Password : </label>   
            <input type="password" placeholder="Re-Enter Password" id="password2" name="password2" required> <br><br> 
            <label>PhoneNo: </label>
            <input type="number" placeholder="Enter PhoneNo" id="phone" name="phoneno" required> <br><br> 
            <label>E-mailId : </label>
            <input type="text" placeholder="Enter E-mail Id" id="mail" name="email" required > <br><br> 
    
            <button type="submit" onclick="checkValues()">Submit</button>   <br><br>
           <a href="Login.html">Already Have an account?</a> <br><br>
           
        </div>   
    </form>     
</body>     
</html>  