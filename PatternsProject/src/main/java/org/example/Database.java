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

    // create Employee table
    public static void createEmployeeTable() {
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
            System.out.println(" Employee table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create Perishable Food table
    public static void createPerishableFoodsTable() {
        String sql = " create table if not exists PerishableFoods (\n" // modify columns
                + " foodId integer primary key, \n"
                + " foodName text not null, \n"
                + " Quantitu integer not null,\n"
                + " Food_Desc text not null,\n"
                + " Price/Lbs double not null,\n"
                + " Supplier text not null,\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("  Perishable Food table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create Kitchen tools table
    public static void createKitchenToolsTable() {
        String sql = " create table if not exists KitchenTools (\n"
                + " id integer primary key, \n"
                + " name text not null, \n"
                + " empPassword text not null,\n"
                + " age integer check (age >= 14),\n"
                + " Position text not null,\n"
                + " empEmail text not null,\n"
                + " empPhoneNumber text not null\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Kitchen Tools table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create Order Records table
    public static void createOrderRecordsTable() {
        String sql = " create table if not exists OrderRecords (\n"
                + " id integer primary key, \n"
                + " ProductName text not null, \n"
                + " ProductDesc text not null,\n"
                + " Order_Date Date check (Order_Date <= DATE('now')),\n"
                + " Arrival_Date Date not null check(Arrival_Date > Order_Date),\n"
                + " OrderStatus text not null  check( OrderStatus = PENDING OR OrderStatus = RECEIVED OR Order_Status = DELIVERED)\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Order Records table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {


    }
}
