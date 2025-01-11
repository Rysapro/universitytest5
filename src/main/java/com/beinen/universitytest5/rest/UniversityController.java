package com.beinen.universitytest5.rest;

import com.beinen.universitytest5.mapper.UniversityMapper;
import com.beinen.universitytest5.model.University;
import com.beinen.universitytest5.rest.dto.CreateUniversityRequest;
import com.beinen.universitytest5.rest.dto.UniversityResponse;
import com.beinen.universitytest5.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/university")
public class UniversityController {
    private final UniversityService universityService;
    private final UniversityMapper universityMapper;

    public UniversityController(UniversityService universityService, UniversityMapper universityMapper) {
        this.universityService = universityService;
        this.universityMapper = universityMapper;
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public UniversityResponse createUniversity(@Valid @RequestBody CreateUniversityRequest createUniversityRequest) {
        University university = universityMapper.toUniversity(createUniversityRequest);
        university = universityService.saveUniversity(university);
        return universityMapper.toUniversityResponse(university);
    }


}