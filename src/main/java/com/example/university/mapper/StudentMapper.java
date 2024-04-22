package com.example.university.mapper;

import com.example.university.student.dto.StudentDto;
import com.example.university.student.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    StudentDto toDto(Student student);

    Student toEntity(StudentDto studentDto);
}