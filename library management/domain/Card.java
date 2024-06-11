package com.sctpl.admin.g1.library123.domain;


import com.sctpl.admin.g1.library123.enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name="card")
public class Card {
   @Id
   @GeneratedValue

   private Integer id;

   private Integer cardId;

   @Enumerated(value = EnumType.STRING)
   private CardStatus status;
   private String email;

   private Integer validUpto;
   @CreationTimestamp
   private Date createdOn;
   @UpdateTimestamp
   private Date updateOn;


   @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JoinColumn(name = "student_id")
   private Student students;

   @OneToMany(fetch = FetchType.EAGER)
    private List<Book> books;

//   @OneToMany(fetch = FetchType.EAGER)
//   private List<Transaction> transactions;

   public Card() {
      this.status=CardStatus.ACTIVATED;
   }

   public Card(Integer cardId,String email, Integer validUpto) {
      this.cardId=cardId;
      this.email = email;
      this.validUpto = validUpto;
   }



   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public Integer getCardId() {
      return cardId;
   }

   public void setCardId(Integer cardId) {
      this.cardId = cardId;
   }

   public CardStatus getStatus() {
      return status;
   }

   public void setStatus(CardStatus status) {
      this.status = status;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Date getCreatedOn() {
      return createdOn;
   }

   public void setCreatedOn(Date createdOn) {
      this.createdOn = createdOn;
   }

   public Date getUpdateOn() {
      return updateOn;
   }

   public Integer getValidUpto() {
      return validUpto;
   }

   public void setValidUpto(Integer validUpto) {
      this.validUpto = validUpto;
   }

   public void setUpdateOn(Date updateOn) {
      this.updateOn = updateOn;
   }

   public Student getStudent() {
      return students;
   }

   public void setStudent(Student students) {
      this.students = students;


   }

   public List<Book> getBook() {
      return books;
   }

   public void setBook(List<Book> books) {
      this.books = books;
   }
//
//   public List<Transaction> getTransaction() {
//      return transactions;
//   }
//
//   public void setTransaction(List<Transaction> transactions) {
//      this.transactions = transactions;
//   }
}
