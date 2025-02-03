package com.project.recipeManagementAPI.domain.dto;

import com.project.recipeManagementAPI.domain.Difficulty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto {
    private UUID id;

    private String name;
    private String description;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private UserDto userDto;

    private Set<IngredientDto> ingredientDtos;

    private Set<CategoryDto> categoryDtos;

    private Set<ReviewDto> reviewDtos;
}
