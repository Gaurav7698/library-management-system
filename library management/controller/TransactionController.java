package com.sctpl.admin.g1.library123.controller;

import com.sctpl.admin.g1.library123.domain.Transaction;
import com.sctpl.admin.g1.library123.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

   @Autowired
   private TransactionService transactionService;

//   private BookService bookService;
//
//   private CardService cardService;
    @PostMapping("/issue")
    public ResponseEntity<String> issueBook(@RequestParam String bookName,@RequestParam Integer student_id) throws Exception {
        transactionService.issueBook(bookName, student_id);
        return ResponseEntity.ok("Book issued successfully.");
    }
    @PostMapping("/return")
    public ResponseEntity<Transaction> returnBook(@RequestParam String bookName,@RequestParam Integer student_id) throws Exception {
        Transaction transaction = transactionService.returnBook(bookName, student_id);
        if (transaction != null) {
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
