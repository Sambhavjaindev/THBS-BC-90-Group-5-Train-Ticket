package com.torryharris.controller;


import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.torryharris.model.DBConnection;
import com.torryharris.model.Ticket;
import com.torryharris.model.Train;
import com.torryharris.model.TrainDAO;




@Controller
public class LoginController {
Train train;
	//PrintWriter pw = res.getWriter();
	//res.setContentType("text/html");

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
					mv.setViewName("SourceDestination.html");
					
				}
				else{
					System.out.println("wrong user name");
			//		pw.println("<div class='tab'><p1 class='menu'>Invalid Username Or Password !</p1></div>");
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
			mv.addObject("message1", "Registration Success !! "
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
	/*
	 @RequestMapping("/booktrains")
	 public ModelAndView search(@RequestParam("source") String Source,
				@RequestParam("destination") String Destination,
				@RequestParam("age") int age){
		 ModelAndView mv = new ModelAndView();
		 try {
				Connection con = DBConnection.getConnection();
				System.out.println("connected");
				PreparedStatement ps = con.prepareStatement("select * from trains where source=? and destination=?");
				
				ps.setString(1, Source);
				ps.setString(2, Destination);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					System.out.println("In train database");
					mv.setViewName("SirBook.html");
					System.out.println(rs.getString("source") +rs.getString("destination"));
					
				}
				else{
					System.out.println("wrong user name");
					mv.setViewName("index.jsp");
				}
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);		 }
		return mv;
	
	 }*/
	 @RequestMapping("/booktrains")
	 public ModelAndView search(@RequestParam("trainno") int trainNo,
				@RequestParam("date") String date) throws ClassNotFoundException  {
		 ModelAndView mv = new ModelAndView();
		 
		 LocalDate fDate = null;
	 try {
	            String[] dateArr = date.split("/");
	            fDate = LocalDate.of(
	                    Integer.valueOf(dateArr[2]),
	                    Integer.valueOf(dateArr[1]),
	                    Integer.valueOf(dateArr[0]));
	            train = TrainDAO.findTrain(trainNo);
		        System.out.println(train);
		        Ticket ticket=new Ticket(fDate,train);
	        } 
	 catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
         


		 
		// Connection con = DBConnection.getConnection();
		 //Statement st = con.createStatement();
	      //  ResultSet rs = st.executeQuery("select * from trains where train_no =" + trainNo);
	       // rs.next();

	       }

        // train = TrainDAO.findTrain(trainNo);
      catch (SQLException e) {
         System.out.println("train not found");
     }
	 mv.setViewName("PassengerBook.html");

	//return mv;
	return mv;
	 }
	 
	 @RequestMapping("/addP")
	 public ModelAndView addP(@RequestParam("name") String nameP,
				@RequestParam("age") int age,
	 @RequestParam("gender") String Gender) throws ClassNotFoundException, SQLException{
		 ModelAndView mv = new ModelAndView();
        Ticket t=new Ticket();
		 t.addPassenger(nameP, age, Gender.charAt(0));

		 mv.setViewName("index.jsp");
	return mv;
	 }


}