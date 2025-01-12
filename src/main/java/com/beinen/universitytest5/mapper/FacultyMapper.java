package com.beinen.universitytest5.mapper;

import com.beinen.universitytest5.model.Faculty;
import com.beinen.universitytest5.rest.dto.CreateFacultyRequest;
import com.beinen.universitytest5.rest.dto.FacultyResponse;
import com.beinen.universitytest5.rest.dto.UpdateFacultyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface FacultyMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "university", ignore = true)
    Faculty toFaculty(CreateFacultyRequest createFacultyRequest);

    FacultyResponse toFacultyResponse(Faculty faculty);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "university", ignore = true)
    void updateFacultyFromRequest(UpdateFacultyRequest updateFacultyRequest, @MappingTarget Faculty faculty);
}