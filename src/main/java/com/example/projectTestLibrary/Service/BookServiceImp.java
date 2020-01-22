package com.example.projectTestLibrary.Service;

import com.example.projectTestLibrary.Model.Book;
import com.example.projectTestLibrary.Repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService{
    private final BookRepository bookRepository;
    BookServiceImp(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }


    @Override
    public List<Book> findByName(String name) {
        List<Book> books=new ArrayList<>();
        bookRepository.findByName(name).iterator().forEachRemaining(books::add);
        return null;
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        bookOptional.orElseThrow(()->  new EntityNotFoundException("nie znalezono książki o takim ID równym"+id));
        return bookOptional.get();
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(books::add);
        return books;
    }

    @Override
    public void delleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(Book book) {
       Book bookTem = bookRepository.save(book);
        return bookTem;
    }
    //TODO FindByMorePagesThen
}
