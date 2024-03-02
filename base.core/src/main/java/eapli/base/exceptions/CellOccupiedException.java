package eapli.base.exceptions;

public class CellOccupiedException extends Exception{
    public CellOccupiedException(String message){
        super(message);
    }

    public CellOccupiedException(){
        super("The cell is already occupied");
    }
}
