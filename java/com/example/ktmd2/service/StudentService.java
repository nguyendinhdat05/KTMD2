package com.example.ktmd2.service;

import com.example.ktmd2.model.Student;

import java.util.List;

public interface StudentService {
    void add(Student student);
    List<Student> findAll();
    void edit(String msv , Student student);
    void delete(String msv);
}
