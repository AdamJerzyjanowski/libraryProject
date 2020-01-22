package com.example.projectTestLibrary.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull(message = "Książka nie może nie posiadać tytułu")
    @Size(min = 2, max = 400, message ="Książka musi posiadać tytuł zawerający od 2 do 400 znaków")
    public String name;

    @NotNull(message = "Musi być więcej stron niż 0")
    public Integer page;

    @NotNull(message = "Podaj cenę")
   // @DecimalMin(value = "0,01", message = "wartość musi być wieksza od 1gr")
    public Integer price;

    public Boolean rent;

    @ManyToOne(targetEntity = Author.class)
    public Long authorId;

}
