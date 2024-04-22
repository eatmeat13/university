package com.example.university.student.controller;


import com.example.university.mapper.StudentMapper;
import com.example.university.student.dto.StudentDto;
import com.example.university.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") UUID studentId) {
        return new ResponseEntity<>(studentService.getById(studentId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentDto> postStudent(@RequestBody StudentDto studentDto) {

        var student = studentMapper.toEntity(studentDto);
        student.setId(UUID.randomUUID());
        studentService.createStudent(student);
        return new ResponseEntity<>(studentMapper.toDto(student), HttpStatus.OK);
    }

    @GetMapping("/delete/{studentId}")
    public ResponseEntity<StudentDto> postStudent(@PathVariable("studentId") UUID studentId) {

        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update/{studentId}")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto,
                                                    @PathVariable UUID studentId) {
        var student = studentMapper.toEntity(studentDto);
        student.setId(studentId);
        studentService.createStudent(student);
        return new ResponseEntity<>(studentMapper.toDto(student), HttpStatus.OK);
    }
}