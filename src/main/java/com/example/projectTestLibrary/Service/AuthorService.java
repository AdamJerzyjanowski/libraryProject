package com.example.projectTestLibrary.Service;

import com.example.projectTestLibrary.Model.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<Author> findByName(String name);
    Author findById(Long id);
    List<Author> findAll();
    void delleteById(Long id);
    Author save(Author author);
}
