package com.example.ktmd2.service;

import com.example.ktmd2.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    List<Student> studentList;

    public StudentServiceImpl() {
        studentList = new ArrayList<>();
        studentList.add(new Student("001", "Đạt", 18, "trai", "hà đông", 9.8));
        studentList.add(new Student("002", "My", 18, "gái", "hà trì", 5.4));
        studentList.add(new Student("003", "Tuấn", 18, "trai", "phú thọ", 4.56));
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void edit(String msv, Student student) {
        int index = 1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getMsv() == msv) {
                i = index;
            }
        } studentList.set(index,student);
    }

    @Override
    public void delete(String msv) {
        for (Student s : studentList) {
            if (s.getMsv().equals(msv)) {
                studentList.remove(s);
                break;
            }
        }
    }
}
