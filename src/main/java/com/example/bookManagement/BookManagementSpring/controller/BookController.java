package com.example.bookManagement.BookManagementSpring.controller;
 
import com.example.bookManagement.BookManagementSpring.model.BookModel;
import com.example.bookManagement.BookManagementSpring.services.BookService;
import com.example.bookManagement.BookManagementSpring.services.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/api/books") // Base endpoint URL
public class BookController {
 
    @Autowired
    private final BookService bookService; // Constructor injection
    
    // Constructor for dependency injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    // Add a new book
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookModel bookModel) {
        bookService.addBook(bookModel);
        return new ResponseEntity<>("Book added successfully", HttpStatus.CREATED);
    }
 
    // Get all books
    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }
 
    // Get book by ID
    @GetMapping("/{bookId}")
    public ResponseEntity<BookModel> getBookById(@PathVariable int bookId) {
        try {
            BookModel bookModel = bookService.getBookById(bookId);
            return new ResponseEntity<>(bookModel, HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
    // Delete book by ID
    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable int bookId) {
        try {
            bookService.deleteBook(bookId);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
 
    // Get books sorted by name
    @GetMapping("/sorted")
    public ResponseEntity<List<BookModel>> sortBooks() {
        List<BookModel> books = bookService.sortBooksByName();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}