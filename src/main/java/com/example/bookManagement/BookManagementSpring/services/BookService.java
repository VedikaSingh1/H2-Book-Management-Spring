package com.example.bookManagement.BookManagementSpring.services;
 
import com.example.bookManagement.BookManagementSpring.model.BookModel;
import java.util.List;
 
public interface BookService {
	//To add a book
    void addBook(BookModel bookModel);
    
    //To get all books
    List<BookModel> getAllBooks();
    
    //To get book by id
    BookModel getBookById(int bookId) throws BookNotFoundException;
    
    //To delete book by id
    void deleteBook(int bookId) throws BookNotFoundException;
    
    //To sort book by id
    List<BookModel> sortBooksByName();
    
    //To update book
    public void updateBook(BookModel bookModel);
}