package eapli.base.exceptions;

public class CellIsEmptyException extends Exception {
    public CellIsEmptyException() {
        super("This cell doesn't have a post-it");
    }

    public CellIsEmptyException(String message) {
        super(message);
    }
}
