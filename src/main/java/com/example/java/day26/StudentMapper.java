package com.example.java.day26;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Author: zhaojie
 * @Date: 2022/1/24 18:19
 * @Version: 1.0
 * @Description:
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "gender",target = "sex")
    StudentDTO toDto(Student student);


}
