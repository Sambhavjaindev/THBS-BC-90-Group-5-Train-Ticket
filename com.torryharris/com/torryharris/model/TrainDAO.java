package com.torryharris.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TrainDAO {
  
    public static Connection connection;
    public static PreparedStatement ps;

    public static Connection getConnection() throws SQLException  {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetrain",
                    "root", "Sj_12345");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Train findTrain (int trainNo) throws SQLException, ClassNotFoundException {
     //   TrainDAO db = new TrainDAO();
        getConnection();
  
        
        
		System.out.println("connected DAO class");
		
        ps=connection.prepareStatement("SELECT * FROM TRAINS WHERE TRAIN_NO = ?");
        ps.setInt(1, trainNo);
       ResultSet rs  = ps.executeQuery();

        while(rs.next()){
            if(rs.getInt(1) == trainNo){
                return new Train(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString (4),
                        rs.getInt(5)
                );
            }
        }
        return null;
    }
}


