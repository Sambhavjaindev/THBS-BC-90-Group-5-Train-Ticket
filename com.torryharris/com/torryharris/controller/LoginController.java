package com.torryharris.controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.TreeMap;


import com.torryharris.model.Passenger;

import com.torryharris.model.Ticket1;
import com.torryharris.model.Train;
import com.torryharris.model.TrainDAO;




@RestController
public class LoginController {

 static Ticket1 ticket;

 private TreeMap<Passenger, Double> passengers;
	

	 @RequestMapping("/login")
	 public ModelAndView login(@RequestParam("user") String userId,
				@RequestParam("password") String password){
		 ModelAndView mv = new ModelAndView();
		 try {
				Connection con = TrainDAO.getConnection();
				System.out.println("connected");
				PreparedStatement ps = con.prepareStatement("select * from register where userid=? and password=?");
				
				ps.setString(1, userId);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					System.out.println("user find");
					mv.addObject("message3", "Registration Success !! "
							+ "Login to continue");
					mv.setViewName("SourceDestination.html");
					
				}
				else{
					System.out.println("wrong user name");
					mv.addObject("message", "Invalid Username and password");
					mv.setViewName("index.jsp");
				}
								
		 		}
		 catch (Exception e)
		 {
			 System.out.println(e);
		 }
		 
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
				Connection con = TrainDAO.getConnection();
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
					System.out.println("Registered user");
				}
							
				else{
					System.out.println("Not Registered");
				}
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
	 }

	
	 @RequestMapping("/booktrains")
	public Ticket1 search(@RequestParam("trainno") int trainNo,
				@RequestParam("date") String date,@RequestParam("name") String nameP,
				@RequestParam("age") int age,
	 @RequestParam("gender") String Gender) throws ClassNotFoundException, IOException  {
		
		 
		 LocalDate fDate = null;
	 try {
	            String[] dateArr = date.split("/");
	            fDate = LocalDate.of(
	                    Integer.valueOf(dateArr[2]),
	                    Integer.valueOf(dateArr[1]),
	                    Integer.valueOf(dateArr[0]));
	           Train train = TrainDAO.findTrain(trainNo);
		        System.out.println(train);
		       ticket=new Ticket1(fDate,train);
		       ticket.addPassenger(nameP, age, Gender.charAt(0));
		       ticket.writeTicket();
		       
		       
		       
		       
	        } 
	 catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        		 
	       }

      catch (SQLException e) {
         System.out.println("train not found");
     }
	// mv.setViewName("PassengerBook.html");

		return ticket;
		//return mv;

	 }
	
	/* @RequestMapping("/booktrains")
	public Ticket search(@RequestParam("trainno") int trainNo,
			@RequestParam("date") String date,	
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			 @RequestParam("gender") String Gender) throws ClassNotFoundException, SQLException, IOException
	 {
		 LocalDate fDate = null;
		 try {
		            String[] dateArr = date.split("/");
		            fDate = LocalDate.of(
		                    Integer.valueOf(dateArr[2]),
		                    Integer.valueOf(dateArr[1]),
		                    Integer.valueOf(dateArr[0]));
		           Train train = TrainDAO.findTrain(trainNo);
			        System.out.println(train);
			       ticket=new Ticket(fDate,train);
int id=2;
		 System.out.println(id);
		 for(int i=0;i<id;i++)
		 {
			   ticket.addPassenger(name, age, Gender.charAt(0));
	

		 }
		 	}
		 catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
		 }
		      catch (SQLException e) {
		         System.out.println("train not found");
		     }
	       ticket.writeTicket();
		return ticket;
		
	 }*/
		 
	 
	 /*
	 @RequestMapping("/addP")
	 public Ticket addP(@RequestParam("name") String nameP,
				@RequestParam("age") int age,
	 @RequestParam("gender") String Gender) throws ClassNotFoundException, SQLException{
		//ModelAndView mv = new ModelAndView();
        System.out.println(nameP +age+Gender);
	 Ticket ticket=new Ticket();
		 ticket.addPassenger(nameP, age, Gender.charAt(0));

		 //mv.setViewName("index.jsp");
	return ticket;
	 }
*/

}