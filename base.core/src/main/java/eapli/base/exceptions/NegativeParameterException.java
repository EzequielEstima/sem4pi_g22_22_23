package eapli.base.exceptions;

public class NegativeParameterException extends Exception{
    public NegativeParameterException() {
        super("This parameter cannot be negative");
    }

    public NegativeParameterException(String message) {
        super(message);
    }
}
