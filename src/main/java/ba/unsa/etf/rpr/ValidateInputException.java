package ba.unsa.etf.rpr;

/**
 * Exception happens when the input from console is not in expected format
 */
public class ValidateInputException extends RuntimeException {
    public ValidateInputException(String message) {
        super(message);
    }
}
