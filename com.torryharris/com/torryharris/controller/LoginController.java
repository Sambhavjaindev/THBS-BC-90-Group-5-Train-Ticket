package com.torryharris.controller;



import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import com.torryharris.model.Passenger;

import com.torryharris.model.Ticket1;
import com.torryharris.model.Train;
import com.torryharris.model.TrainDAO;




@RestController
public class LoginController {

 static Ticket1 ticket;
 PreparedStatement ps;
 ResultSet rs;

 private TreeMap<Passenger, Double> passengers;
	

	 @RequestMapping("/login")
	 public ModelAndView login(HttpServletRequest request ,@RequestParam("typelogin") String typeLogin){
		 ModelAndView mv = new ModelAndView();
		 try {
				Connection con = TrainDAO.getConnection();
				System.out.println("connected");
				System.out.println(typeLogin);
				if(typeLogin.equals("Admin"))
				{
			 ps = con.prepareStatement("select * from admin where userid=? and password=?");
			 String userId=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(userId+" "+ password);

				ps.setString(1, userId);
				ps.setString(2, password);
				 rs = ps.executeQuery();
				if(rs.next())
				{
					System.out.println("Admin find");
					
					mv.setViewName("Admin.html");
					
				}
				else{

					System.out.println("wrong user name");
					mv.addObject("message", "Invalid Username or password");
					mv.setViewName("NewIndex.jsp");

				}
				}
				else if(typeLogin.equals("User")){
					 ps = con.prepareStatement("select * from register where userid=? and password=?");
					 String userId=request.getParameter("username");
				String password=request.getParameter("password");
				System.out.println(userId +" "+password);
				System.out.println(userId+" "+ password);

						ps.setString(1, userId);
						ps.setString(2, password);
						 rs = ps.executeQuery();
						if(rs.next())
						{
							System.out.println("user find");
				
						
							mv.setViewName("ShowTrainsUser.jsp");

				
						}
				
				else{

					System.out.println("wrong user name");
					mv.addObject("message", "Invalid Username or password");
					mv.setViewName("NewIndex.jsp");

				}
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
	    			{	ModelAndView mv = new ModelAndView();
	    			
		 try {
			 
				Connection con = TrainDAO.getConnection();
				 ps=con.prepareStatement("select * from register where userid=? ");
				ps.setString(1,userId);
			
				 rs=ps.executeQuery();
				if(rs.next())
				{
					System.out.println("Id already exist.");
					mv.addObject("message", "UserId  already exist");
					mv.setViewName("Register.jsp");

				}
				else if(rs.next())
				{
				 ps=con.prepareStatement("select * from register where Email=?");
				 ps.setString(1, eMail);
				 rs=ps.executeQuery();
					if(rs.next())
					{
						System.out.println("Email already exist");
						mv.addObject("message", "Email already exist. Please choose new email");
						mv.setViewName("Register.jsp");

					}

				}
				
				else {
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
					System.out.println("in loop");
					mv.setViewName("index.jsp");
					mv.addObject("messageRegisterSucess", "Registration Success !! "
							+ "Login to continue");

				}
							
				else{
					System.out.println("Not Registered");
				}
				}
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
			
						

		return mv;
	 }

	//working
	 @RequestMapping("/booktrains")
	public Ticket1 search(HttpServletRequest request,@RequestParam("passenger_count") int passengerCount)
				 throws ClassNotFoundException, IOException, SQLException  {
		// String date1=date.toString();
	//	 check(trainNo,date);
	//	 LocalDate fDate = null;
		 try {
	//	 Connection con = TrainDAO.getConnection();
		//	 ps=con.prepareStatement("select * from trains where train_no=? ");
			//ps.setInt(1,trainNo);
		
		//	 rs=ps.executeQuery();
		//	if(rs.next())
		//	{
		//		System.out.println("Id already exist.");
		//		mv.addObject("message", "UserId  already exist");
		//		mv.setViewName("Register.jsp");

		//	}
		   /*         String[] dateArr = date.split("/");
		            fDate = LocalDate.of(
		                    Integer.valueOf(dateArr[2]),
		                    Integer.valueOf(dateArr[1]),
		                    Integer.valueOf(dateArr[0]));
		           Train train = TrainDAO.findTrain(trainNo);
			        System.out.println(train);
			       ticket=new Ticket1(fDate,train);*/

		 for(int i=0;i<passengerCount;i++)
		 {
			 String name=request.getParameter("name_"+(i+1));
			 //System.out.println(name);
		String gender=request.getParameter("gender_"+(i+1));
			 int age=Integer.parseInt(request.getParameter("age_"+(i+1)));
			 System.out.println("name " +name +" gender "+gender +" age " + age);
			 ticket.addPassenger(name, age, gender.charAt(0));
			 
		 }
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
	
	 @RequestMapping("/checktrains")
	public ModelAndView check(@RequestParam("trainno") int trainNo,
			@RequestParam("date") String Date) throws ClassNotFoundException, SQLException, IOException
	 {
		 ModelAndView mv=new ModelAndView();
		 LocalDate fDate = null;
		 try {
		            String[] dateArr = Date.split("/");
		            fDate = LocalDate.of(
		                    Integer.valueOf(dateArr[2]),
		                    Integer.valueOf(dateArr[1]),
		                    Integer.valueOf(dateArr[0]));
		            LocalDate currDate = LocalDate.now();

		       /*     if(fDate.getYear() <  currDate.getYear()){
		                mv.addObject("message","Wrong Year");
		            } 
		            else if(fDate.getYear() ==  currDate.getYear() &&
		            fDate.getMonthValue() < currDate.getMonthValue())
		            {
		            	 mv.addObject("message","Wrong Month");
		            }
		            else if (fDate.getYear() ==  currDate.getYear() &&
		                    fDate.getMonthValue() == currDate.getMonthValue() &&
		            fDate.getDayOfMonth() < currDate.getDayOfMonth())
		            {
		            	 mv.addObject("message","Wrong Date");
		            }

		           Train train = TrainDAO.findTrain(trainNo);
			        System.out.println(train);
			       
			        if(train == null)
			        {
			        	mv.addObject("message1", "Select valid Train Number");
			        }*/
		            Train train = TrainDAO.findTrain(trainNo);
			        System.out.println(train);
			        mv.setViewName("SirBook.html");
			       ticket=new Ticket1(fDate,train);
		 	}
		 catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
		 }
	      
		//return ticket;
		return mv;
	 }
	 
	 @RequestMapping("/adminadd")
	 public ModelAndView admin(@RequestParam("trainno") int trainNo,
				@RequestParam("trainname") String trainName,@RequestParam("source") String source,@RequestParam("destination") String destination,
				@RequestParam("price") String ticketPrice) throws SQLException, ClassNotFoundException{
		 ModelAndView mv = new ModelAndView();
		 try {
				
				Connection con = TrainDAO.getConnection();
				System.out.println("connected");
				PreparedStatement ps = con.prepareStatement("insert into trains values(?,?,?,?,?)");
				
				ps.setInt(1,trainNo);
				ps.setString(2,trainName);
				ps.setString(3,source);
				ps.setString(4,destination);
				ps.setString(5,ticketPrice);
				int p = ps.executeUpdate();
				System.out.println(p);
				if(p==1)
				{
					System.out.println("Train added suceesfully");
					mv.setViewName("ShowTrains.jsp");
					
				}
				else
				{
					System.out.println("Train not added");
					mv.setViewName("index.jsp");
				}
								
		 		}
		 catch (Exception e)
		 {
			 System.out.println(e);
		 }
		 
				
				
		 return mv;
	 }

	 @RequestMapping("/adminremove")
	 public ModelAndView admin(@RequestParam("trainno") int trainNo)
	 {
		 ModelAndView mv = new ModelAndView();
		 try {
				
				Connection con = TrainDAO.getConnection();
				
				System.out.println("connected");
				PreparedStatement ps = con.prepareStatement("delete from trains where train_no=?");
				ps.setInt(1,trainNo);
				int p = ps.executeUpdate();
				System.out.println(p);
				if(p==1)
				{
					System.out.println("Train removed suceesfully");
					mv.setViewName("ShowTrains.jsp");
					
				}
				else
				{
					System.out.println("wrong user name");
					mv.setViewName("index.jsp");
				}
								
		 		}
		 catch (Exception e)
		 {
			 System.out.println(e);
		 }
		 
				
				
		 return mv;
		 
	 }
		 
	 
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