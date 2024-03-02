package eapli.base.exceptions;

public class ParameterNullBlankException extends Exception{
    public ParameterNullBlankException (String message){
        super(message);
    }
    public ParameterNullBlankException(){
        super("The parameters inserted were null or blank!");
    }
}
