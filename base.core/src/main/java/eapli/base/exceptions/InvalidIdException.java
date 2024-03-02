package eapli.base.exceptions;

public class InvalidIdException extends Exception{
    public InvalidIdException() {
        super("The id must be a value greater than zero.");
    }

    public InvalidIdException(String message) {
        super(message);
    }
}
