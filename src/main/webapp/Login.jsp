<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Login and Register</title>
      <link rel="stylesheet" href="Login.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
      
   </head>
   <body>
    <center> <h2 >${messageRegisterSucess}</h2> 
            <h3>${message}</h3>
         <h3>${messageid}</h3>
        <h3>${messagemail}</h3> </center>
   
      <div class="wrapper">
          
         <div class="title-text">
            <div class="title login">
               Login Form
            </div>
            <div class="title signup">
               Signup Form
            </div>
         </div>
         <div class="form-container">
            <div class="slide-controls">
               <input type="radio" name="slide" id="login" checked>
               <input type="radio" name="slide" id="signup">
               <label for="login" class="slide login">Login</label>
               <label for="signup" class="slide signup">Signup</label>
               <div class="slider-tab"></div>
            </div>
            <div class="form-inner">
            
               <form action="login" method="post" class="login">
                   <td> user type </td>
                    <td> <select name="typelogin"  required>
                      <option > </option>
                    <option value="Admin">Admin</option>
                    <option value="User">User</option>
                    </select>
                    </td>
                  <div class="field">
                     <input type="text"  name="username" placeholder="Enter Username" required>
                  </div>
                  <div class="field">
                     <input type="password"  name="password" placeholder="Password" required>
                  </div>
                  <div class="field">
                     <input type="text"  id="textBox" name="text" placeholder="Enter Captcha" required>
                  </div>
                  
 <canvas id="captcha"  width="200" height="100" >captcha text</canvas> <br>
 
             
                <button id="submitButton" type="submit"> Submit</button> &nbsp &nbsp &nbsp
                <button id="refreshButton" type="submit">Refresh</button><br> 
                <span id="output"></span>
                
                  <div class="pass-link">
                     <a href="NewForgot.jsp">Forgot password?</a>
                </div>
                <script src="script.js"></script>
             
                  <div class="signup-link">
                     Not a member? <a href="">Signup now</a>
                  </div>
               </form>
               <script src="Validations.js"> </script>
               <form action="register" method="post" class="signup">
               
                   <div class="field">
                     <input type="text" id="username" name="userid" placeholder="User Name" required>
                  </div>
                   <div class="field">
                     <input type="text" id="fname" name="fname" placeholder="Full Name" required>
                  </div>
                  <div class="field">
                     <input type="text" id="mail" name="email" placeholder="Email Address" required>
                  </div>
                   <div class="field">
                     <input type="number" id="phone" name="phoneno" placeholder="phone number" required>
                  </div>
                  <div class="field">
                     <input type="password" id="password1" name="password1" placeholder="Password" required>
                  </div>
                  <div class="field">
                     <input type="password" id="password2" name="passsword2" placeholder="Confirm password" required>
                  </div>
                  <div class="field">
                     <input type="text" id="securityquestion" name="securityans" placeholder="What is your favourite dish" required="" 
                     oninvalid="this.setCustomValidity('Security Question')"
 					oninput="setCustomValidity('')"></input>
                  </div>
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" onclick="checkValues()" value="Signup" >
                  </div>
               </form>
            </div>
         </div>
      </div>
      <script>
         const loginText = document.querySelector(".title-text .login");
         const loginForm = document.querySelector("form.login");
         const loginBtn = document.querySelector("label.login");
         const signupBtn = document.querySelector("label.signup");
         const signupLink = document.querySelector("form .signup-link a");
         signupBtn.onclick = (()=>{
           loginForm.style.marginLeft = "-50%";
           loginText.style.marginLeft = "-50%";
         });
         loginBtn.onclick = (()=>{
           loginForm.style.marginLeft = "0%";
           loginText.style.marginLeft = "0%";
         });
         signupLink.onclick = (()=>{
           signupBtn.click();
           return false;
         });
      </script>
   </body>
</html>
