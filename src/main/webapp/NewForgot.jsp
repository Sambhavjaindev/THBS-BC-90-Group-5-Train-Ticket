<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Forgot page </title>
      <link rel="stylesheet" href="Forgot.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <style>
  
.navbar{
	margin: -10px;
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
}  </style>
   </head>
   <body>
   <center> <h2>${messagef}</h2> 
   	<h2>${messageid}</h2> 
   	<h2>${messageans}</h2> 
         <h2>${messageff}</h2>   </center>
   <script src="Validations.js"> </script>
                                          <div class="navbar">
      <ul>
                <li><a class="active" href="index.jsp">Home</a></li>
      </ul>
   </div>

      <div class="wrapper">
          
         <div class="title-text">
            <div class="title login">
               Forgot Form
            </div>
            
         </div>
         <div class="form-container">
           
               
              
               
              

        
            <div class="form-inner">
               <form action="forgot" method="post"class="login">
                   
                  <div class="field">
                     <input type="text"  id="mail" name="email" placeholder="Email Address" required>
                  </div>
                  <div class="field">
                     <input type="password" id="password1" name="password1" placeholder="Enter New Password" required>
                  </div>
                    <div class="field">
                     <input type="password" id="password2" name="password2" placeholder="Confirm New Password" required>
                  </div>
                    <div class="field">
                     <input type="text" id="securityquestion" name="securityans" placeholder="What is your favourite dish" required="" 
                     oninvalid="this.setCustomValidity('Security Question')"
 					oninput="setCustomValidity('')"></input>
                  </div>
                  
                  
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Submit" onclick="forgot()">
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