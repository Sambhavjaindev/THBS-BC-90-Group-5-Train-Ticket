package com.torryharris.model;


	
	import java.io.*;
	import java.sql.*;
	import java.time.LocalDate;
	import java.util.*;

	
	public class Ticket1 {
	    /*****VARIABLES****/
	   //static Random r = new Random();
	    //static private int counter = r.nextInt(899) + 100;
		static private int counter;
	    private String pnr;
	    private LocalDate travelDate;
	    private Train train;
	    private TreeMap<Passenger, Double> passengers;
	    int lCount;
	    ResultSet rs;

	    /*****CONSTRUCTOR
	     * @throws SQLException *****/
	    public Ticket1(LocalDate travelDate, Train train) throws SQLException {
	        this.travelDate = travelDate;
	        this.train = train;
	        pnr = genatatePNR();
	        passengers = new TreeMap<>();
	    }

	    public Ticket1() {

	    }
	    public int lastCounter() throws SQLException
	    {
	    	System.out.println("In last counter");
	    	int count=99;
	    	
	    	TrainDAO db=new TrainDAO();
	    	 db.ps = db.connection.prepareStatement("Select counter from tickets ORDER BY counter DESC LIMIT 1" );
		        
		    rs=  db.ps.executeQuery();
		      
		    	  if(rs.next())
		    	  {
		      	     System.out.println(rs.getInt(1));
		      	  counter=rs.getInt(1);
		    	  }
		    	
				
				else{
					System.out.println("No counter");
					counter=count;
			
				}
		    	  return counter;
			
	    	
	    }

	    /*****METHODS
	     * @throws SQLException ****/
	    private String genatatePNR() throws SQLException {
	        String s = String.valueOf(train.getSource().charAt(0));
	        String d = String.valueOf(train.getDestination().charAt(0));

	        String y = String.valueOf(travelDate.getYear());
	        String m = String.valueOf(travelDate.getMonthValue());
	        String day = String.valueOf(travelDate.getDayOfMonth());
	       lastCounter();

	        if(Integer.valueOf(m) < 10){ m = 0+m; }
	        if(Integer.valueOf(day) < 10){ day = 0+day; }

	        ++counter;

	        return s+d+"_"+y+m+day+"_"+counter;
	    }

	    private double calcPassengerFare(Passenger p) {
	        int age = p.getAge();
	        char gender = p.getGender();
	        double price = train.getTicketPrice();

	        if(age <= 12){
	            return .5 * price;
	        } else if(age >= 60) {
	            return .6 * price;
	        } else if(gender == 'F') {
	            return .75 * price;
	        } else {
	            return price;
	        }
	    }

	    public void addPassenger(String name, int age, char gender) throws SQLException, ClassNotFoundException {
	        Passenger p = new Passenger(name, age, gender);
	        double fare = calcPassengerFare(p);

	        // Add passenger to tree map
	        this.passengers.put(p, fare);

	     /*   // Add passenger to the db
	        TrainDAO db = new TrainDAO();
	        db.pstmt = db.con.prepareStatement("INSERT INTO PASSENGER VALUES (?, ?, ?)");
	        db.pstmt.setString(1, name);
	        db.pstmt.setInt(2, age);
	        db.pstmt.setString(3, String.valueOf(gender));
	        db.pstmt.execute();*/
	    }

	    private double calculateTotalTicketPrice() {
	        double sum = 0;
	        for(Map.Entry<Passenger, Double> entry : passengers.entrySet()){
	            Double value = entry.getValue();
	            sum += value;
	        }
	        return sum;
	    }

	    public StringBuilder generateTicket() {
	        String ticketStr =
	                "PNR          : " + pnr+"\n"+
	                "Train No     : " + String.valueOf(train.getTrainNo())+"\n"+
	                "Train Name   : " + train.getTrainName()+"\n"+
	                "From         : " + train.getSource()+"\n"+
	                "To           : " + train.getDestination()+"\n"+
	                "Travel Date  : " + travelDate+"\n\n"+
	                "Passengers:\n" +
	                "Name\t\t\tAge\t\t\tGender\t\t\tFare\n";

	        StringBuilder sb = new StringBuilder(ticketStr);

	        for(Map.Entry<Passenger, Double> entry : passengers.entrySet()){
	            Double value = entry.getValue();
	            Passenger p = entry.getKey();

	            String passengerStr = p.getName()+"\t\t\t"+p.getAge()+"\t\t\t"+p.getGender()+"\t\t\t"+value+"\n";
	            sb.append(passengerStr);
	        }

	        String tp = "Total Price: " + calculateTotalTicketPrice();
	        sb.append(tp);

	    //    System.out.println(sb.toString());

	        return sb;
	    }

	    public void writeTicket() throws SQLException, ClassNotFoundException, IOException {
	        // Add ticket to DB
	        TrainDAO db = new TrainDAO();
	       // db.getConnection();
	    
	       // System.out.println("database ticket");
	        
	        db.ps = db.connection.prepareStatement("INSERT INTO TICKETS VALUES (?)");
	        db.ps.setInt(1, counter);
	        System.out.println("Counter Added");
	        db. ps.execute();
	       
	        /*db.ps.setString(2, pnr);
	       db. ps.setString(3, String.valueOf(travelDate));
	       db. ps.setInt(4, train.getTrainNo());
	       db. ps.setString(5, train.getTrainName());
	       db.ps.setString(6, train.getSource());
	       db. ps.setString(7, train.getDestination());
	      db.  ps.setDouble(8, calculateTotalTicketPrice());
	       db. ps.execute();
	        System.out.println("Ticket write in database");*/
	        
	        

	        StringBuilder sb = generateTicket();
	        File dir = new File("G:\\Tickets");
	        dir.mkdir();

	        File f = new File("G:\\Tickets\\" + pnr);
	        f.createNewFile();

	        FileOutputStream fos = null;
	        BufferedOutputStream bos = null;

	        try {
	            fos = new FileOutputStream(f);
	            bos = new BufferedOutputStream(fos);
	            bos.write(String.valueOf(sb).getBytes());
	            System.out.println("ticket write");
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("File not Found");
	        } finally {
	            try {
	                if (bos != null) {
	                    bos.flush();
	                    bos.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            if(fos != null){
	                fos.close();
	            }
	        }
	   //     printTicket(counter);
	    }
	    /*
	    public void printTicket(int count) throws SQLException
	    {
	    	TrainDAO db = new TrainDAO();
	      //  db.getConnection();
	        System.out.println("count");
	        
	        db.ps = db.connection.prepareStatement("Select * from tickets where counter=?");
	        db.ps.setInt(1, count);
	    rs=  db.ps.executeQuery();
	      {
	    	  if(rs.next())
	      	  //    System.out.println(rs.getInt(1));
	      System.out.println(rs.getString(2));
	      System.out.println(rs.getString(3));
	      System.out.println(rs.getInt(4));
	      System.out.println(rs.getString(5));
	      System.out.println(rs.getString(6));
	      System.out.println(rs.getString(7));
	      System.out.println(rs.getDouble(8));
	     
	      }
	        System.out.println("Ticket in console");
	        lastCounter();
	    }*/

	    /*****SETTERS****/
	    public void setCounter(int counter) {
	        this.counter = counter;
	    }

	    public void setPnr(String pnr) {
	        this.pnr = pnr;
	    }

	    public void setTravelDate(LocalDate travelDate) {
	        this.travelDate = travelDate;
	    }

	    public void setTrain(Train train) {
	        this.train = train;
	    }

	    public void setPassengers(TreeMap<Passenger, Double> passengers) {
	        this.passengers = passengers;
	    }

	    /*****GETTERS****/
	    public int getCounter() {
	        return counter;
	    }

	    public String getPnr() {
	        return pnr;
	    }

	    public LocalDate getTravelDate() {
	        return travelDate;
	    }

	    public Train getTrain() {
	        return train;
	    }

	    public TreeMap<Passenger, Double> getPassengers() {
	        return passengers;
	    }
	}


