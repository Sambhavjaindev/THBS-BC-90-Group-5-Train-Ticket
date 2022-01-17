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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.torryharris.model.Passenger;

import com.torryharris.model.Ticket1;
import com.torryharris.model.Train;
import com.torryharris.model.TrainDAO;




@RestController
public class LoginController {

 static Ticket1 ticket;
 Connection con;
 PreparedStatement ps;
ResultSet rs;
 Train train;
 int number;

 private TreeMap<Passenger, Double> passengers;
	

	 @RequestMapping("/login")
	 public ModelAndView login(HttpServletRequest request ,@RequestParam("typelogin") String typeLogin){
		 ModelAndView mv = new ModelAndView();
		 try {
				con = TrainDAO.getConnection();
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
					
					mv.setViewName("Admin.jsp");
					
				}
				else{

					System.out.println("wrong user name");
					mv.addObject("message", "Invalid Username or password !! Login again");
					mv.setViewName("Login.jsp");

				}
				}
				else if(typeLogin.equals("User")){
					 ps = con.prepareStatement("select * from register where userid=? and password=?");
					 String userId=request.getParameter("username");
				String password=request.getParameter("password");
				System.out.println(userId +" "+password);
			

						ps.setString(1, userId);
						ps.setString(2, password);
						 rs = ps.executeQuery();
						if(rs.next())
						{
							System.out.println("user find");
				
						
							mv.setViewName("ShowTrainNewUser.jsp");

				
						}
				
				else{

					System.out.println("wrong user name");
					mv.addObject("message", "Invalid Username or password !! Login Again");
					mv.setViewName("Login.jsp");

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
	    			@RequestParam("email") String eMail,@RequestParam("securityans") String securityAns ) 
	    			{	ModelAndView mv = new ModelAndView();
	    			
		 try {
			 
				Connection con = TrainDAO.getConnection();
				 ps=con.prepareStatement("select * from register where userid=? ");
				ps.setString(1,userId);
				rs=ps.executeQuery();
				PreparedStatement ps1=con.prepareStatement("select * from register where Email=?");
				 ps1.setString(1, eMail);
				 ResultSet rs1=ps1.executeQuery();
				if(rs.next())
				{
					System.out.println("Id already exist.");
					mv.addObject("messageid", "UserId  already exist");
					mv.setViewName("Login.jsp");
				}
				
					else if(rs1.next())
					{
		
						System.out.println("Email already exist");
						mv.addObject("messagemail", "Email already exist. Please choose new email");
					mv.setViewName("Login.jsp");
					

					}
					
			
				else{
				
				ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");
				
				ps.setString(1, userId);
				ps.setString(2, fName);
				ps.setString(3, password);
				ps.setString(4, phoneNo);
				ps.setString(5, eMail);
				ps.setString(6, securityAns);
				int k = ps.executeUpdate();
				System.out.println(k);
				if(k==1) 
				{
					System.out.println("Registered user");
					System.out.println("in loop");
					mv.setViewName("Login.jsp");
					mv.addObject("messageRegisterSucess", "Registration Success !! "
							+ "Login to continue");

				}
				}
							
			
				
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
			
						

		return mv;
	 }

	
	 @RequestMapping("/booktrains")
	public ModelAndView search(HttpServletRequest request,HttpServletResponse response,@RequestParam("passenger_count") int passengerCount)
				 throws ClassNotFoundException, IOException, SQLException, ServletException  {
		ModelAndView mv=new ModelAndView();
		
		 try{
			 for(int i=0;i<passengerCount;i++)
		 {
			 String name=request.getParameter("name_"+(i+1));
			 
		String gender=request.getParameter("gender_"+(i+1));
		int age=Integer.parseInt(request.getParameter("age_"+(i+1)));
		
			 System.out.println("name " +name +" gender "+gender +" age " + age);
	
			 ticket.addPassenger(name, age, gender.charAt(0));
		 }
		
		 
		 
		 
		 ticket.writeTicket();
		 int avail=0 ;
		 ps=con.prepareStatement("Select Seats from trains where train_no=?");
		 ps.setInt(1, number);
		 rs=ps.executeQuery();
		 if(rs.next())
		 {
			 avail=rs.getInt(1);
			avail= avail-passengerCount;
		 
		 ps=con.prepareStatement("Update trains set seats=? where train_no=?");
		 ps.setInt(1, avail);
		 ps.setInt(2, number);
		 int i =ps.executeUpdate();
		 if(i==1)
		 {
			 System.out.println("Seats Updated");
		 }
		 }
		 mv.setViewName("TicketPrint.jsp");
		 mv.addObject("ticket",ticket);
			
		 //System.out.println("payment");
	
				 //request.getRequestDispatcher("Payment.html").forward(request,response);
		      
		     
		      	       
	        } 
	 catch (NumberFormatException e) {
        		 
	       }

      catch (SQLException e) {
         System.out.println("train not found");
     }
	// mv.setViewName("PassengerBook.html");

		//return ticket;
		return mv;

	 }
	
	 @RequestMapping("/checktrains")
	public ModelAndView check(@RequestParam("trainno") int trainNo,
			@RequestParam("date") String Date) throws ClassNotFoundException, SQLException, IOException
	 {
		 number=trainNo;
		 ModelAndView mv=new ModelAndView();
		 System.out.println(Date);
		 LocalDate fDate = null;
		 try {
		            String[] dateArr = Date.split("-");
		            fDate = LocalDate.of(
		                    Integer.valueOf(dateArr[0]),
		                    Integer.valueOf(dateArr[1]),
		                    Integer.valueOf(dateArr[2]));
		            LocalDate currDate = LocalDate.now();
		            
		            train = TrainDAO.findTrain(trainNo);
		             if (train == null)
			        {
		            //	train = TrainDAO.findTrain(trainNo);
			        	System.out.println("Invalid Train Number");
			        	mv.setViewName("ShowTrainNewUser.jsp");
			        	mv.addObject("messaget1", "Select valid Train Number");
			        }

		             else  if(fDate.getYear() <  currDate.getYear()){
		              System.out.println("Invalid Date 1");
		              mv.setViewName("ShowTrainNewUser.jsp");
		            	mv.addObject("messaged1","Wrong Year");
		            } 
		            else if(fDate.getYear() ==  currDate.getYear() &&
		            fDate.getMonthValue() < currDate.getMonthValue())
		            {
		            	System.out.println("Invalid Date 2");
		            	mv.setViewName("ShowTrainNewUser.jsp");
		            	 mv.addObject("messaged2","Wrong Month");
		            }
		            else if (fDate.getYear() ==  currDate.getYear() &&
		                    fDate.getMonthValue() == currDate.getMonthValue() &&
		            fDate.getDayOfMonth() < currDate.getDayOfMonth())
		            {
		            	System.out.println("Invalid Date 3");
		            	mv.setViewName("ShowTrainNewUser.jsp");
		            	 mv.addObject("messaged3","Wrong Date");
		            }

 		            else{
			        	 System.out.println(train);
			        	mv.setViewName("NewBookingPage.jsp");
			            ticket=new Ticket1(fDate,train);
			        }
		       
			   
		 	}
		 catch (NumberFormatException  e) {
			 System.out.println(e);		 }
	      
		//return ticket;
		return mv;
	 }
	 
	 @RequestMapping("/adminadd")
	 public ModelAndView admin(@RequestParam("trainno") int trainNo,
				@RequestParam("trainname") String trainName,@RequestParam("source") String source,@RequestParam("destination") String destination,
				@RequestParam("price") double ticketPrice,@RequestParam("seats") int seats) throws SQLException, ClassNotFoundException{
		 ModelAndView mv = new ModelAndView();
		 try {
				
				Connection con = TrainDAO.getConnection();
				System.out.println("connected");
				 ps=con.prepareStatement("select * from trains where train_no=? ");
					ps.setInt(1,trainNo);
					rs=ps.executeQuery();
					
					if(rs.next())
					{
						System.out.println("Train no already exist.");
						mv.addObject("message1", "Train no  already exist !! Input New Train Number");
						mv.setViewName("Admin.jsp");
					}

					else{
				PreparedStatement ps = con.prepareStatement("insert into trains values(?,?,?,?,?,?)");
				
				ps.setInt(1,trainNo);
				ps.setString(2,trainName);
				ps.setString(3,source);
				ps.setString(4,destination);
				ps.setDouble(5,ticketPrice);
				ps.setInt(6,seats);
				int p = ps.executeUpdate();
				System.out.println(p);
				if(p==1)
				{
					System.out.println("Train added suceesfully");
					mv.addObject("message2", "Train Added Successfully");
					mv.setViewName("ShowTrains.jsp");
					
				}
				else
				{
					System.out.println("Train not added");
					mv.setViewName("Admin.jsp");
					mv.addObject("message2","Train not added !! Try Again");
				}
								
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
					mv.addObject("message1","Train Removed Successfully");
					mv.setViewName("ShowTrains.jsp");
					
				}
				else
				{
					System.out.println("Wrong Train Number");
					mv.addObject("message1", "Wrong Train no Entered");
					mv.setViewName("Admin.jsp");
				}
								
		 		}
		 catch (Exception e)
		 {
			 System.out.println(e);
		 }
		 
				
				
		 return mv;
		 
	 }
		 @RequestMapping("/forgot")
		 public ModelAndView forgotPassword(@RequestParam("email") String mail, @RequestParam
				 ("password1") String password,@RequestParam("securityans") String securityAns) throws SQLException
		 {
			 ModelAndView mv=new ModelAndView();
			 Connection con = TrainDAO.getConnection();
		
				
	/*	 ps=con.prepareStatement("select * from register where email=? ");
			ps.setString(1,mail);
			rs=ps.executeQuery();
				PreparedStatement ps1=con.prepareStatement("select * from register where securityans=?");
				 ps1.setString(1, securityAns);
			 ResultSet rs1=ps1.executeQuery();
			if(rs.next())
				{
					System.out.println("Email is there.");
								}
			else{
			mv.addObject("messageid", "E-mail not exist");
				mv.setViewName("NewForgot.jsp");

			}
				
			if(rs1.next())
					{
		
											

					}
			else{
				System.out.println("Security ans wrong ");
				mv.addObject("messageans", "Wrong security ans ");
			mv.setViewName("NewForgot.jsp");

			}

					else{*/
		ps=con.prepareStatement("Update register Set password=? where email=? and securityans=?");
			  ps.setString(1,password);
			  ps.setString(2,mail);
			  ps.setString(3,securityAns);
			//  Boolean check=ps.execute();
			  int i=ps.executeUpdate();
			  System.out.println(i);
			  if(i==1)
			  {
				  System.out.println("password change");
				  mv.setViewName("NewForgot.jsp");
				  mv.addObject("messagef","Password Change Successfully");
			  }
			  else{
				  System.out.println("wrong mail");
				  mv.setViewName("NewForgot.jsp");
				  mv.addObject("messageff", " Wrong Email Id or security question");
			  }
					//}
			return mv;
			 
		 }
	 
	

}