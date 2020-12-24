package com.library.service;

import com.library.entity.Book;
import com.library.exceptions.NotFoundException;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    BookRepository repository;

    @Transactional(readOnly = true)
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public void insetBook(Book book){
        repository.save(book);
    }

    public void deleteBookById(Long id){
        repository.deleteById(id);
    }

    public void updateBook(Book book, Long id){
        Book bookFromBd = repository.findById(id).orElseThrow(NotFoundException :: new);
        bookFromBd.setAuthor(book.getAuthor());
        bookFromBd.setName(book.getName());
        bookFromBd.setCategory(book.getCategory());
        bookFromBd.setYear(book.getYear());
        repository.save(bookFromBd);
    }

    @Transactional(readOnly = true)
    public Book getBookById(Long id){
        return repository.findById(id).orElseThrow(NotFoundException :: new);
    }


}
