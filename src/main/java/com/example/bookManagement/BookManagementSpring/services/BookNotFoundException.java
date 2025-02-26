package com.example.bookManagement.BookManagementSpring.services;
 
public class BookNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
 
    // Constructor to initialize the exception with a custom message
    public BookNotFoundException(String message) {
        super(message); // Pass the custom message to the superclass (Exception)
    }
}