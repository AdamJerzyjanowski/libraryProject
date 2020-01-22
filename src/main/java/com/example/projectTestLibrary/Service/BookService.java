package com.example.projectTestLibrary.Service;

import com.example.projectTestLibrary.Model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> findByName(String name);
    Book findById(Long id);
    List<Book> findAll();
    void delleteById(Long id);
    Book save(Book book);
}
