package com.torryharris.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasetrain",
                    "root", "Sj_12345");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
