package com.sctpl.admin.g1.library123.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="author")
public class Author{

     @Id
     @GeneratedValue

     private Integer id;

     private Integer authorId;

     private String name;

     private String email;

     private Integer age;

     private String country;


//     @OneToMany
//     @JoinColumn
//     private Set<Book> books;

     public Author(){
     }

     public Author(Integer authorId, String name, String email, Integer age, String country) {
          this.authorId = authorId;
          this.name = name;
          this.email = email;
          this.age = age;
          this.country = country;

     }


     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public Integer getAuthorId() {
          return authorId;
     }

     public void setAuthorId(Integer authorId) {
          this.authorId = authorId;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }

     public String getCountry() {
          return country;
     }

     public void setCountry(String country) {
          this.country = country;
     }

//     public Set<Book> getBooK() {
//          return books;
//     }
//
//     public void setBook(Set<Book> books) {
//          this.books = books;
//     }

}
