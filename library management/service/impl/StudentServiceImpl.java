package com.sctpl.admin.g1.library123.service.impl;


import com.sctpl.admin.g1.library123.domain.Student;
import com.sctpl.admin.g1.library123.repository.StudentRepository;
import com.sctpl.admin.g1.library123.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student libraryStudent) {
        return studentRepository.save(libraryStudent);
    }

    @Override
    public Student fetchById(Integer studentId) {
        return studentRepository.fetchById(studentId);
    }

    @Override
    public List<Student> fetchAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student update(Student libraryStudent) {
        Student libraryStudent1 = studentRepository.fetchById(libraryStudent.getStudentId());

        if(Objects.nonNull(libraryStudent.getStudentId())){
            libraryStudent1.setStudentId(libraryStudent.getStudentId());
        }
        if(Objects.nonNull(libraryStudent.getStudentName()) && !"".equalsIgnoreCase(libraryStudent.getStudentName())){
         libraryStudent1.setStudentName(libraryStudent.getStudentName());
        }
        if(Objects.nonNull(libraryStudent.getAge())){
          libraryStudent1.setAge(libraryStudent.getAge());
        }
        if(Objects.nonNull(libraryStudent.getCountry()) && !"".equalsIgnoreCase(libraryStudent.getCountry())){
          libraryStudent1.setCountry(libraryStudent.getCountry());
        }
        if(Objects.nonNull(libraryStudent.getEmail()) && !"".equalsIgnoreCase(libraryStudent.getEmail())){
           libraryStudent1.setEmail(libraryStudent.getEmail());
        }
        if(Objects.nonNull(libraryStudent.getPhoneNumber())){
           libraryStudent1.setPhoneNumber(libraryStudent.getPhoneNumber());
        }
        return studentRepository.save(libraryStudent1);
    }
}
