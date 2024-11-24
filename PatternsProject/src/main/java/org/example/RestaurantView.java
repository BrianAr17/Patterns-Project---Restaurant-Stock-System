package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RestaurantView {
    static Scanner input = new Scanner(System.in);

    public static void LoginInterface(){
        System.out.print("Welcome to Restaurant Stocking System\n\n"); //TODO give proper name to stocking system later
        System.out.printf("%23s","Login\n\n");
        System.out.print("Employee Name: ");
        String name = input.nextLine();
        System.out.print("Employee Password: ");
        String password = input.nextLine();

        // code to check if ID & password are valid
        System.out.println("\n\n\n");
    }

    public static void EmployeeInterface(){
        System.out.println("\n");
        System.out.printf("%35s","Welcome Employee \n\n");
        System.out.printf("%35s","Choose a task to perform");

        try {
            while (true) {
                System.out.printf(" \n\n%12s %12s %12s %12s", "(1) Task 1", "(2) Task 2", "(3) Task 3", "(4) Exit \n\n");
                System.out.print("Action: ");
                String task = input.nextLine();

                switch (task) {

                    case "1":
                        // method that performs task 1
                        break;

                    case "2":
                        // method that performs task 2
                        break;

                    case "3":
                        // method that performs task 3
                        break;

                    case "4":
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

    }

}
