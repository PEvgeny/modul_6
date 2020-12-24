package com.library.controller;

import com.library.entity.Book;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("books")
public class LibraryController {

    @Autowired
    BookService service;


    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id){
        return service.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBook(){
        return service.getAllBooks();
    }


    @PostMapping
    public Book addBook(@RequestBody Book book){
        service.insetBook(book);
        return book;
    }

    @PutMapping("{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id){
        service.updateBook(book,id);
        return service.getBookById(id);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBookById(id);
    }
}
