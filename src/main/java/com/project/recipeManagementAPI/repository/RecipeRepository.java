package com.project.recipeManagementAPI.repository;

import com.project.recipeManagementAPI.domain.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, UUID> {

    List<RecipeEntity> findAllByDifficulty(String difficulty);
    List<RecipeEntity> findAllByName(@Param("name") String name);
}
