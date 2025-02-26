package com.example.bookManagement.BookManagementSpring.services;
 
import com.example.bookManagement.BookManagementSpring.model.BookModel;
import com.example.bookManagement.BookManagementSpring.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
 
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepo;
 
    private final List<BookModel> books = new ArrayList<>(); // ArrayList to hold books
 
    @Override
    public void addBook(BookModel bookModel) {
        if (bookModel == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }

        // Check if the ID or Name already exists
        if (books.stream().anyMatch(book -> book.getBookId() == bookModel.getBookId())) {
            throw new DuplicateBookException("Book with ID " + bookModel.getBookId() + " already exists");
        }
        
        if (books.stream().anyMatch(book -> book.getBookName().equalsIgnoreCase(bookModel.getBookName()))) {
            throw new DuplicateBookException("Book with name '" + bookModel.getBookName() + "' already exists");
        }

        if (bookModel.getBookId() <= 0) {
            throw new IllegalArgumentException("Book ID must be positive");
        }

        // Check if book name, author, genre, etc., are null or empty
        if (bookModel.getBookName() == null || bookModel.getBookName().isEmpty()) {
            throw new IllegalArgumentException("Book name cannot be null or empty");
        }
        if (bookModel.getAuthor() == null || bookModel.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }

        bookRepo.save(bookModel);
    }
 
    @Override
    public List<BookModel> getAllBooks() {
        return bookRepo.findAll();
    }
 
    @Override
    public BookModel getBookById(int bookId) throws BookNotFoundException {
        return bookRepo.findById(bookId).orElse(new BookModel());
    }
 
    @Override
    public void deleteBook(int bookId) throws BookNotFoundException {
        bookRepo.deleteById(bookId);
    }
 
    @Override
    public List<BookModel> sortBooksByName() {
        books.sort(Comparator.comparing(BookModel::getBookName));
        return books;
    }
    
    @Override
    public void updateBook(BookModel bookModel) {
    	bookRepo.save(bookModel);
    }
}