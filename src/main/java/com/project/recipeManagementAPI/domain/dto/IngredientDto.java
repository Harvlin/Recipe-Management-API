package com.project.recipeManagementAPI.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientDto {
    private UUID id;

    private String name;
    private String quantity;

    private RecipeDto recipeDto;
}
