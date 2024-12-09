package org.example;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;

public class Database {

 ;
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

    // create Employee table =============================================================================
    public static void createEmployeeTable() {
        String sql = " create table if not exists Employees (\n"
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
            System.out.println(" Employee table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertEmployees(String name, String password,int age,String position, String email,String phoneNumber) {
        String sql = " insert into Employees (name,empPassword,age,Position,empEmail,empPhoneNumber) values (?, ?,?, ?,?, ?)";
        try(Connection conn= connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setInt(3, age);
            pstmt.setString(4, position);
            pstmt.setString(5, email);
            pstmt.setString(6, phoneNumber);
            pstmt.executeUpdate();
            System.out.println("Employee data has been added successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void displayEmployees() {
        String sql = "select * from Employees";
        try (Connection conn = connect(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Employees :");
            while (rs.next()) {
                System.out.println("Id : " + rs.getInt("id") +
                        "\nName: " + rs.getString("name") +
                        "\nPassword : " + rs.getInt("empPassword")+
                        "\nAge: " + rs.getString("age") +
                        "\nPosition: " + rs.getString("Position") +
                        "\nEmail: " + rs.getString("empEmail") +
                        "\nPhoneNumber: " + rs.getString("empPhoneNumber"));
                System.out.println("\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//     create Order table =============================================================================
    public static void createOrderTable() {
        LocalDate currentDate = LocalDate.now();
        String sql = "create table if not exists 'Order'(\n" // modify columns
                + " orderId integer primary key, \n"
                + " status text not null check(status = 'Pending' OR status = 'Declined' OR status = 'Approved'), \n"
                + " dateSent date not null check( dateSent <= dateArrived AND dateSent >= '"+currentDate+"'),\n"
                + " dateArrived date not null check (dateArrived >= dateSent)\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Order table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    // create Delivery tools table
    public static void createDeliveryTable() {
        LocalDate currentDate = LocalDate.now();
        String sql = " create table if not exists Delivery (\n"
                + " deliveryId integer primary key, \n"
                + " orderId integer not null, \n"
                + " status text not null check(status = 'Pending' OR status = 'Preparing_Order' OR status = 'Approved'),\n"
                + " dateShipped date  not null check(dateShipped <= dateReceived AND dateShipped >= '"+currentDate+"'),\n" //TODO Check if there is a way within SQLite to return the machines date
                + " dateReceived date not null check(dateReceived >= dateShipped AND dateShipped >=  '"+currentDate+"'),\n"
                + " foreign key (orderId) references 'Order' (orderId) on delete set null\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Delivery table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // create Deliverer table =============================================================================
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

    // create Products Records table =============================================================================
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

    // create Receipt table =============================================================================
    public static void createReceiptTable(){
        String sql = " create table if not exists Receipt (\n"
                +" receiptId integer primary key, \n"
                +" orderId integer not null, \n"
                +" productId integer not null,\n"
                +" quantity integer not null check( quantity > 0),\n"
                +" foreign key (orderId) references Order (orderId) on delete set null,\n"
                +" foreign key (productId) references Products (productId) on delete set null \n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Receipt table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Methods ================================================================================
    public static boolean checkForEmployeeValidity(String name, String password){
        String sql = "select 1 " +
                "from Employees " +
                "where name LIKE ? ANd empPassword LIKE ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))

        {
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("Input valid");
                return true;
            }
            else{
                System.out.println("This user does not exists");
                return false;
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

        public static void main(String[] args) {
           createOrderTable();
           createDeliveryTable();
        }
    }








