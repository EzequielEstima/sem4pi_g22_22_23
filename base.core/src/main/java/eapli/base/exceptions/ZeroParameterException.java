package eapli.base.exceptions;

public class ZeroParameterException extends Exception{
    public ZeroParameterException() {
        super("This parameter cannot be zero");
    }

    public ZeroParameterException(String message) {
        super(message);
    }
}
