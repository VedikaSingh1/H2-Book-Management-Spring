package com.example.bookManagement.BookManagementSpring.services;

public class DuplicateBookException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DuplicateBookException(String message) {
        super(message);
    }
}
