package eapli.base.exceptions;

public class InvalidContentSizeForAPostItException extends Exception{
    public InvalidContentSizeForAPostItException(String message) {
        super(message);
    }
    public InvalidContentSizeForAPostItException() {
        super("The content size of a post-it must be between 1 and 60 characters");
    }
}
