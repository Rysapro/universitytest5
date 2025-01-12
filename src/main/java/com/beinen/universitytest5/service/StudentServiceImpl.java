package com.beinen.universitytest5.service;

import com.beinen.universitytest5.exception.StudentNotFoundException;
import com.beinen.universitytest5.model.Student;
import com.beinen.universitytest5.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student validateAndGetStudent( Long studentId, Long facultyId) {
        return studentRepository.findByIdAndFacultyId(studentId, facultyId)
                .orElseThrow(() -> new StudentNotFoundException(studentId, facultyId));

    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}