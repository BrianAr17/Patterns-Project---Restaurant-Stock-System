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
                + " empPassword text not null,\n"
                + " age integer check (age >= 14),\n"
                + " Position text not null,\n"
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

    // create Order table
    public static void createOrderTable() {
        String sql = " create table if not exists Order (\n" // modify columns
                + " orderId integer primary key, \n"
                + " status text not null, \n" //TODO assure that the status column will have the same values of chosen ENUMS for status of deliveries
                + " dateSent date not null check( dateSent <= dateArrived AND dateSent >= currentDate),\n" //TODO Check if there is a way within SQLite to return the machines date
                + " dateArrived data not null check (dateArrived >= dateSent)\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("  Order table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create Delivery tools table
    public static void createDeliveryTable() {
        String sql = " create table if not exists Delivery (\n"
                + " DeliveryId integer primary key, \n"
                + " orderId integer not null, \n"
                + " status text not null,\n" //TODO assure that the status column will have the same values of chosen ENUMS for status of deliveries
                + " dateShipped date  not null check(dateShipped <= dateReceived AND dateShipped >= currentDate),\n" //TODO Check if there is a way within SQLite to return the machines date
                + " dateReceived date not null check(dateReceived >= dateShipped AND dateShipped >= currentDate),\n"
                + " foreign key integer (orderId) references Order (orderId) on delete set null\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Delivery table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create Deliverer table
    public static void createDelivererTable() {
        String sql = " create table if not exists Deliverer (\n"
                + " delivererID integer primary key, \n"
                + " name text not null \n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Deliverer table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create Products Records table
    public static void createProductsTable() {
        String sql = " create table if not exists Products (\n"
                + " productId integer primary key, \n"
                + " productName text not null, \n"
                + " productDesc text not null,\n"
                + " pricePerUnit double not null check( pricePerUnit > 0),\n"
                + " productType text not null check( productType = Persh OR productType = Non-Persh OR productType = Equip)\n" //TODO change the check variable to match the actual types of products
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Products table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }





    public static void main(String[] args) {


    }
}
