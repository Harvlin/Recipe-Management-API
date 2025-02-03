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
public class ReviewDto {
    private UUID id;

    private int rating;

    private String comment;

    private RecipeDto recipeDto;
}
