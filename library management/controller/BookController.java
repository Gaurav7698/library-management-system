package com.sctpl.admin.g1.library123.controller;


import com.sctpl.admin.g1.library123.domain.Book;
import com.sctpl.admin.g1.library123.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

  @Autowired
  private BookService bookService;

    @PostMapping("/")
    public ResponseEntity<Book> saveBook(@RequestBody Book Book){
        Book save = bookService.saveBook(Book);
        if (save != null) {
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/f")
    public ResponseEntity<Book> fetchById(@RequestParam Integer bookId){
        Book fetchId= bookService.fetchById(bookId);
        if (fetchId != null) {
            return new ResponseEntity<>(fetchId, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fa")
    public ResponseEntity<List<Book>> fetchAll(){
        List<Book> fetchAll = bookService.fetchAll();
        if (fetchAll != null) {
            return new ResponseEntity<>(fetchAll, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/u")
    public ResponseEntity<Book> update(@RequestBody Book book){

        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
