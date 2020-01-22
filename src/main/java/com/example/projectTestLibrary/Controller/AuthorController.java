package com.example.projectTestLibrary.Controller;

import com.example.projectTestLibrary.Model.Author;
import com.example.projectTestLibrary.Model.Book;
import com.example.projectTestLibrary.Service.AuthorService;
import com.example.projectTestLibrary.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/author")
public class AuthorController {

    private static final String AUTHOR_FORM_URL = "author/authorForm";
    private static final String BOOK_FORM_URL = "author/bookForm";
    private final AuthorService authorService;
    private final BookService bookService;


    @GetMapping("/")
    String index() {
        return "author/index";
    }


    @GetMapping("/getAllAuthorsWithBooks")
    public String getAllAuthorsWithBooks(Model model) {
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("books", bookService.findAll());

        return "author/getAll";
    }

    @GetMapping("/getAllBooks")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "author/getAllBooks";
    }

    @GetMapping("/addNewAuthor")
    public String addNewAutor(Model model) {
        model.addAttribute("author", new Author());
        return AUTHOR_FORM_URL;
    }

    @GetMapping("/getAllAuthors")
    public String getAllAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author/getAllAuthors";
    }

    @GetMapping("/deleteAuthor/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.delleteById(id);
        return ("redirect:/author/getAllAuthors");
    }

    @GetMapping("/editAuthor/{id}")
    public String editAuthor(@PathVariable Long id, Model model) {
        Author authorToEdit = authorService.findById(id);
        model.addAttribute("author", authorToEdit);
        return AUTHOR_FORM_URL;
    }

    @GetMapping("/saveAuthor")
    public String saveNewAuthor(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(objectError ->
                    model.addAttribute("errorMessage", objectError.toString()));

            return AUTHOR_FORM_URL;
        } else {
            authorService.save(author);
            return ("redirect:/author/getAllAuthors");
        }
    }

    @GetMapping("/saveBook")
    public String saveNewBook(@Valid @ModelAttribute("book") Book book, BindingResult bildingResult,
                              RedirectAttributes redirectAttributes, Model model) {
        if (bildingResult.hasErrors()) {

            bildingResult.getAllErrors().forEach(objectError ->
                    model.addAttribute("errorMessege", objectError.toString()));

            return BOOK_FORM_URL;
        } else {
            bookService.save(book);
            return ("redirect:/author/getAllBooks");
        }
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.delleteById(id);
        return ("redirect:/author/getAllBooks");
    }

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book bookToEdit = bookService.findById(id);
        model.addAttribute("book", bookToEdit);
        model.addAttribute("authors", authorService.findAll());
        return BOOK_FORM_URL;
    }

    @GetMapping("/addNewBook")
    public String addNewBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.findAll());
        return BOOK_FORM_URL;
    }


}

