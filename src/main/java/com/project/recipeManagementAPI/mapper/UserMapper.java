package com.project.recipeManagementAPI.mapper;

import com.project.recipeManagementAPI.domain.dto.UserDto;
import com.project.recipeManagementAPI.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "recipeDtos", source = "recipeEntities")
    UserDto toDto(UserEntity userEntity);
    UserEntity toEntity(UserDto userDto);
}
