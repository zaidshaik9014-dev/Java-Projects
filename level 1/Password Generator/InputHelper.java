import java.util.Scanner;

public class InputHelper {
    public static int getValidChoice(Scanner sc) {

        while (true) { 

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();

                if (choice >= 1 && choice <= 6) {
                    return choice;
                }

                System.out.println("Enter a number between 1 ans 3: ");

            } else {

                System.out.print("Invalid Input. \nEnter a number: ");

                sc.next();

            }
        }
    }

    public static int getValidLength(Scanner sc) {

        System.out.print("Enter Password Length (4-64): ");

        while (true) { 
            
            if (sc.hasNextInt()) {

                int length = sc.nextInt();

                if (length >= 4 && length <= 64) {
                    return length;
                }
            
                System.out.print(
                        "Password length must be between 4 and 64: "
                );
                
            } else {

                System.out.print("invalid Input.\nEnter a number: ");

                sc.next();
                
            }
        }
    }

    public static boolean getYesNo(Scanner sc, String message) {
        
        while (true) { 
            
            System.out.print(message);

            String input = sc.next().trim();

            if (input.equalsIgnoreCase("Y")) {
                return true;
            }

            if (input.equalsIgnoreCase("N")) {
                return false;
            }

            System.out.println("Please enter Y or N.");
        }
    }
}
