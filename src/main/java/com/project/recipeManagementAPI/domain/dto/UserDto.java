package com.project.recipeManagementAPI.domain.dto;

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
public class UserDto {
    private UUID id;

    private String username;
    private String email;
    private String password;
    private Set<RecipeDto> recipeDtos;
}
