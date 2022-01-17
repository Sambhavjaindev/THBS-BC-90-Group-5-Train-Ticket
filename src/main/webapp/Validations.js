


function forgot()
{
	checkPassword();
	ValidateEmail();
}
function checkBook()
{
	checkAllLetter();
}

function checkValues()
{	
	validateUserName();
	checkAllLetter();
	ValidateEmail();
	checkPhoneNumber();
	checkPassword();
	
	
	
}
function checkPassword(){
	
	var p1 = document.getElementById("password1").value;
	var p2 = document.getElementById("password2").value;
	if(p1==p2)
	{
		checkPasswordCondition();
	}
	else{
		alert("Two Passwords Must be same !!");
		event.preventDefault();
	}
}

function checkAllLetter()
      { 
      var letters = /^[A-Za-z\s]+$/;
      var inputtxt=document.getElementById("fname");
      if(inputtxt.value.match(letters))
      {
    
		return true;
      }
      else
      {
      alert('Please Input alphabets only');
     
	  event.preventDefault();
	 // document.form1.FullName.focus();
      }
      }
function ValidateEmail()
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
var inputText=document.getElementById("mail").value;
if(inputText.match(mailformat))
{
return true;

}
else
{
alert("You have entered an invalid email address!");
document.form1.E-mail.focus();

event.preventDefault();
}
}

function checkPhoneNumber()
{
	var inputPhone=document.getElementById("phone");
  var phoneno = /^\d{10}$/;
  if(inputPhone.value.match(phoneno))
  {
      return true;
  }
  else
  {
     alert("Not a valid Phone Number");
     event.preventDefault();
  }

  
}
function checkPasswordCondition() 
{ 
var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
var passwordCondition=document.getElementById("password1");
if(passwordCondition.value.match(decimal)) 
{ 
return true;
}
else
{ 
alert("Password must contain at least one lowercase letter, one uppercase letter, one numeric digit, one special character and minimum length is 8 and max is 15");
event.preventDefault();
}
} 
function validateUserName(){
	var userName=document.getElementById("username");
	var usernameRegex = /^[a-zA-Z0-9]+$/;
	if(userName.value.match(usernameRegex))
		{
		return true;
		}
	  
	else
	{
		alert("Username contains only letters or numbers");
		event.preventDefault();
	}
}

function validateUPI()
{
	var upi=document.getElementById("username").value;
	var  upiREGEX = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);
	if(upi.match(upiRegex))
	{
	return true;
	}
	else
	{
		alert("Wrong UPI Id");
		event.preventDefault();
	}

}
