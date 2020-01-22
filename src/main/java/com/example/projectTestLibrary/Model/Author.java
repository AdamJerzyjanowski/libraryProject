package com.example.projectTestLibrary.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Sposób nadawania następnych id
    public Long id;

    @NotNull(message = "Podaj autora")
    @Size(min = 2, max = 300, message = "Nazwa powinna mieć od 2 do 300 znaków")
    public String name;

    @OneToMany(cascade = CascadeType.ALL)//Relacja w bazie danych
    @JoinColumn(name = "AUTHOR_ID")
    public List<Book> books;
}
