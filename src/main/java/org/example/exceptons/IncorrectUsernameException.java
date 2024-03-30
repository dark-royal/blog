package org.example.exceptons;

public class IncorrectUsernameException extends RuntimeException {
    public IncorrectUsernameException(String invalidUsernameOrPassword) {
        super(invalidUsernameOrPassword);
    }
}
