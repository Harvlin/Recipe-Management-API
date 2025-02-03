package com.project.recipeManagementAPI.mapper;

import com.project.recipeManagementAPI.domain.dto.CategoryDto;
import com.project.recipeManagementAPI.domain.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryDto toDto(CategoryEntity categoryEntity);
    CategoryEntity toEntity(CategoryDto categoryDto);
}
