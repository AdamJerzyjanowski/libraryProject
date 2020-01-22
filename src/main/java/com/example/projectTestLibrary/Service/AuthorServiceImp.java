package com.example.projectTestLibrary.Service;

import com.example.projectTestLibrary.Model.Author;
import com.example.projectTestLibrary.Repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findByName(String name) {
        List<Author> authors = new ArrayList<>();
        authorRepository.findByName(name).iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Override
    public Author findById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        authorOptional.orElseThrow(()->  new EntityNotFoundException("nie znalezono Autora o takim ID równym"+id));
        return authorOptional.get();
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        authorRepository.findAll().iterator().forEachRemaining(authors::add);
        return authors;
    }

    @Override
    public void delleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author save(Author author) {
       Author authorTemp = authorRepository.save(author);
        return authorTemp;
    }
}
