import java.util.Random;

public class PasswordGenerator {
    private static final String UPPERCASE =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String LOWERCASE =
        "abcdefghijklmnopqrstuvwxyz";

    private static final String NUMBERS =
        "0123456789";

    private static final String SYMBOLS =
        "!@#$%^&*()_+-=[]{}<>?";

    public static String generatePassword(
            int length,
            boolean includeUppercase,
            boolean includeLowercase,
            boolean includeNumbers,
            boolean includeSymbols
    ) {

        StringBuilder characters = new StringBuilder();

        if (includeUppercase) {
            characters.append(UPPERCASE);
        }

        if (includeLowercase) {
            characters.append(LOWERCASE);
        }
        
        if (includeNumbers) {
            characters.append(NUMBERS);
        }

        if (includeSymbols) {
            characters.append(SYMBOLS);
        }

        if (characters.length() == 0) {
            throw new IllegalArgumentException(
                    "Select at least one character type."
            );
        }

        Random random = new Random();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {

            int randomIndex = random.nextInt(characters.length());

            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}