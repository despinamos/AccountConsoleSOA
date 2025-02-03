package gr.aueb.account.exceptions;

public class UserIdAlreadyExistsException extends RuntimeException {
    public UserIdAlreadyExistsException(String message) {
        super(message);
    }
}
