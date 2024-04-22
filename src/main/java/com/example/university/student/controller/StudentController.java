package com.example.university.student.controller;


import com.example.university.student.dto.StudentDto;
import com.example.university.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") Long studentId) {
        return new ResponseEntity<>(studentService.getById(studentId), HttpStatus.OK);
    }

//    @PostMapping("/student-create")
//    public ResponseEntity<StudentDto> addStudent(StudentDto student) {
//        StudentDto studentDto = studentService.createStudent(student);
//        return new ResponseEntity<>(studentDto, HttpStatus.OK);
//    }
}