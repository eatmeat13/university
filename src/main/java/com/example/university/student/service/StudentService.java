package com.example.university.student.service;

import com.example.university.mapper.StudentMapper;
import com.example.university.student.dto.StudentDto;
import com.example.university.student.entity.Student;
import com.example.university.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.management.openmbean.InvalidKeyException;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDto getById(UUID id) {
        var student = studentRepository.findById(id);
        if (student.isPresent()) {
            return studentMapper.toDto(student.get());
        } else throw new InvalidKeyException();
    }

    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteStudent(UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        studentRepository.delete(student);
    }
}
