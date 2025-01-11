package com.beinen.universitytest5.service;

import com.beinen.universitytest5.model.Student;
import com.beinen.universitytest5.repository.StudentRepository;
import com.beinen.universitytest5.repository.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student validateAndGetStudent(Long id) {
        return null;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}