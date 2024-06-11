package com.sctpl.admin.g1.library123.service.impl;

import com.sctpl.admin.g1.library123.domain.Book;
import com.sctpl.admin.g1.library123.domain.Student;
import com.sctpl.admin.g1.library123.domain.Transaction;
import com.sctpl.admin.g1.library123.enums.TransactionStatus;
import com.sctpl.admin.g1.library123.repository.BookRepository;
import com.sctpl.admin.g1.library123.repository.StudentRepository;
import com.sctpl.admin.g1.library123.repository.TransactionRepository;
import com.sctpl.admin.g1.library123.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Transaction issueBook(String bookName, Integer student_id) throws Exception {
        Book book = bookRepository.fetchByName(bookName);
        Optional<Student> student = studentRepository.findById(student_id);
        if(book == null){
            throw new Exception("Book not found");
        }
        if (student.isEmpty()) {
            throw new Exception("student not found.");
        }

        Student studentBook = student.get();

        if(studentBook.getBook().size() >=3){
            throw new Exception("A student can only issue up to 3 books.");
        }
        if (book != null && student != null && book.getAvailable()) {

            Transaction transaction = new Transaction();
            transaction.setTransactionId(UUID.randomUUID());
            transaction.setBook(book);
            transaction.setStudent(studentBook);
            transaction.setIsIssueBook(true);
            transaction.setTransactionDate(new Date());
            transaction.setBookDueDate(LocalDate.now().plusDays(14));
            transaction.getCreatedOn();
            transaction.setTransactionStatus(TransactionStatus.PAYMENT_SUCCESSFUL);

            book.setAvailable(false);
            bookRepository.save(book);

            transactionRepository.save(transaction);

            return transaction;
        } else {
            throw new Exception("Invalid book or student.");
        }
    }

    @Override
    public Transaction returnBook(String bookName, Integer student_id) throws Exception {
        Book book = bookRepository.fetchByName(bookName);
        Optional<Student> student = studentRepository.findById(student_id);

        if (book != null && student != null) {
            Transaction transaction = transactionRepository.findByStudent_id(student_id);
            Student studentBook = student.get();
            if (transaction != null) {
                LocalDate currentDate = LocalDate.now();
                LocalDate dueDate = transaction.getBookDueDate();
                double fineAmount = fine(dueDate);

                transaction.setTransactionId(UUID.randomUUID());
                transaction.setBook(book);
                transaction.setStudent(studentBook);
                transaction.setIsReturned(currentDate);
                transaction.setIsIssueBook(false);
                transaction.setTransactionDate(new Date());
                transaction.setBookDueDate(LocalDate.now().plusDays(14));
                transaction.setFineAmount(fineAmount);
                transaction.getUpdatedOn();
                book.setAvailable(true);
                transaction.setTransactionStatus(TransactionStatus.PAYMENT_SUCCESSFUL);

                transactionRepository.save(transaction);
                bookRepository.save(book);

                return transaction;
            } else {
                throw new Exception("Transaction not found");
            }
        } else {
            throw new Exception("Book or student not found");
        }
    }

    private double fine(LocalDate dueDate) {
        double fineRate = 5.0;
        double fineValue = 0.0;
        LocalDate currentDate = LocalDate.now();

        while (currentDate.isAfter(dueDate.plusDays(14))) {
            fineValue += fineRate;
            dueDate = dueDate.plusDays(1);
        }

        return fineValue;
    }



}
