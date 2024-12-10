package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Model.Order;
import Products.AbstractProductFactory;
import Products.Equipment.*;
import Products.Factory;
import Products.Non_Perishable.*;
import Products.Perishable.*;
import Products.Product;

public class Database {

    public static LocalDate localeDate = LocalDate.now();

    private static Connection connect() {
        String url = "jdbc:sqlite:RestaurantManagement.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
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
        String sql = " insert into Employees (name,empPassword,age,Position,empEmail,empPhoneNumber) values (?, ?, ?, ?, ?, ?)";
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
            System.out.printf("\n%90s","Employee Table");
            System.out.println("\n");
            System.out.printf("%-20s %-25s %-25s %-22s %-25s %-30s %-20s","Employee ID","Employee Name","Employee Password ","Employee Age","Employee Position","Employee Email","Employee Phone Number\n");
            while (rs.next()) {
                System.out.printf("%-20s %-25s %-25s %-22s %-25s %-30s %-20s",rs.getInt("id"),rs.getString("name"),rs.getString("empPassword"),rs.getInt("age"),rs.getString("Position"),
                                rs.getString("empEmail"),rs.getString("empPhoneNumber"));
                System.out.println();
            }
            System.out.println("\n\n");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//     create Order table =============================================================================
    public static void createOrderTable() {

        LocalDate currentDate = LocalDate.now();
        String sql = "create table if not exists 'Order'(\n" // modify columns
                + " orderId integer primary key, \n"
                + " status text not null check(status = 'Pending' OR status = 'Cancelled' OR status = 'Approved'), \n"
                + " dateSent date not null check( dateSent <= '" + currentDate + "'),\n"
                + " dateArrived date check (dateArrived >= dateSent)\n"
                + ");";

        try (Connection conn = connect();
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


    public static void fullInsertOrder(Order order) {
        LocalDate currentDate = LocalDate.now();

        String sql = "INSERT INTO `Order` (status,dateArrived,dateSent) VALUES (?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, order.getStatus());
            pstmt.setDate(2, Date.valueOf(order.getDateSent()));
            pstmt.setDate(3, Date.valueOf(order.getDateReceived()));
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

    public static void removeOrder(int orderId, String status) {
        String verification = "SELECT status FROM 'Order' WHERE orderId = ?";
        String updateSql = "UPDATE 'Order' SET status = ? WHERE orderId = ?";
        String deleteSql = "DELETE FROM 'Order' WHERE orderId = ?";

        try (Connection conn = connect();
             PreparedStatement selectPstmt = conn.prepareStatement(verification);
             PreparedStatement updatePstmt = conn.prepareStatement(updateSql);
             PreparedStatement deletePstmt = conn.prepareStatement(deleteSql)) {
            conn.setAutoCommit(false);

            selectPstmt.setInt(1, orderId);
            ResultSet rs = selectPstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Order Id of " + orderId + " does not exist");
                conn.commit();  // Commit to complete the transaction
            } else {
                String currentStatus = rs.getString("status");
                if (currentStatus.equals("Cancelled") || currentStatus.equals("Approved")) {
                    System.out.println("It is too late to cancel your order.");
                    conn.commit();  // Commit to complete the transaction
                } else {
                    // Update the status
                    updatePstmt.setString(1, status);
                    updatePstmt.setInt(2, orderId);
                    updatePstmt.executeUpdate();
                    System.out.println("Order has been successfully updated to " + status);

                    // Optional: Introduce a delay before deletion
                    Thread.sleep(5000);

                    // Delete the order
                    deletePstmt.setInt(1, orderId);
                    deletePstmt.executeUpdate();
                    System.out.println("Order has been successfully cancelled and removed.");
                    conn.commit();  // Commit the transaction
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }
    }



    // create Delivery tools table ====================================================================================
    public static void createDeliveryTable() {
        LocalDate currentDate = LocalDate.now();
        String sql = " create table if not exists Delivery (\n"
                + "deliveryId integer primary key, \n"
                + "orderId integer not null, \n"
                + "status text not null check(status = 'Cancelled' OR status = 'Lost' OR status = 'Delivered'),\n"
                + "dateShipped date not null check(dateShipped >= '"+currentDate+"'),\n"
                + "dateReceived date check(dateReceived >= dateShipped AND dateShipped >=  '"+currentDate+"'), \n"
                +"deliveryCompany text not null,\n"
                + " foreign key (orderId) references 'Order' (orderId) on delete set null\n"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Delivery table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void insertIntoDeliveryTable(int orderId,String status,Date dateShipped,Date dateArrived,String company){
        String sql = "INSERT into Delivery (orderId,status,dateShipped,dateArrived,deliveryCompany) values (?,?,?,?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,orderId);
            pstmt.setString(2,status);
            pstmt.setDate(3,dateShipped);
            pstmt.setDate(4,dateArrived);
            pstmt.setString(5,company);
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
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-30s","DeliveryId","OrderId","Status","Delivery Shipped","Delivery Received","Delivery Company  \n");
            while(rs.next()){
                System.out.printf("%-15s %-20s %-20s %-20s %-20s %-30s",rs.getInt("deliveryId"),rs.getInt("order_id"),rs.getString("status"),rs.getDate("dateSent"),rs.getDate("dateArrived"),rs.getString("deliveryCompany"));
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
        String sql = "create table if not exists Products (\n"
                + "productId integer primary key, \n"
                + "productName text not null, \n"
                + "productDesc text not null,\n"
                + "pricePerUnit double not null check( pricePerUnit > 0),\n"
                + "productType text not null check( productType = 'Perishable' OR productType = 'Non-Perishable' OR productType = 'Equip')," +
                " productQuantity integer not null check(productQuantity > 0)"
                + ");";
        try(Connection conn = connect();
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println(" Products table created successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertIntoProductsTable(String productName,String productDesc,double pricePerUnit,String productType,int quantity)
    {
        String sql = "INSERT into Products (productName,productDesc,pricePerUnit,productType,productQuantity) values (?,?,?,?,?)";

        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1,productName);
            pstmt.setString(2,productDesc);
            pstmt.setDouble(3,pricePerUnit);
            pstmt.setString(4,productType);
            pstmt.setInt(5,quantity);
            pstmt.executeUpdate();
            System.out.println("Product has been added has been registered");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void viewProductTable(){
        String sql = "SELECT * FROM Products";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            System.out.printf("%60s","Products Table");
            System.out.println();
            System.out.printf("%-15s %-20s %-35s %-20s %-20s %-20s" ,"Product Id","Name of Product","Product Desc","Price Per Unit","Product Type","Product Quantity\n");
            while(rs.next()){
                System.out.printf("%-15s %-20s %-35s %-20s %-20s %-20s",rs.getInt("productId"),rs.getString("productName"),rs.getString("productDesc"),
                        rs.getDouble("pricePerUnit"),rs.getString("productType"),rs.getInt("productQuantity"));
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

    public static void insertIntoReceiptTable(int orderId, int productId, int quantity)
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

    public static List<Order> fetchOrdersByStatus(String status) {
        String sql = """
                      SELECT * FROM 'Order'
                      WHERE Status = ?;
                      """;
        List<Order> allOrdersSent = new ArrayList<>();
        try (PreparedStatement pstmt = connect().prepareStatement(sql)) {
            pstmt.setString(1, status);
            try (ResultSet rs = pstmt.executeQuery()) {
                // Loop over all orders sent
                while (rs.next()) {
                    int orderId = rs.getInt("orderId");
                    String orderStatus = rs.getString("status");
                    LocalDate dateSent = rs.getDate("dateSent").toLocalDate();
                    LocalDate dateArrived = rs.getDate("dateArrived").toLocalDate();
                    HashMap<Product, Integer> orderProducts = getOrderProducts(orderId);
                    Order order = new Order(orderId, orderProducts);
                    order.setDateSent(dateSent);
                    order.setDateReceived(dateArrived);

                    // Add to list
                    allOrdersSent.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allOrdersSent;
    }

    public static HashMap<Product, Integer> getOrderProducts(int orderId) {
        String sql = "SELECT * FROM Receipt WHERE orderID = ?";
        HashMap<Product,Integer> map = new HashMap<>();
        try(PreparedStatement pstmt = connect().prepareStatement(sql)) {
                pstmt.setInt(1,orderId);
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()){
                        int productId = rs.getInt("productId");
                        Product product = getProductById(productId);
                        int quantity = rs.getInt("quantity");
                        map.put(product, quantity);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return map;
    }

    public static Product getProductById(int productId) {
        String sql = """
                      SELECT * FROM Products
                      WHERE productId = ?;
                      """;
        Product product = null;
        try (PreparedStatement pstmt = connect().prepareStatement(sql)) {
            pstmt.setInt(1, productId);

            // Get the product result set
            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.next()) {
                    return product;
                }
                // Get all the data from the product
                String productName = rs.getString("productName");
                String productType = rs.getString("productType");

                // Generate the product using factories
                AbstractProductFactory abstractFactory = new AbstractProductFactory();
                Factory specificFactory = abstractFactory.getFactory(productType);
                product = specificFactory.getProduct(productName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    // Methods ================================================================================
    public static boolean checkForEmployeeValidity(String name, String password){
        String sql = "select 1 " +
                "from Employees " +
                "where name LIKE ? AND empPassword LIKE ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
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
            createProductsTable();
            createOrderTable();
            createDeliveryTable();
            createDelivererTable();
            createReceiptTable();

            insertEmployees("Kishaan", "1234", 18, "Admin", "kishaan@gmail.com", "555-555-5555");
            insertEmployees("Brian", "1234", 19, "Admin", "brian@gmail.com", "555-555-5557");
            insertEmployees("Andrew", "123456", 19, "Restaurant Owner", "andrew@gmail.com", "555-555-5556");
            insertEmployees("Danat", "1234567", 19, "Restaurant Owner", "danat@gmail.com", "555-555-5554");
            insertEmployees("Nigel", "nothing", 69, "CEO", "nigel@gmail.com", "555-555-5559");
//
            insertIntoProductsTable("Bread","It's bread",2.50,"Perishable",20);
            insertIntoProductsTable("Beef","meaty beef",2.50,"Perishable",50);
            insertIntoProductsTable("Butter","ist butter",2.50,"Perishable",15);
            insertIntoProductsTable("Brown Rice","its rice but brown",4.50,"Non-Perishable",20);
            insertIntoProductsTable("Bucatini","like linguini",5.0,"Non-Perishable",40);
            insertIntoProductsTable("CocaCola","second best to Pepsi",2.99,"Non-Perishable",50);
            insertIntoProductsTable("Apron","keeps your clothes clean",9.99,"Equip",10);
            insertIntoProductsTable("Bowl","like a plate but rounder",4.99,"Equip",15);
            insertIntoProductsTable("Cloth","cleans stuff",1.20,"Equip",30);

            viewOrderTable();
            viewDeliveryTable();
            viewDelivererTable();
            viewProductTable();
            viewReceiptTable();
            displayEmployees();
        }
    }