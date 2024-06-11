package com.sctpl.admin.g1.library123.controller;

import com.sctpl.admin.g1.library123.domain.Author;
import com.sctpl.admin.g1.library123.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

   @PostMapping("/s")
   public ResponseEntity<Author> save(@RequestBody Author Author){
     Author add = authorService.save(Author);
       if (add != null) {
           return new ResponseEntity<>(add, HttpStatus.CREATED);
       } else {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

   @GetMapping("/f")
   public ResponseEntity<Author> fetchById(@RequestParam Integer authorId){
       Author fetchId= authorService.fetchById(authorId);
       if (fetchId != null) {
           return new ResponseEntity<>(fetchId, HttpStatus.CREATED);
       } else {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

   @GetMapping("/fa")
   public ResponseEntity<List<Author>> fetchAll(){
     List<Author> fetchAll= authorService.fetchAll();
       if (fetchAll != null) {
           return new ResponseEntity<>(fetchAll, HttpStatus.CREATED);
       } else {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }
   @PutMapping("/u")
   public ResponseEntity<Author> update(@RequestBody Author Author){
      Author update= authorService.update(Author);
       if (update != null) {
           return new ResponseEntity<>(update, HttpStatus.CREATED);
       } else {
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
   }

}
