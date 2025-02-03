package com.project.recipeManagementAPI.service;

import com.project.recipeManagementAPI.domain.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<UserEntity> getAllUser();
    List<UserEntity> getAllUserByUsernameIgnoreCase(String username);
    UserEntity getUserByEmail(String email);
    UserEntity createUser(UserEntity userEntity);
    UserEntity partialUpdateUser(UUID id, UserEntity userEntity);
}
