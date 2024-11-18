package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    // create Students table
    public static void createStudentTable() {
        String sql = " create table if not exists Employees (\n"
                + " id integer primary key, \n"
                + " name text not null, \n"
                + " empPassword text not null\n"
                + " age integer check (age >= 14)\n"
                + " Position text not null\n"
                + " empEmail text not null\n"
                + " empPhoneNumber text not null\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" students table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {


    }
}
