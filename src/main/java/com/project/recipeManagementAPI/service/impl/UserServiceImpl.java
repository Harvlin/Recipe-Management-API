package com.project.recipeManagementAPI.service.impl;

import com.project.recipeManagementAPI.domain.entity.UserEntity;
import com.project.recipeManagementAPI.repository.UserRepository;
import com.project.recipeManagementAPI.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> getAllUserByUsernameIgnoreCase(String username) {
        return userRepository.findAllByUsernameIgnoreCase(username);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("user not found with email: " + email));
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        String email = userEntity.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("User already exist with email: " + email);
        }
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity partialUpdateUser(UUID id, UserEntity userEntity) {
        userEntity.setId(id);

        return userRepository.findById(id).map(existingUser -> {
            Optional.ofNullable(userEntity.getUsername()).ifPresent(existingUser::setUsername);
            Optional.ofNullable(userEntity.getEmail()).ifPresent(existingUser::setEmail);
            Optional.ofNullable(userEntity.getPassword()).ifPresent(existingUser::setPassword);
            Optional.ofNullable(userEntity.getRecipeEntities()).ifPresent(existingUser::setRecipeEntities);

            return userRepository.save(existingUser);
        }).orElseThrow(() -> new IllegalArgumentException("User does not exist"));
    }
}
