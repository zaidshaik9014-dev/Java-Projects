import java.util.Scanner;

public class Main {
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

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Password Length : ");
                    int length = sc.nextInt();

                    System.out.print("Include Uppercase (true/false) : ");
                    boolean upper = sc.nextBoolean();

                    System.out.print("Include Lowercase (true/false) : ");
                    boolean lower = sc.nextBoolean();

                    System.out.print("Include Numbers (true/false) : ");
                    boolean number = sc.nextBoolean();

                    System.out.print("Include Symbols (true/false) : ");
                    boolean symbol = sc.nextBoolean();

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
                        "Strength " + PasswordStrength.checkStrength(password));
                    
                    break;

                case 3:

                    System.out.println("Thank you!");
                    sc.close();
                    return;
                
                default:

                    System.out.println("Invalid Choice.");

            }
        }
    }
}
