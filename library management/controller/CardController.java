package com.sctpl.admin.g1.library123.controller;


import com.sctpl.admin.g1.library123.domain.Card;
import com.sctpl.admin.g1.library123.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/card")
public class CardController {
   @Autowired
   private CardService cardService;

    @PostMapping("/")
    public ResponseEntity<Card> saveCard(@RequestBody Card libraryCard){
        Card save = cardService.saveCard(libraryCard);
        if (save != null) {
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/f")
    public ResponseEntity<Card> fetchById(@RequestParam Integer cardId){
        Card fetchId =cardService.fetchById(cardId);
        if (fetchId != null) {
            return new ResponseEntity<>(fetchId, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fa")
    public ResponseEntity<List<Card>> fetchAll(){
        List<Card> fetchAll =cardService.fetchAll();
        if (fetchAll != null) {
            return new ResponseEntity<>(fetchAll, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/u")
    public ResponseEntity<Card> update(@RequestBody Card libraryCard){
        Card update = cardService.update(libraryCard);
        if (update != null) {
            return new ResponseEntity<>(update, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
