package org.example;

import javax.xml.crypto.Data;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;

public class Database {

    public static LocalDate localeDate = LocalDate.now();

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
                        "\nPassword : " + rs.getString("empPassword")+
                        "\nAge: " + rs.getInt("age") +
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
                + " dateSent date not null check( dateSent <= '"+currentDate+"'),\n"
                + " dateArrived date check (dateArrived >= dateSent)\n"
                + ");";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Order table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertIntoOrderTable(String status){
        Date currentDate = Date.valueOf(localeDate);
        String sql = "INSERT into 'Order' (status,dateSent) values (?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,status);
            pstmt.setDate(2,currentDate);
            pstmt.executeUpdate();
            System.out.println("Order has been sent and has arrived");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


public static void fullInsertOrder(String status, Date arrivedDate) {
    Date currentDate = Date.valueOf(localeDate);

    String sql = "INSERT INTO `Order` (status,dateArrived,dateSent) VALUES (?, ?, ?)";

    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, status);
        pstmt.setDate(2, arrivedDate);
        pstmt.setDate(3, currentDate);
        pstmt.executeUpdate();
        System.out.println("Order has been sent and has arrived");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}

    public static void viewOrderTable(){
        String sql = "SELECT * FROM 'Order'";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            System.out.printf("%52s","Order Table");
            System.out.println();
            System.out.printf("%-15s %-20s %-20s %-20s","Order Id","Order Status","Order Sent Date","Order Arrival Date \n");
            while(rs.next()){
                System.out.printf("%-15s %-20s %-20s %-20s",rs.getInt("orderId"),rs.getString("status"),rs.getDate("dateSent"),rs.getDate("dateArrived"));
                System.out.println();
            }
            System.out.println("\n\n");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    // create Delivery tools table ====================================================================================
    public static void createDeliveryTable() {
        LocalDate currentDate = LocalDate.now();
        String sql = " create table if not exists Delivery (\n"
                + " deliveryId integer primary key, \n"
                + " orderId integer not null, \n"
                + " status text not null check(status = 'Pending' OR status = 'Preparing_Order' OR status = 'Approved'),\n"
                + " dateShipped date not null check(dateShipped >= '"+currentDate+"'),\n"
                + " dateReceived date check(dateReceived >= dateShipped AND dateShipped >=  '"+currentDate+"'),\n"
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
    public static void insertIntoDeliveryTable(int orderId,String status,Date dateShipped,Date dateArrived){
        String sql = "INSERT into Deliver (orderId,status,dateShipped,dateArrived) values (?,?,?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,orderId);
            pstmt.setString(2,status);
            pstmt.setDate(3,dateShipped);
            pstmt.setDate(4,dateArrived);
            pstmt.executeUpdate();
            System.out.println("Delivery has been sent and has arrived");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void viewDeliveryTable(){
        String sql = "SELECT * FROM Delivery";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            System.out.printf("%55s","Delivery Table");
            System.out.println();
            System.out.printf("%-15s %-20s %-20s %-20s %-20s","DeliveryId","OrderId","Status","Delivery Shipped","Delivery Received  \n");
            while(rs.next()){
                System.out.printf("%-15s %-20s %-20s %-20s %-20s",rs.getInt("order_id"),rs.getString("status"),rs.getDate("dateSent"),rs.getDate("dateArrived"));
                System.out.println();
            }
            System.out.println("\n\n");
        }
        catch (SQLException e){
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
    public static void insertIntoDelivererTable(String name){
        String sql = "INSERT into Deliverer (name) values (?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,name);
            System.out.println("Deliverer has been registered");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void viewDelivererTable(){
        String sql = "Select * from Deliverer";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            System.out.printf("%22s","Deliverer Table");
            System.out.println();
            System.out.printf("%-15s %-20s" ,"Deliverer Id","Deliverer Name\n");
            while(rs.next()){
                System.out.printf("%-10s %-25s",rs.getInt("delivererID"),rs.getString("name"));
                System.out.println();
            }
            System.out.println("\n\n");
        }
        catch (SQLException e){
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
                + " productType text not null check( productType = 'Perishable' OR productType = 'Non-Perishable' OR productType = 'Equip')\n" //TODO change the check variable to match the actual types of products
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Products table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertIntoProductsTable(String productName,String productDesc,double pricePerUnit,String productType)
    {
        String sql = "INSERT into Products (productName,productDesc,pricePerUnit,productType) values (?,?,?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,productName);
            pstmt.setString(2,productDesc);
            pstmt.setDouble(3,pricePerUnit);
            pstmt.setString(4,productType);
            System.out.println("Product has been added has been registered");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void viewProductTable(){
        String sql = "Select * from Products";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            System.out.printf("%60s","Products Table");
            System.out.println();
            System.out.printf("%-15s %-20s %-35s %-20s %-20s" ,"Product Id","Name of Product","Product Desc","Price Per Unit","Product Type\n");
            while(rs.next()){
                System.out.printf("-15s %-20s %-35s %-20s %-20s",rs.getInt("productId"),rs.getString("productName"),rs.getString("productDesc"),
                        rs.getDouble("pricePerUnit"),rs.getString("productType"));
                System.out.println();
            }
            System.out.println("\n\n");
        }
        catch (SQLException e){
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
                +" foreign key (orderId) references 'Order' (orderId) on delete set null,\n"
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

    public static void insertIntoReceiptTable(int orderId,int productId,int quantity)
    {
        String sql = "INSERT into Receipt (orderId,productId,quantity) values (?,?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,orderId);
            pstmt.setInt(2,productId);
            pstmt.setInt(3,quantity);
            System.out.println("Order Receipt has been Generated");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void viewReceiptTable(){
        String sql = "Select * from Receipt";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            System.out.printf("%37s","Receipt Table");
            System.out.println();
            System.out.printf("%-15s %-20s %-20s %-20s" ,"Receipt Id","Order Id","Product Id","Quantity\n");
            while(rs.next()){
                System.out.printf("-15s %-20s %-20s %-20s ",rs.getInt("receiptId"),rs.getInt("orderId"),rs.getInt("productId"),
                        rs.getInt("quantity"));
                System.out.println();
            }
            System.out.println("\n\n");
        }
        catch (SQLException e){
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
        createEmployeeTable();
        createOrderTable();
        createDeliveryTable();
        createDelivererTable();
        createProductsTable();
        createReceiptTable();

        viewOrderTable();
        viewDeliveryTable();
        viewDelivererTable();
        viewProductTable();
        viewReceiptTable();

        }
    }
















