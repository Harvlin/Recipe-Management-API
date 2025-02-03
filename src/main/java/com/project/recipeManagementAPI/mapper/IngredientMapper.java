package com.project.recipeManagementAPI.mapper;

import com.project.recipeManagementAPI.domain.dto.IngredientDto;
import com.project.recipeManagementAPI.domain.entity.IngredientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IngredientMapper {

    IngredientDto toDto(IngredientEntity ingredientEntity);
    IngredientEntity toEntity(IngredientDto ingredientDto);

}
