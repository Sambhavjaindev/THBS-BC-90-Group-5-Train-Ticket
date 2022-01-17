<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <title> Train Ticket Booking </title>
    <link rel="stylesheet" type="text/css" href="Style.css">
</head>

<body >
<script src="Validations.js"> </script>




    <div class="banner">
        <div class="navbar">
            <div>
            <a href="NewIndex.jsp">Home</a>
            </div>
            <nav>
         <center> <h2>${message}</h2> 
         <h2 >${messageRegisterSucess}</h2>   
         <h2>${messageid}</h2>
        <h2>${messagemail}</h2> </center>
            <ul id ='MenuItems'>
                <li> <a href="about.html">About Us</a></li>
                <li> <a href="help.html">Help</a></li>
                
                
                <li><button class='loginbtn' onclick="document.getElementById('login-form').style.display='block' "
                            style="width: auto;">LOGIN</button></li>
            
            </ul>
            </nav>
               
        </div>
        
        <div id='login-form' class='login-page'>
                    
        <div class="form-box">
            <div class="button-box">
            
                <div id="btn"></div>
                <button type="button" onclick="login()" class="toggle-btn">LOGIN</button>
                <button type="button" onclick="register()" class="toggle-btn">REGISTER</button>
            </div>
            
            
        <!---login--->
            <form action="login" id="login" class="input-group-login" method="post">
            

              
<h3> User Type : &nbsp  
               
                <td> <select name="typelogin" required  >
                    <option > </option>
                    <option value="Admin">Admin</option>
                     <option value="User">User</option>
                    </select>
                        </td></h3>
                
           
               <input type="text" class="input-field" name="username" placeholder="User id" required>
               
                
                 <input type="password" class="input-field" name="password" placeholder="Enter password" required> 
               
                  <input id="textBox" type="text" name="text" style="color:white"class="input-field" placeholder="Enter captcha" required> 


 <canvas id="captcha"  width="200" height="100" >captcha text</canvas> <br>
 
             
                <button id="submitButton" type="submit"> Submit</button> &nbsp &nbsp &nbsp
                <button id="refreshButton" type="submit">Refresh</button><br> 
                <span id="output"></span>
      
                <a href="Forgot.jsp">Forgot password?</a>
                <script src="script.js"></script>
            </form>     
            
            
        <!---registration--->
       
            <form action="register" id="register" class="input-group-register" method="post">
            
                 <input type="text" class="input-field" id="username" name ="userid" placeholder="User Id" required>
               
                
                 <input type="text" class="input-field" id="fname" name="fname" placeholder=" Full Name" required>
                
              
                <input type="password" class="input-field" id="password1" name="password1" placeholder="Enter password" required>
                
              
                <input type="password" class="input-field" id="password2"  name="password2" placeholder="Confirm Password" required>
                
                 <input type="number" class="input-field" id="phone" name="phoneno" placeholder="10-Digit PhoneN0" required>
                 
                  <input type="text" class="input-field" id="mail" name="email" placeholder="Email Id" required>
               
                <input type="checkbox" class="check-box" required><span>I agree to the terms and conditions</span>
                
                <button type="submit" class="submit-btn" onclick="checkValues()"> Signup</button>
       
            </form>
        </div>
        
        </div>
        
        
    </div>
    
    <script>
        var x=document.getElementById('login');
        var y=document.getElementById('register');
        var z=document.getElementById('btn');
        function register()
        {
            x.style.left='-400px';
            y.style.left='50px';
            z.style.left='110px';
        }
        function login()
        {
            x.style.left='50px';
            y.style.left='450px';
            z.style.left='0px';
        }
    </script>
    
    <script>
        var modal=document.getElementById('login-form');
        window.onclick=function(event)
        {
            if(event.target==modal)
                {
                    modal.style.display="none";
                }
        }
        
    </script>
    
     
    
    
    </body></html>

        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
