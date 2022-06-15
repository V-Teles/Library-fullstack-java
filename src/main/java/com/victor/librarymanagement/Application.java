package com.victor.librarymanagement;

import com.victor.librarymanagement.entity.Book;
import com.victor.librarymanagement.repository.BookRepository;
import com.victor.librarymanagement.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) { SpringApplication.run(Application.class, args); }

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
//        Book book1 = new Book("Les Miserables",
//                "Victor Hugo",
//                "Lacroix, Verboeckhoven & Co.",
//                1862,
//                "French",
//                1900,
//                true);
//        bookRepository.save(book1);
//
//        Book book2 = new Book("Os Lusíadas",
//                "Luís de Camões",
//                "Antonio Gocalvez",
//                1572,
//                "portuguese",
//                380,
//                true);
//        bookRepository.save(book2);
//
//        Book book3 = new Book("La Divina Commedia",
//                "Dante Allighieri",
//                "Johann Numeister and Evangelista Angelini ",
//                1472,
//                "italian",
//                750,
//                false);
//        bookRepository.save(book3);

    }
}
