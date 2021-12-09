package com.torryharris.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

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
}
