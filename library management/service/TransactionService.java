package com.sctpl.admin.g1.library123.service;

import com.sctpl.admin.g1.library123.domain.Transaction;

public interface TransactionService {
//    Transaction saveTransaction(Transaction libraryTransaction);
//
//    Transaction fetchById(Integer transactionId);
//
//    Transaction update(Transaction libraryTransaction);
//
//    List<Transaction> fetchAll();

    Transaction issueBook(String bookName, Integer student_id) throws Exception;

    Transaction returnBook(String bookName, Integer student_id) throws Exception;

}
