package eapli.base.exceptions;

public class AlreadyDeactivatedException extends Exception{
    public AlreadyDeactivatedException(String message){
        super(message);
    }

    public AlreadyDeactivatedException(){
        super("It's already deactivated");
    }
}
