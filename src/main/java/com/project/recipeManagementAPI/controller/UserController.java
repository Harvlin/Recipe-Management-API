package com.project.recipeManagementAPI.controller;

import com.project.recipeManagementAPI.domain.dto.UserDto;
import com.project.recipeManagementAPI.domain.entity.UserEntity;
import com.project.recipeManagementAPI.mapper.UserMapper;
import com.project.recipeManagementAPI.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/users")
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserEntity> userEntities = userService.getAllUser();
        List<UserDto> userDtos = userEntities.stream().map(userMapper::toDto).toList();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<List<UserDto>> getAllUserByUsernameIgnoreCase(@PathVariable String username) {
        List<UserEntity> userEntities = userService.getAllUserByUsernameIgnoreCase(username);
        List<UserDto> userDtos = userEntities.stream().map(userMapper::toDto).toList();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        UserEntity userEntity = userService.getUserByEmail(email);
        UserDto userDto = userMapper.toDto(userEntity);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto createUserReq) {
        UserEntity userEntity = userMapper.toEntity(createUserReq);
        UserEntity savedUserEntity = userService.createUser(userEntity);
        return new ResponseEntity<>(userMapper.toDto(savedUserEntity), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UserDto> partialUpdateUser(@Valid @RequestBody UserDto updateUserReq, @PathVariable UUID id) {
        UserEntity userEntity = userMapper.toEntity(updateUserReq);
        UserEntity updatedUserEntity = userService.partialUpdateUser(id, userEntity);
        return new ResponseEntity<>(userMapper.toDto(updatedUserEntity), HttpStatus.OK);
    }
}
