package com.example.projectTestLibrary.Repository;

import com.example.projectTestLibrary.Model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    List<Author> findByName(String name);
}
