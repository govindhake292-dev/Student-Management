package com.example.First_application.controller;

import com.example.First_application.entity.Student;
import com.example.First_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("students", studentService.getAllStudents());
        // student.id is null here -> index.html form will point to /save
        model.addAttribute("student", new Student());

        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {

        studentService.saveStudent(student);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable int id, Model model) {

        // student.id is populated here -> index.html form will point to /update
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("students", studentService.getAllStudents());

        return "index";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {

        studentService.updateStudent(student);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {

        studentService.deleteStudent(id);

        return "redirect:/";
    }
}