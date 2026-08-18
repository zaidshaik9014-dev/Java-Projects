package helper;

public class UserCancelledException extends RuntimeException {

    public UserCancelledException() {
        super("Operation cancelled by user.");
    }
}