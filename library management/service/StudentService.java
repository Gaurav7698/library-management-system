package com.sctpl.admin.g1.library123.service;



import com.sctpl.admin.g1.library123.domain.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student libraryStudent);

    Student fetchById(Integer studentId);

    List<Student> fetchAll();

    Student update(Student libraryStudent);
}
