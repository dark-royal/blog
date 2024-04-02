package org.example.exceptons;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException(String entryNotFound) {
        super(entryNotFound);
    }
}
