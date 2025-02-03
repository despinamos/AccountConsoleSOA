package gr.aueb.account.exceptions;

public class IbanAlreadyExistsException extends Exception {
    public IbanAlreadyExistsException(String message) {
        super(message);
    }
}
