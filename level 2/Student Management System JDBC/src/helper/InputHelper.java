package helper;

import java.util.Scanner;

public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String message) {

        System.out.print(message);

        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("exit")) {
            throw new UserCancelledException();
        }

        return input;
    }

    public static int getInt(String message) {

        while (true) {

            String input = getString(message);

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println("Invalid input. Please enter a number.");

            }
        }
    }

    public static int getAge(String message) {

        while (true) {

            int age = getInt(message);

            if (age >= 15 && age <= 100) {
                return age;
            }

            System.out.println("Age must be between 15 and 100.");

        }
    }

    public static String getNonEmptyString(String message) {

        while (true) {

            String input = getString(message);

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    public static String getEmail(String message) {

        while (true) {

            String email = getNonEmptyString(message);

            if (email.contains("@") && email.contains(".")) {
                return email;
            }

            System.out.println("Invalid email. Please enter a valid email.");
        }
    }

    public static String getPhone(String message) {

        while (true) {

            String phone = getString(message);

            if (phone.matches("\\d{10}")) {
                return phone;
            }

            System.out.println("Invalid phone number. Enter exactly 10 digits.");
        }
    }

    public static int getStudentId(String message) {

        while (true) {

            int id = getInt(message);

            if (id > 0) {
                return id;
            }

            System.out.println("Student ID must be greater than 0.");
        }
    }

    public static boolean getYesNo(String message) {

        while (true) {

            String input = getNonEmptyString(message);

            if (input.equalsIgnoreCase("yes")
                    || input.equalsIgnoreCase("y")) {

                return true;
            }

            if (input.equalsIgnoreCase("no")
                    || input.equalsIgnoreCase("n")) {

                return false;
            }

            System.out.println("Please enter yes or no.");
        }
    }
}