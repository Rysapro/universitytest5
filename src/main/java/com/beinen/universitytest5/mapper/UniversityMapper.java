package com.beinen.universitytest5.mapper;

import com.beinen.universitytest5.model.University;
import com.beinen.universitytest5.rest.dto.CreateUniversityRequest;
import com.beinen.universitytest5.rest.dto.UniversityResponse;
import com.beinen.universitytest5.rest.dto.UpdateUniversityRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UniversityMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "faculty", ignore = true)
    University toUniversity(CreateUniversityRequest createUniversityRequest);

    UniversityResponse toUniversityResponse(University university);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "faculty", ignore = true)
    void updateUniversityFromRequest(UpdateUniversityRequest updateUniversityRequest,
                                     @MappingTarget University university);
}