package com.sctpl.admin.g1.library123.controller;

import com.sctpl.admin.g1.library123.domain.Student;
import com.sctpl.admin.g1.library123.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

   @Autowired
   private StudentService service;

    @PostMapping("/")
    public ResponseEntity<Student> saveBook(@RequestBody Student libraryStudent){
        Student save= service.saveStudent(libraryStudent);
        if (save != null) {
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/f")
    public ResponseEntity<Student> fetchById(@RequestParam Integer studentId){
        Student fetchId= service.fetchById(studentId);
        if (fetchId != null) {
            return new ResponseEntity<>(fetchId, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fa")
    public ResponseEntity<List<Student>> fetchAll(){
        List<Student> fetchAll= service.fetchAll();
        if (fetchAll != null) {
            return new ResponseEntity<>(fetchAll, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/u")
    public ResponseEntity<Student> update(@RequestBody Student libraryStudent){
        Student update= service.update(libraryStudent);
        if (update != null) {
            return new ResponseEntity<>(update, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
