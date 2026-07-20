public class PasswordStrength {

    public static String checkStrength(String password) {

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSymbol = true;
            }
        }

        int score = 0;

        if (hasUppercase) score++;
        if (hasLowercase) score++;
        if (hasDigit) score++;
        if (hasSymbol) score++;

        if (password.length() < 6 || score <= 1) {
            return "Weak";
        }
        
        if (password.length() < 8 || score == 2) {
            return "Medium";
        }

        if (password.length() < 12 || score == 3) {
            return "Strong";
        }

        return "Very Strong";
    }
}