package com.project.recipeManagementAPI.repository;

import com.project.recipeManagementAPI.domain.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, UUID> {
}
