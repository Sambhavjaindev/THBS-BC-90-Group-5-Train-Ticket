<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Admin</title>
      <link rel="stylesheet" href="admin.css">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">

   </head>
   <center> <h2>${message1}</h2> 
         <h2>${message2}</h2>  
         <h3>${message2}</h3> </center>
         
   
   <body>
   
         <div class="navbar">
      <ul>
                <li><a class="active" href="index.jsp">Logout</a></li>
                <li><a class="active" href="ShowTrains.jsp">Show Train</a></li>
      </ul>
   </div>
      <div class="wrapper">
          
         <div class="title-text">
            <div class="title login">
               Remove Train
            </div>
            <div class="title signup">
               Add Train
            </div>
         </div>
         <div class="form-container">
            <div class="slide-controls">
               <input type="radio" name="slide" id="login" checked>
               <input type="radio" name="slide" id="signup">
               <label for="login" class="slide login">Remove Train </label>
               <label for="signup" class="slide signup">Add Train</label>
               <div class="slider-tab"></div>
            </div>
            <div class="form-inner">
               <form action="adminremove" method="post" class="login">
                   
                  <div class="field">
                     <input type="number" name="trainno" placeholder="Train number" required>
                  </div>
                 
                 
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Remove Train">
                  </div>
                 
               </form>
               <form action="adminadd" method="post"  class="signup">
                   <div class="field">
                     <input type="number"  name="trainno" placeholder="Train Number" required>
                  </div>
                   <div class="field">
                     <input type="text"  name="trainname" placeholder="Train Name" required>
                  </div>
                  <div class="field">
                     <input type="text" name="source" placeholder="Source" required>
                  </div>
                   <div class="field">
                     <input type="text" name="destination" placeholder="Destination" required>
                  </div>
                  <div class="field">
                     <input type="number" name="price" placeholder="Fare" required>
                  </div>
                  <div class="field">
                     <input type="number" name="seats" placeholder="Seats" required>
                  </div>
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Add Train">
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