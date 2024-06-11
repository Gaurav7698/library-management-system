package com.sctpl.admin.g1.library123.domain;

import com.sctpl.admin.g1.library123.enums.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
//@Table(name = "transaction")
public class Transaction  {
    @Id
    @GeneratedValue
    private Integer id;

    private UUID transactionId;

//    @ManyToOne
//    @JoinColumn
//    private Card cards;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="book_id")
    private Book books;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student students;

    @CreationTimestamp
    private Date transactionDate;

    private LocalDate bookDueDate;

    private Boolean isIssueBook;
    private LocalDate isReturned;


    private double fineAmount;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    public Transaction() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

//    public Card getCard() {
//        return cards;
//    }
//
//    public void setCard(Card cards) {
//        this.cards = cards;
//    }

    public Book getBook() {
        return books;
    }

    public void setBook(Book books) {
        this.books = books;
    }

    public Student getStudent() {
        return students;
    }

    public void setStudent(Student students) {
        this.students = students;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalDate getBookDueDate() {
        return bookDueDate;
    }

    public void setBookDueDate(LocalDate bookDueDate) {
        this.bookDueDate = bookDueDate;
    }

    public Boolean getIsIssueBook() {
        return isIssueBook;
    }

    public void setIsIssueBook(Boolean isIssueBook) {
        this.isIssueBook = isIssueBook;
    }

    public LocalDate getIsReturned() {
        return isReturned;
    }

    public void setIsReturned(LocalDate isReturned) {
        this.isReturned = isReturned;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

}



