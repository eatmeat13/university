package com.example.university.student.service;

import com.example.university.mapper.StudentMapper;
import com.example.university.student.dto.StudentDto;
import com.example.university.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.management.openmbean.InvalidKeyException;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDto getById(Long id) {
        var student = studentRepository.findById(id);
        if (student.isPresent()) {
            return studentMapper.studentToStudentDTO(student.get());
        } else throw new InvalidKeyException();
    }

//    public StudentDto createStudent(StudentDto studentDto) {
//        Student student = studentMapper.studentDTOToStudent(studentDto);
//        Student savedStudent = studentRepository.save(student);
//        return studentMapper.studentToStudentDTO(savedStudent);
//    }
}
