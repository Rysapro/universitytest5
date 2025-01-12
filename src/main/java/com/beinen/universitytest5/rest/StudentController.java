package com.beinen.universitytest5.rest;

import com.beinen.universitytest5.mapper.StudentMapper;
import com.beinen.universitytest5.model.Faculty;
import com.beinen.universitytest5.model.Student;
import com.beinen.universitytest5.model.University;
import com.beinen.universitytest5.rest.dto.CreateStudentRequest;
import com.beinen.universitytest5.rest.dto.StudentResponse;
import com.beinen.universitytest5.service.FacultyService;
import com.beinen.universitytest5.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/university")
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final FacultyService facultyService;

    public StudentController(StudentService studentService, StudentMapper studentMapper, FacultyService facultyService) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.facultyService = facultyService;
    }

    @GetMapping("/{universityId}/faculty/{facultyId}/student/{studentId}")
    public StudentResponse getStudent(
            @PathVariable Long facultyId,
            @PathVariable Long studentId) {
        Student student = studentService.validateAndGetStudent(facultyId, studentId);
        return studentMapper.toStudentResponse(student);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{universityId}/faculty/{facultyId}/student")
    public StudentResponse createStudent(@PathVariable Long facultyId, Long universityId,
            @Valid @RequestBody CreateStudentRequest createStudentRequest) {
//        Faculty faculty = facultyService.validateAndGetFaculty(facultyId, universityId);
        Student student = studentMapper.toStudent(createStudentRequest);
//        student.addFaculty(faculty);
        student = studentService.saveStudent(student);
        return studentMapper.toStudentResponse(student);
    }


}