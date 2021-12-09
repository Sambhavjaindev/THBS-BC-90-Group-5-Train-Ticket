package com.torryharris.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TrainDAO {
   /* public static Connection con = DBConnection.getConnection();

    public static Train findTrain(int trainNo) throws SQLException,ClassNotFoundException{
       
    	Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from trains where train_no =" + trainNo);
        rs.next();
        return new Train(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
       }*/
    static private String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    static private String DB_URL = "jdbc:mysql://localhost:3306/databasetrain";
    static private String USERNAME = "root";
    static private String PASSWORD = "Sj_12345";
Class db;
    Connection con;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;


    public TrainDAO() throws ClassNotFoundException, SQLException {
        db = Class.forName(DRIVER_NAME);
        con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        stmt = null;
        pstmt = null;
        rs = null;
    }

    public static Train findTrain (int trainNo) throws SQLException, ClassNotFoundException {
        TrainDAO db = new TrainDAO();

        db.pstmt = db.con.prepareStatement("SELECT * FROM TRAINS WHERE TRAIN_NO = ?");
        db.pstmt.setInt(1, trainNo);
        db.rs  = db.pstmt.executeQuery();

        while(db.rs.next()){
            if(db.rs.getInt(1) == trainNo){
                return new Train(
                        db.rs.getInt(1),
                        db.rs.getString(2),
                        db.rs.getString(3),
                        db.rs.getString (4),
                        db.rs.getInt(5)
                );
            }
        }
        return null;
    }
}


