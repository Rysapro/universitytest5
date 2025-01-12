package com.beinen.universitytest5.rest;

import com.beinen.universitytest5.mapper.FacultyMapper;
import com.beinen.universitytest5.model.Faculty;
import com.beinen.universitytest5.model.University;
import com.beinen.universitytest5.repository.FacultyRepository;
import com.beinen.universitytest5.rest.dto.CreateFacultyRequest;
import com.beinen.universitytest5.rest.dto.FacultyResponse;
import com.beinen.universitytest5.rest.dto.UpdateFacultyRequest;
import com.beinen.universitytest5.service.FacultyService;
import com.beinen.universitytest5.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/university")
public class FacultyController {

    private final FacultyService facultyService;
    private final FacultyMapper facultyMapper;
    private final UniversityService universityService;


    public FacultyController(FacultyService facultyService, FacultyMapper facultyMapper, UniversityService universityService) {
        this.facultyService = facultyService;
        this.facultyMapper = facultyMapper;
        this.universityService = universityService;
    }

    @GetMapping("/{universityId}/faculty/{facultyId}")
    public FacultyResponse getFaculty(@PathVariable Long universityId, @PathVariable Long facultyId){
        Faculty faculty = facultyService.validateAndGetFaculty(facultyId, universityId);
        return facultyMapper.toFacultyResponse(faculty);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{universityId}/faculty")
    public FacultyResponse createFaculty(@PathVariable Long universityId,
                                         @Valid @RequestBody CreateFacultyRequest createFacultyRequest){
        University university = universityService.validateAndGetUniversity(universityId);
        Faculty faculty = facultyMapper.toFaculty(createFacultyRequest);
        faculty.addUniversity(university);
        faculty = facultyService.saveFaculty(faculty);
        return facultyMapper.toFacultyResponse(faculty);
    }

    @PutMapping("/{universityId}/faculty/{facultyId}")
    public FacultyResponse updateFaculty(@PathVariable Long universityId,
                                         @PathVariable Long facultyId,
                                         @Valid @RequestBody UpdateFacultyRequest updateFacultyRequest){
        Faculty faculty = facultyService.validateAndGetFaculty(facultyId, universityId);
        facultyMapper.updateFacultyFromRequest(updateFacultyRequest, faculty);
        faculty = facultyService.saveFaculty(faculty);
        return facultyMapper.toFacultyResponse(faculty);
    }

    @DeleteMapping("/{universityId}/faculty/{facultyId}")
    public FacultyResponse deleteFaculty(@PathVariable Long universityId, @PathVariable Long facultyId){
        Faculty faculty = facultyService.validateAndGetFaculty(facultyId, universityId);
        facultyService.deleteFaculty(faculty);
        return facultyMapper.toFacultyResponse(faculty);
    }


}