package com.project.recipeManagementAPI.mapper;

import com.project.recipeManagementAPI.domain.dto.RecipeDto;
import com.project.recipeManagementAPI.domain.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RecipeMapper {
    RecipeDto toDto(RecipeEntity recipeEntity);
    RecipeEntity toEntity(RecipeDto recipeDto);
}
