import  java.util.Scanner;

public class Main {
    
    public static double[] getTwoNum(Scanner sc) {

        double first = getValidNum(sc, "Enter first number: ");

        double sec = getValidNum(sc, "Enter second number: ");

        return new double[]{first, sec};
    }

    public static double getValidNum(Scanner sc, String message) {

        while (true) { 
            System.out.println(message);

            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Invalid Input. Please enter a valid number.");
                sc.next();
            }
        }
    }

    public static void printResult(String operation,
                                    double first,
                                    double sec,
                                    double res,
                                    CalculatorHistory history) {

        System.out.println("Result: " + res);

        history.addHistory(
                    first + " " + operation + " " + sec + " = " + res
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CalculatorHistory history = new CalculatorHistory();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("      JAVA CALCULATOR");
            System.out.println("==============================");

            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Modulus");
            System.out.println("6. Power");
            System.out.println("7. Square Root");
            System.out.println("8. View History");
            System.out.println("9. Clear History");
            System.out.println("10. Exit");

            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();

            if (choice > 10 || choice < 1) {
                System.out.println("Choose a valid operation from Menu.");
                continue;
            }

            if (choice == 8) {
                history.viewHistory();
                continue;
            }

            if (choice == 9) {
                history.clearHistory();
            }

            if (choice == 10) {
                System.out.println("Thank You!");
                sc.close();
                System.exit(0);
                break;
            }

            if (choice == 7) {

                double number = getValidNum(sc, "Enter number: ");

                try {

                    double result = Calculator.sqRoot(number);

                    System.out.println("Result : " + result);

                    history.addHistory("√" + number + " = " + result);

                } catch (ArithmeticException e) {

                    System.out.println(e.getMessage());
                    
                }

                continue;
            }

            double[] numbers = getTwoNum(sc);

            double first = numbers[0];
            double second = numbers[1];

            switch (choice) {

                case 1:

                    printResult(
                            "+",
                            first,
                            second,
                            Calculator.add(first, second),
                            history
                    );
                    break;

                case 2:

                    printResult(
                            "-",
                            first,
                            second,
                            Calculator.sub(first, second),
                            history
                    );
                    break;

                case 3:

                    printResult(
                            "*",
                            first,
                            second,
                            Calculator.mul(first, second),
                            history
                    );
                    break;

                case 4:

                    try {

                        printResult(
                            "/",
                            first,
                            second,
                            Calculator.div(first, second),
                            history
                        );

                    }
                    catch (ArithmeticException e) {

                        System.out.println(e.getMessage());

                    }

                case 5:

                    printResult(
                            "%",
                            first,
                            second,
                            Calculator.mod(first, second),
                            history
                    );
                    break;

                case 6:

                    printResult(
                            "^",
                            first,
                            second,
                            Calculator.power(first, second),
                            history
                    );
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}