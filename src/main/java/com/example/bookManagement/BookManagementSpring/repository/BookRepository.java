package com.example.bookManagement.BookManagementSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookManagement.BookManagementSpring.model.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer>{

}
