package com.beinen.universitytest5.service;

import com.beinen.universitytest5.model.Student;

public interface StudentService {
    Student validateAndGetStudent(Long id);

    Student saveStudent(Student student);
}