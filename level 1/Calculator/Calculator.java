
public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    public static double div(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }

        return a / b;
    }

    public static double mod(double a, double b) {
        return a % b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double sqRoot(double number) {

        if (number < 0) {
            throw new ArithmeticException("Square root of a negative number is not allowed.");
            
        }

        return Math.sqrt(number);
    }
}