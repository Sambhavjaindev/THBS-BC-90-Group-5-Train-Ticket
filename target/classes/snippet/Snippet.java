package snippet;

public class Snippet {
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
	label {
		color: yellow;
	}
	
	
	Body {  
	  background-image: url(wwe.jpg);
	  background-image: no-repeat;
	  background-size: 100% 150%;
	}  
	button {   
	       background-color: #4CAF50;   
	       width: 78%;  
	       margin-left:10px;
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
	 input[type=text], input[type=password] {   
	        width: 60%;   
	        margin: 8px 0; 
	        margin-left:25px; 
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
	
	        color: yellow;
	
	        border-color: white;
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
	<body>    
	    <center> <h1> Ticket Booking System </h1> </center>   
	    <form action = "home.html">  
	        <div class="container">   
	            <label>username : </label>   
	            <input type="text" placeholder="Enter Username" name="username" required>  <br><br>
	            <label>Password : </label>   
	            <input type="password" placeholder="Enter Password" name="password" required> <br><br> 
	            <button type="submit">Login</button>   <br><br>
	           <a href="register.html">New user?</a> <br><br>
	          <a href="#">   Forgot  password? </a>   
	        </div>   
	    </form>     
	</body>     
	</html>  
}

