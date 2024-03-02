package eapli.base.exceptions;

public class CellDoesNotExistException extends Exception {
    public CellDoesNotExistException() {
        super("This cell doesn't exist in this board");
    }

    public CellDoesNotExistException(String message) {
        super(message);
    }
}
