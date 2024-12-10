package View;


import Controller.RestaurantController;
import org.example.Database;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantView {

    private static final Scanner input = new Scanner(System.in);
    private RestaurantController restaurantController = RestaurantController.Instance();

    public static void LoginInterface(){
        System.out.print("Welcome to Restaurant Stocking System\n\n");
        System.out.printf("%23s","Login\n\n");
        System.out.print("Employee Name: ");
        String name = input.nextLine();
        System.out.print("Employee Password: ");
        String password = input.nextLine();

        // code to check if ID & password are valid
        boolean checkValidity = Database.checkForEmployeeValidity(name,password);
        if (checkValidity){
            System.out.println("\n\n\n");
            EmployeeInterface();
        }
        else {
            System.out.println("Invalid input. Please try again.");
            System.out.println("\n\n\n");
            LoginInterface();
        }

    }

    public static void EmployeeInterface(){
        System.out.println("\n");
        System.out.printf("%35s","Welcome Employee \n\n");
        System.out.printf("%35s","Choose a task to perform");

        try {
            while (true) {
                System.out.printf(" \n\n%12s %12s %12s %12s", "(1) Orders", "(2) View Stock", "(3) View Deliveries", "(4) View Products Offered", "(5) Exit \n\n");
                System.out.print("Action: ");
                String task = input.nextLine();

                switch (task) {

                    case "1": // pertains to orders
                        try {
                            while (true) {
                                System.out.printf(" \n\n%12s %12s %12s %12s", "(1) Place Order", "(2) View Orders", "(3) Remove Order",  "(4) Back \n\n");
                                System.out.print("Action: ");
                                String subtask = input.nextLine();

                                switch (task) {

                                    case "1":
//                                        RestaurantController.createOrder();

                                        System.out.println("Choose product to add:");
                                        System.out.println("1. Perishable");
                                        System.out.println("2. Non-Perishable");
                                        System.out.println("3. Equipment");
                                        System.out.println("4. Back");

                                        String choice = input.nextLine();
                                        
                                        switch (choice) {
                                            case "1":
                                                System.out.println("Perishable Products:");
                                                System.out.println("1. Beef, 2. Bread, 3. Butter, 4. Chicken, 5. Egg \n" +
                                                        "6. Goat, 7.Iceberg Lettuce, 8. Lemon, 9. Oregano, 10. Pork \n" +
                                                        "11. Potato, 12. Roman Lettuce, 13. Salmon, 14. Tomato, 15. Tuna\n" +
                                                        "0. Back");
                                                String subchoice = input.nextLine();
                                                switch (subchoice) {
                                                    case "1":
                                                        break;
                                                    case "2":
                                                        break;
                                                    case "3":
                                                        break;
                                                    case "4":
                                                        break;
                                                    case "5":
                                                        break;
                                                    case "6":
                                                        break;
                                                    case "7":
                                                        break;
                                                    case "8":
                                                        break;
                                                    case "9":
                                                        break;
                                                    case "10":
                                                        break;
                                                    case "11":
                                                        break;
                                                    case "12":
                                                        break;
                                                    case "13":
                                                        break;
                                                    case "14":
                                                        break;
                                                    case "15":
                                                        break;
                                                    case "0":
                                                        break;
                                                    default:
                                                        System.out.println("Cannot read value. Please try again");
                                                        break;
                                                }
                                                break;
                                            case "2":
                                                System.out.println("Non-Perishable Products:");
                                                System.out.println("1. Brown Rice, 2. Bucatini, 3. Coca Cola, 4. Dr Pepper, 5. Fanta \n" +
                                                        "6. Fettuccini, 7. Linguini, 8. Olive Oil, 9. Pepsi, 10. Ravioli\n" +
                                                        "11. Rigatoni, 12. Spaghetti, 13. Sprite, 14. Tomato Sauce, 15. White Rice\n" +
                                                        "0. Back");
                                                String subchoice2 = input.nextLine();
                                                switch (subchoice2) {
                                                    case "1":
                                                        break;
                                                    case "2":
                                                        break;
                                                    case "3":
                                                        break;
                                                    case "4":
                                                        break;
                                                    case "5":
                                                        break;
                                                    case "6":
                                                        break;
                                                    case "7":
                                                        break;
                                                    case "8":
                                                        break;
                                                    case "9":
                                                        break;
                                                    case "10":
                                                        break;
                                                    case "11":
                                                        break;
                                                    case "12":
                                                        break;
                                                    case "13":
                                                        break;
                                                    case "14":
                                                        break;
                                                    case "15":
                                                        break;
                                                    case "0":
                                                        break;
                                                    default:
                                                        System.out.println("Cannot read value. Please try again");
                                                        break;
                                                }

                                                break;
                                            case "3":
                                                System.out.println("Equipment Products:");
                                                System.out.println("1. Apron, 2. Bowl, 3. Cloth, 4. Dishwasher, 5. Fork \n" +
                                                        "6. Frying Pan, 7. Grill, 8. Hand Mixer, 9. Heat Lamp, 10. Ice Machine\n" +
                                                        "11. Knife, 12. Microwave, 13. Mixer, 14. Oven, 15. Plate\n" +
                                                        "16. Sauce Pan, 17. Skillet, 18. Spoon, 19. Washing Machine, 20. Wine Opener\n" +
                                                        "0. Back");
                                                String subchoice3 = input.nextLine();
                                                switch (subchoice3) {
                                                    case "1":
                                                        break;
                                                    case "2":
                                                        break;
                                                    case "3":
                                                        break;
                                                    case "4":
                                                        break;
                                                    case "5":
                                                        break;
                                                    case "6":
                                                        break;
                                                    case "7":
                                                        break;
                                                    case "8":
                                                        break;
                                                    case "9":
                                                        break;
                                                    case "10":
                                                        break;
                                                    case "11":
                                                        break;
                                                    case "12":
                                                        break;
                                                    case "13":
                                                        break;
                                                    case "14":
                                                        break;
                                                    case "15":
                                                        break;
                                                    case "16":
                                                        break;
                                                    case "17":
                                                        break;
                                                    case "18":
                                                        break;
                                                    case "19":
                                                        break;
                                                    case "20":
                                                        break;
                                                    default:
                                                        System.out.println("Cannot read value. Please try again");
                                                        break;
                                                }

                                                break;
                                            case "4":
                                                break;
                                            default:
                                                System.out.println("Invalid input. Please try again.");
                                                break;
                                        }

                                        break;

                                    case "2":
                                        RestaurantController.receiveAllOrderInfo();
                                        break;

                                    case "3":
                                        RestaurantController.receiveAllOrderInfo();
                                        System.out.println("What order would you like to cancel?");
                                        String order = input.nextLine();
                                        break;

                                    case "4":
                                        break;

                                    default:
                                        System.out.println("ERROR: Invalid task choice");
                                        break;
                                }
                            }
                        }
                        catch(InputMismatchException ime){
                            ime.printStackTrace();
                        }
                        break;

                    case "2": // view stock
                        Database.viewReceiptTable();
                        break;

                    case "3": // view deliveries
                        Database.viewDelivererTable();
                        break;

                    case "4": // view products offered
                        Database.viewProductTable();
                        break;

                    case "5": // exit program

                        System.out.println("Exiting program...");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("ERROR: Invalid task choice");
                        break;

                }
            }
        }
        catch(InputMismatchException ime){
            ime.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoginInterface();
    }

}
