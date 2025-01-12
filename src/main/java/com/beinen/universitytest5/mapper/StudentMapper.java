package com.beinen.universitytest5.mapper;

import com.beinen.universitytest5.model.Student;
import com.beinen.universitytest5.rest.dto.CreateStudentRequest;
import com.beinen.universitytest5.rest.dto.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface StudentMapper {

    @Mapping(target = "id",  ignore = true)
    @Mapping(target = "faculty", ignore = true)
    Student toStudent (CreateStudentRequest createStudentRequest);

    StudentResponse toStudentResponse(Student student);
}