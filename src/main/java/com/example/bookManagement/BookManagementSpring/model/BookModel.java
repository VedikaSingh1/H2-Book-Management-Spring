package com.example.bookManagement.BookManagementSpring.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class BookModel {
	@Id
    private int bookId;
    private String bookName;
    private String author;
    private String genre;
    private String publishDate;
    private int numPages;
    
    public BookModel() {}
 
    public BookModel(int bookId, String bookName, String author, String genre, String publishDate, int numPages) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.publishDate = publishDate;
        this.numPages = numPages;
    }
 
    // Getters and setters
    public int getBookId() {
        return bookId;
    }
 
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
 
    public String getBookName() {
        return bookName;
    }
 
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }
 
    public String getPublishDate() {
        return publishDate;
    }
 
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
 
    public int getNumPages() {
        return numPages;
    }
 
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
 
    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Name: " + bookName + ", Author: " + author + ", Genre: " + genre +
                ", Publish Date: " + publishDate + ", Pages: " + numPages;
    }
}