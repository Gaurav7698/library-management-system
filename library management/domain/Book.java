package com.sctpl.admin.g1.library123.domain;

import com.sctpl.admin.g1.library123.enums.Genre;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
//@Table(name="book")
public class Book {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private Integer id;

   private Integer bookId;

   private String bookName;

   private Integer numberOfPage;

   private Boolean available;

   @Enumerated(value = EnumType.STRING)
   private Genre genre;

   private Integer isbnNumber;

   private Integer publishedDate;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "card_id")
   private Card cards;

   //   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//   @JoinColumn(name = "student_id")
//   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   @ManyToOne
   @JoinColumn
   private Student student;



   @OneToMany(mappedBy = "books",fetch = FetchType.EAGER)
   private List<Transaction> transactions;

   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name = "author_id")
   private Author authors;

   public Book() {

   }

   public Book(Integer bookId, String bookName, Integer numberOfPage, Integer isbnNumber, Integer publishedDate) {
      this.bookId = bookId;
      this.bookName = bookName;
      this.numberOfPage = numberOfPage;
      this.available = true;
      this.isbnNumber = isbnNumber;
      this.publishedDate = publishedDate;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Integer getBookId() {
      return bookId;
   }

   public void setBookId(Integer bookId) {
      this.bookId = bookId;
   }

   public String getBookName() {
      return bookName;
   }

   public void setBookName(String bookName) {
      this.bookName = bookName;
   }

   public Author getAuthor() {
      return authors;
   }

   public void setAuthor(Author authors) {
      this.authors = authors;

   }

   public Card getCard() {
      return cards;
   }

   public void setCard(Card cards) {

      this.cards = cards;
      if(cards != null && cards.getStudent() != null){
         this.student=cards.getStudent();
      }
   }


   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   public Integer getNumberOfPage() {
      return numberOfPage;
   }

   public void setNumberOfPage(Integer numberOfPage) {
      this.numberOfPage = numberOfPage;
   }

   public Boolean getAvailable() {
      return available;
   }

   public void setAvailable(Boolean available) {
      this.available = available;
   }

   public Integer getIsbnNumber() {
      return isbnNumber;
   }

   public void setIsbnNumber(Integer isbnNumber) {
      this.isbnNumber = isbnNumber;
   }

   public Integer getPublishedDate() {
      return publishedDate;
   }

   public void setPublishedDate(Integer publishedDate) {
      this.publishedDate = publishedDate;
   }

   public Genre getGenre() {
      return genre;
   }

   public void setGenre(Genre genre) {
      this.genre = genre;
   }

   public List<Transaction> getTransaction() {
      return transactions;
   }

   public void setTransaction(List<Transaction> transactions) {
      this.transactions = transactions;
   }





   }

















//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.sctpl.admin.g1.library123.enums.Genre;
//import jakarta.persistence.*;
//
//
//@Entity
////@Table(name="book")
//public class Book  {
//
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Integer id;
//
//   private Integer bookId;
//
//   private String bookName;
//
//   private Integer numberOfPage;
//
//   private Boolean available;
//
//
//   @Enumerated(value = EnumType.STRING)
//   private Genre genre;
//
//   private Integer isbnNumber;
//
//   private Integer publishedDate;
//
//
//   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//   @JoinColumn(name = "card_id")
//   private Card card;
//
////   @ManyToOne(cascade = CascadeType.ALL)
////   @JsonIgnoreProperties({"books"})
////   @JoinColumn(name = "student_id")
////   private Student student;
//
//   @ManyToOne
//   @JoinColumn(name = "student_id")
//   private Student student;
//
////   @OneToMany(mappedBy = "books")
////   private List<Transaction> transactions;
//
//   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//   @JoinColumn(name = "author_id")
//   private Author authors;
//
//   public Book() {
//
//   }
//
//
//   public Book(Integer id, Integer bookId, String bookName, Integer numberOfPage, Boolean available, Genre genre, Integer isbnNumber, Integer publishedDate) {
//      this.id = id;
//      this.bookId = bookId;
//      this.bookName = bookName;
//      this.numberOfPage = numberOfPage;
//      this.available = available;
//      this.genre = genre;
//      this.isbnNumber = isbnNumber;
//      this.publishedDate = publishedDate;
//   }
//
//   public Integer getId() {
//      return id;
//   }
//
//   public void setId(Integer id) {
//      this.id = id;
//   }
//
//   public Integer getBookId() {
//      return bookId;
//   }
//
//   public void setBookId(Integer bookId) {
//      this.bookId = bookId;
//   }
//
//   public String getBookName() {
//      return bookName;
//   }
//
//   public void setBookName(String bookName) {
//      this.bookName = bookName;
//   }
//
//   public Author getAuthor() {
//      return authors;
//   }
//
//   public void setAuthor(Author authors) {
//      this.authors = authors;
//
//   }
//
//   public Card getCard() {
//      return card;
//   }
//
//   public void setCard(Card card) {
//      this.card = card;
//
//      if (card != null && card.getStudents() != null) {
//         this.student = card.getStudents();
//      }
//   }
//
//
//   public Student getStudent() {
//      return student;
//   }
//
//   public void setStudent(Student student) {
//      this.student = student;
//   }
//
//   public Integer getNumberOfPage() {
//      return numberOfPage;
//   }
//
//   public void setNumberOfPage(Integer numberOfPage) {
//      this.numberOfPage = numberOfPage;
//   }
//
//   public Boolean getAvailable() {
//      return available;
//   }
//
//   public void setAvailable(Boolean available) {
//      this.available = available;
//   }
//
//   public Integer getIsbnNumber() {
//      return isbnNumber;
//   }
//
//   public void setIsbnNumber(Integer isbnNumber) {
//      this.isbnNumber = isbnNumber;
//   }
//
//   public Integer getPublishedDate() {
//      return publishedDate;
//   }
//
//   public void setPublishedDate(Integer publishedDate) {
//      this.publishedDate = publishedDate;
//   }
//
//   public Genre getGenre() {
//      return genre;
//   }
//
//   public void setGenre(Genre genre) {
//      this.genre = genre;
//   }
//
//
////      public List<Transaction> getTransaction() {
////      return transactions;
////   }
////
////   public void setTransaction(List<Transaction> transactions) {
////      this.transactions = transactions;
////   }
//
//
//}
