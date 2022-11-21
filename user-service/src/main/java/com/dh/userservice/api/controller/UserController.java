package com.dh.userservice.api.controller;

import com.dh.userservice.api.service.UserService;
import com.dh.userservice.domain.dto.response.UserResponseDetailDto;
import com.dh.userservice.domain.dto.response.UserResponseDto;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RefreshScope
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/admin/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDetailDto findById(@PathVariable String id) {
        return userService.findById(id);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserResponseDto> findNotAdmin(){
        return userService.findNotAdmin();
    }

    @GetMapping("/admin/userName/{userName}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserResponseDetailDto findByUserNameForAdmin(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @GetMapping("/userName/{userName}")
    public UserResponseDetailDto findByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

}
