package com.sctpl.admin.g1.library123.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer studentId;

    private Integer age;
    private String studentName;

    private String country;

    private String email;

    private Integer phoneNumber;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Book> books;

//    @OneToOne(mappedBy = "students",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    private Card cards;

    //    @OneToMany(mappedBy = "students",fetch = FetchType.EAGER)
//    @JsonIgnore
//    private List<Transaction> transactions;
    public Student() {

    }
    public Student(Integer studentId, Integer age, String studentName, String country, String email, Integer phoneNumber) {
        this.studentId = studentId;
        this.age = age;
        this.studentName = studentName;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
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

//    public Card getCard() {
//        return cards;
//    }
//
//    public void setCard(Card cards) {
//        this.cards = cards;
//    }

    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }
//    public List<Transaction> getTransaction() {
//        return transactions;
//    }
//
//    public void setTransaction(List<Transaction> transactions) {
//        this.transactions = transactions;
//    }
}
