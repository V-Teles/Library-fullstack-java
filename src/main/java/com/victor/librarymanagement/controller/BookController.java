package com.victor.librarymanagement.controller;

import com.victor.librarymanagement.entity.Book;
import com.victor.librarymanagement.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/library")
    public String listBook(Model model){
        model.addAttribute("library",bookService.getAllBooks());
        return "library";
    }

    @GetMapping("/book/new")
    public String createBookForm(Model model){
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/library")
    public String addBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/library";
    }

    @GetMapping("book/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model){
        model.addAttribute("book",bookService.getBookById(id));
        return "edit_book";
    }

    @PostMapping("book/{id}")
    public String updateBook(@PathVariable Long id,
                             @ModelAttribute("book") Book book){
        Book existingBook = bookService.getBookById(id);
        existingBook.setId(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublisher(book.getPublisher());
        existingBook.setYear(book.getYear());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setPages(book.getPages());
        existingBook.setAvailability(book.isAvailability());

        bookService.updateBook(existingBook);
        return "redirect:/library";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);

        return "redirect:/library";
    }
}
