import java.util.Scanner;

public class Main {

    public static void generateAndDisplayPassword(
            int length,
            boolean upper,
            boolean lower,
            boolean numbers,
            boolean symbols
    ) {

        try {
            
            String password = 
                    PasswordGenerator.generatePassword(
                        length, 
                        upper, 
                        lower, 
                        numbers, 
                        symbols
                    );

            System.out.println("\nGenerated Passwrod: " + password);

            System.out.println(
                "Strength: "
                            + PasswordStrength.checkStrength(password)
            );

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        while (true) { 
            System.out.println("\n==============================");
            System.out.println(" PASSWORD GENERATOR ");
            System.out.println("==============================");
            System.out.println("1. Easy Password");
            System.out.println("2. Medium Password");
            System.out.println("3. Strong Password");
            System.out.println("4. Custom Password");
            System.out.println("5. Check Password Strength");
            System.out.println("6. Exit");
            System.out.print("Enter Choice : ");

            int choice = InputHelper.getValidChoice(sc);

            switch (choice) {

                case 1:

                    generateAndDisplayPassword(
                        8, 
                        true, 
                        true, 
                        true,
                        false
                    );

                    break;

                case 2:

                    generateAndDisplayPassword(
                        12,
                        true,
                        true,
                        true,
                        true
                    );
            
                    break;

                case 3:

                    generateAndDisplayPassword(
                        16,
                        true,
                        true,
                        true,
                        true
                    );

                    break;

                case 4:

                    int length = InputHelper.getValidLength(sc);

                    boolean upper =
                            InputHelper.getYesNo(
                                    sc,
                            "Include Uppercase (Y/N): "
                    );

                    boolean lower =
                            InputHelper.getYesNo(
                                    sc,
                            "Include Lowercase (Y/N): "
                    );

                    boolean numbers =
                            InputHelper.getYesNo(
                                    sc,
                            "Include Numbers (Y/N): "
                    );

                    boolean symbols =
                            InputHelper.getYesNo(
                                    sc,
                            "Include Symbols (Y/N): "
                    );

                    generateAndDisplayPassword(
                            length,
                            upper,
                            lower,
                            numbers,
                            symbols
                    );

                    break;

            }
        }
    }
}
