package org.example;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;

import Model.Order;
import Products.Equipment.*;
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


public static void fullInsertOrder(Order order) {
    Date currentDate = Date.valueOf(r); // to fix
    String sql = "INSERT INTO `Order` (status,dateArrived,dateSent) VALUES (?, ?, ?)";

    try (Connection conn = connect();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, order.getStatus());
        pstmt.setDate(2, order.getDateSent());
        pstmt.setDate(3, order.getDateReceived());
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

    public static void insertIntoRestaurant(){
        String sql = "select * from Receipts";

        try(Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            int lastID = 0;
            HashMap<Product, Integer> map = new HashMap<>();
            while(rs.next()) {
                int orderID = rs.getInt(2);
                int productID = rs.getInt(3);
                Product product = new Product();
                if (productID == 1) {
                    product = new Apron();
                }
                else if (productID == 2) {
                    product = new Bowl();
                }
                else if (productID == 3) {
                    product = new Cloth();
                }
                else if (productID == 4) {
                    product = new DishWasher();
                }
                else if (productID == 5) {
                    product = new Fork();
                }
                else if (productID == 6) {
                    product = new FryingPan();
                }
                else if (productID == 7) {
                    product = new Grill();
                }
                else if (productID == 8) {
                    product = new HandMixer();
                }
                else if (productID == 9) {
                    product = new HeatLamp();
                }
                else if (productID == 10) {
                    product = new IceMachine();
                }
                else if (productID == 11) {
                    product = new Knife();
                }
                else if (productID == 12) {
                    product = new Microwave();
                }
                else if (productID == 13) {
                    product = new Mixer();
                }
                else if (productID == 14) {
                    product = new Oven();
                }
                else if (productID == 15) {
                    product = new Plate();
                }
                else if (productID == 16) {
                    product = new SaucePan();
                }
                else if (productID == 17) {
                    product = new Skillet();
                }
                else if (productID == 18) {
                    product = new Spoon();
                }
                else if (productID == 19) {
                    product = new WashingMachine();
                }
                else if (productID == 20) {
                    product = new WineOpener();
                }
                else if (productID == 21) {
                    product = new BrownRice();
                }
                else if (productID == 22) {
                    product = new Bucatini();
                }
                else if (productID == 23) {
                    product = new CocaCola();
                }
                else if (productID == 24) {
                    product = new DrPepper();
                }
                else if (productID == 25) {
                    product = new Fanta();
                }
                else if (productID == 26) {
                    product = new Fettuccini();
                }
                else if (productID == 27) {
                    product = new Linguini();
                }
                else if (productID == 28) {
                    product = new OliveOil();
                }
                else if (productID == 29) {
                    product = new Pepsi();
                }
                else if (productID == 30) {
                    product = new Ravioli();
                }
                else if (productID == 31) {
                    product = new Rigatoni();
                }
                else if (productID == 32) {
                    product = new Spaghetti();
                }
                else if (productID == 33) {
                    product = new Sprite();
                }
                else if (productID == 34) {
                    product = new TomatoSauce();
                }
                else if (productID == 35) {
                    product = new WhiteRice();
                }
                else if (productID == 36) {
                    product = new Beef();
                }
                else if (productID == 37) {
                    product = new Bread();
                }
                else if (productID == 38) {
                    product = new Butter();
                }
                else if (productID == 39) {
                    product = new Chicken();
                }
                else if (productID == 40) {
                    product = new Egg();
                }
                else if (productID == 41) {
                    product = new Goat();
                }
                else if (productID == 42) {
                    product = new IcebergLettuce();
                }
                else if (productID == 43) {
                    product = new Lemon();
                }
                else if (productID == 44) {
                    product = new Oregano();
                }
                else if (productID == 45) {
                    product = new Pork();
                }
                else if (productID == 46) {
                    product = new Potato();
                }
                else if (productID == 47) {
                    product = new RomanLettuce();
                }
                else if (productID == 48) {
                    product = new Salmon();
                }
                else if (productID == 49) {
                    product = new Tomato();
                }
                else if (productID == 50) {
                    product = new Tuna();
                }
                int quantity = rs.getInt(4);
                if (orderID == lastID) {
                    map.put(product, quantity);
                }
                else {
                    Order order = new Order(Integer.toString(orderID), map);
                    // Kishaan you gotta create the products table first so that I can assign the order values based on id to this order
                    map.clear();
                    map.put(product, quantity);
                }
                lastID = orderID;
            }
        }
        catch (SQLException e)
        {
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
                + "productType text not null check( productType = 'Perishable' OR productType = 'Non-Perishable' OR productType = 'Equip'),"
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
        String sql = "INSERT into Products (productName,productDesc,pricePerUnit,productType,productQuantity) values (?,?,?,?)";

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
            System.out.printf("%-15s %-20s %-35s %-20s %-20s %-20s" ,"Product Id","Name of Product","Product Desc","Price Per Unit","Product Type","Product Quantity\n");
            while(rs.next()){
                System.out.printf("%-15s %-20s %-35s %-20s %-20s %-20s",rs.getInt("productId"),rs.getString("productName"),rs.getString("productDesc"),
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
//        createEmployeeTable();
        createOrderTable();
//        createDeliveryTable();
//        createDelivererTable();
//        createProductsTable();
//        createReceiptTable();
//
//            insertEmployees("Kishaan", "1234", 18, "Admin", "kishaan@gmail.com", "555-555-5555");
//            insertEmployees("Brian", "1234", 19, "Admin", "brian@gmail.com", "555-555-5557");
//            insertEmployees("Andrew", "123456", 19, "Restaurant Owner", "andrew@gmail.com", "555-555-5556");
//            insertEmployees("Danat", "1234567", 19, "Restaurant Owner", "danat@gmail.com", "555-555-5554");
//            insertEmployees("Nigel", "nigeria", 69, "CEO", "nigel@gmail.com", "555-555-5559");

            viewOrderTable();
//            viewDeliveryTable();
//            viewDelivererTable();
//            viewProductTable();
//            viewReceiptTable();
//            displayEmployees();
        }
    }