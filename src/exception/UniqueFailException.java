package exception;

public class UniqueFailException extends Exception {

    public UniqueFailException() {
        super("Unique Fail");
    }

    public UniqueFailException(String message) {
        super(message);
    }
}
