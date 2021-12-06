package com.torryharris.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import com.torryharris.model.DBConnection;
import com.torryharris.model.User;



@Controller
public class LoginController {

	 @RequestMapping("/login")
	 public ModelAndView login(@RequestParam("user") String userId,
				@RequestParam("password") String password){
		 ModelAndView mv = new ModelAndView();
		 try {
				Connection con = DBConnection.getConnection();
				System.out.println("connected");
				PreparedStatement ps = con.prepareStatement("select * from register where userid=? and password=?");
				
				ps.setString(1, userId);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					System.out.println("user find");
					mv.setViewName("SirBook.html");
					
				}
				else{
					System.out.println("wrong user name");
					mv.setViewName("index.jsp");
				}
								
		 		}
		 catch (Exception e)
		 {
			 System.out.println(e);
		 }
		 
			
			
			mv.addObject("message", "Registration Success !! "
					+ "Login to continue");

		return mv;
	 }
	@RequestMapping("/register")
	   
	       public ModelAndView register(@RequestParam("userid") String userId,
	    		   @RequestParam("fname") String fName,
	    			@RequestParam("password1") String password,
	    			@RequestParam("phoneno") String phoneNo,
	    			@RequestParam("email") String eMail )
	    			{
		 try {
				Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?)");
				
				ps.setString(1, userId);
				ps.setString(2, fName);
				ps.setString(3, password);
				ps.setString(4, phoneNo);
				ps.setString(5, eMail);
				int k = ps.executeUpdate();
				System.out.println(k);
				if(k==1) 
				{
					//ModelAndView mv = new ModelAndView();
					System.out.println("Registered user");
					
					//mv.setViewName("index.jsp");
				//	mv.addObject("message", "Registration Success !! "			+ "Login to continue");
				}
							
				//else{
				

				//}
				
				//	pw.println("<div class='tab'><p1 class='menu'>User Registered Successfully !</p1></div>");
					
				}
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 ModelAndView mv = new ModelAndView();
			System.out.println("in loop");
			mv.setViewName("index.jsp");
			mv.addObject("message", "Registration Success !! "
					+ "Login to continue");

		return mv;
	    			
	    			
	    			
	
		/*	boolean loginStatus=false;
			for(User user:userList){
			if(userName.equals(user.getUserName()) && 
					password.equals(user.getPassword())){
				loginStatus=true;
				break;
				} 
			}
			ModelAndView mv = new ModelAndView();
			mv.setViewName("response.jsp");
			mv.addObject("status", loginStatus);
			if(loginStatus){
				mv.addObject("username",userName);
			}
			return mv;*/
		

	 }
}
