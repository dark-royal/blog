package org.example.services;

public class UsernameExistException extends RuntimeException {
    public UsernameExistException(String message) {
        super(message);
    }
}
