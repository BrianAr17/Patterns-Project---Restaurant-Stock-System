package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connect() {
        String url = "jdbc:sqlite:Restaurant.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println(" Connection to Sqlite has been established");
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {


    }
}
