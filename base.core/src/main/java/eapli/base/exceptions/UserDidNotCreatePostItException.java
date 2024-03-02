package eapli.base.exceptions;

public class UserDidNotCreatePostItException extends Exception {
    public UserDidNotCreatePostItException() {
        super ("The post-it couldn't be changed because this user didn't create it ");
    }

    public UserDidNotCreatePostItException(String message) {
        super(message);
    }
}
