package View;


import Controller.RestaurantController;
import Products.Equipment.*;
import Products.EquipmentClass;
import Products.NonPerishableClass;
import Products.Non_Perishable.*;
import Products.Perishable.*;
import Products.PerishableClass;
import Products.Product;
import org.example.Database;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantView {


    private static final Scanner input = new Scanner(System.in);
    private static RestaurantController restaurantController = RestaurantController.Instance();

    public static void LoginInterface() {
        System.out.print("Welcome to Restaurant Stocking System\n\n");
        System.out.printf("%23s", "Login\n\n");
        System.out.print("Employee Name: ");
        String name = input.nextLine();
        System.out.print("Employee Password: ");
        String password = input.nextLine();

        // code to check if ID & password are valid
        boolean checkValidity = Database.checkForEmployeeValidity(name, password);
        if (checkValidity) {
            System.out.println("\n\n\n");
            EmployeeInterface();
        } else {
            System.out.println("Invalid input. Please try again.");
            System.out.println("\n\n\n");
            LoginInterface();
        }

    }

    public static void placeOrderInterface() {
        boolean condition = true;
        while (condition) {
            System.out.println("Choose product to add:");
            System.out.println("1. Perishable");
            System.out.println("2. Non-Perishable");
            System.out.println("3. Equipment");
            System.out.println("4. Exit");

            String choice = input.nextLine();

            HashMap<Product, Integer> map = new HashMap<>();

            switch (choice) {
                case "1" -> {
                    System.out.println("Perishable Products:");
                    System.out.println("Beef, Bread, Butter, Back");

                    String subchoice = input.nextLine();

                    if (subchoice.equals("4") || subchoice.equalsIgnoreCase("Back")) {
                        continue;
                    }
                    // Select the perishable item
                    PerishableFactory factory = new PerishableFactory();
                    PerishableClass perishable = factory.getProduct(subchoice);
                    if (perishable == null) {
                        System.out.println("Please enter a valid product.");
                        continue;
                    }
                    System.out.println("Enter quantity of perishable product");
                    int quantity = input.nextInt();
                    map.put(perishable, quantity);
                }

                case "2" -> {
                    System.out.println("Non-Perishable Products:");
                    System.out.println("Brown Rice, Bucatini, Coca Cola, Back");
                    String subchoice = input.nextLine();

                    if (subchoice.equals("4") || subchoice.equalsIgnoreCase("Back")) {
                        continue;
                    }
                    Non_PerishableFactory factory = new Non_PerishableFactory();
                    NonPerishableClass nonPerishable = factory.getProduct(subchoice);
                    if (nonPerishable == null) {
                        System.out.println("Please enter a valid product.");
                        continue;
                    }
                    System.out.println("Enter quantity of non perishable product");
                    int quantity = input.nextInt();
                    map.put(nonPerishable, quantity);
                }

                case "3" -> {
                    System.out.println("Equipment Products:");
                    System.out.println("Apron, Bowl, Cloth, Back");

                    String subchoice = input.nextLine();
                    if (subchoice.equals("4") || subchoice.equalsIgnoreCase("Back")) {
                        continue;
                    }
                    EquipmentFactory factory = new EquipmentFactory();
                    EquipmentClass equipment = factory.getProduct(subchoice);
                    if (equipment == null) {
                        System.out.println("Please enter a valid product.");
                        continue;
                    }
                    System.out.println("Enter quantity of non perishable product");
                    int quantity = input.nextInt();
                    map.put(equipment, quantity);
                }

                case "4" -> condition = false;

                default -> System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static void orderOperationsInterface() {
        boolean condition = true;
        while (condition) {
            System.out.printf(" \n\n%12s %12s %12s %12s", "(1) Place Order", "(2) View Orders", "(3) Remove Order", "(4) Back \n\n");
            System.out.print("Action: ");
            String subtask = input.nextLine();
            switch (subtask) {
                case "1" -> placeOrderInterface();

                case "2" -> restaurantController.receiveAllOrderInfo();

                case "3" -> {
                    restaurantController.receiveAllOrderInfo();
                    System.out.println("What order would you like to cancel?");
                    String orderID = input.nextLine();
                }

                case "4" -> condition = false;

                default -> System.out.println("ERROR: Invalid task choice");
            }
        }
    }

    public static void EmployeeInterface() {
        System.out.println("\n");
        System.out.printf("%35s", "Welcome Employee \n\n");
        System.out.printf("%35s", "Choose a task to perform");
        boolean condition = true;
        while (condition) {
            System.out.printf("\n\n%12s %12s %12s %12s %12s",
                    "(1) Orders", "(2) View Stock", "(3) View Deliveries", "(4) View Products Offered", "(5) Exit\n\n");
            System.out.print("Action: ");
            String task = input.nextLine();

            switch (task) {
                case "1" -> orderOperationsInterface();

                case "2" -> Database.viewReceiptTable(); // view stock

                case "3" -> Database.viewDeliveryTable();

                case "4" -> Database.viewProductTable();

                case "5" -> {
                    System.out.println("Exiting program...");
                    condition = false;
                }

                default -> System.out.println("ERROR: Invalid task choice");
            }
        }
    }

    public static void main(String[] args) {
        LoginInterface();
    }

}
