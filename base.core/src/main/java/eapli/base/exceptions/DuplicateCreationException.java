package eapli.base.exceptions;

public class DuplicateCreationException extends Exception{
    public DuplicateCreationException (String message){
        super(message);
    }
    public DuplicateCreationException(){
        super("You already created that!");
    }
}
