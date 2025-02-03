package com.project.recipeManagementAPI.mapper;

import com.project.recipeManagementAPI.domain.dto.ReviewDto;
import com.project.recipeManagementAPI.domain.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {
    ReviewDto toDto(ReviewEntity reviewEntity);
    ReviewEntity toEntity(ReviewDto reviewDto);
}
