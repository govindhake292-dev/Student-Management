package com.example.First_application.service;

import com.example.First_application.entity.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student updateStudent(Student student);

    void deleteStudent(int id);
}