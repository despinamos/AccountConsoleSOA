package gr.aueb.account.exceptions;

public class SsnAlreadyExistsException extends RuntimeException {
    public SsnAlreadyExistsException(String message) {
        super(message);
    }
}
