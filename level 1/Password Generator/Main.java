import java.util.Scanner;

public class Main {

    public static int getValidChoice(Scanner sc) {

        while (true) { 

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();

                if (choice >= 1 && choice <= 3) {
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

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        while (true) { 
            System.out.println("\n==============================");
            System.out.println(" PASSWORD GENERATOR ");
            System.out.println("==============================");
            System.out.println("1. Generate Password");
            System.out.println("2. Check Password Strength");
            System.out.println("3. Exit");
            System.out.print("Enter Choice : ");

            int choice = getValidChoice(sc);

            switch (choice) {

                case 1:

                    System.out.print("Enter Password Length : ");
                    int length = getValidLength(sc);

                    boolean upper =
                            getYesNo(sc,
                            "Include Uppercase (Y/N): ");

                    boolean lower =
                            getYesNo(sc,
                            "Include Lowercase (Y/N): ");

                    boolean number =
                            getYesNo(sc,
                            "Include Numbers (Y/N): ");

                    boolean symbol =
                            getYesNo(sc,
                            "Include Symbols (Y/N): ");

                    try {
                        
                        String password = PasswordGenerator.generatePassword(
                            length, upper, lower, number, symbol);

                        System.out.println("\nGenerated Password : " + password);

                        System.out.println(
                            "Strength : " + PasswordStrength.checkStrength(password));

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    sc.nextLine();
                    System.out.println("Enter Password : ");
                    String password = sc.nextLine();
                    System.out.println(
                        "Strength : " + PasswordStrength.checkStrength(password));
                    
                    break;

                case 3:

                    System.out.println("Thank you!");
                    sc.close();
                    return;

            }
        }
    }
}
