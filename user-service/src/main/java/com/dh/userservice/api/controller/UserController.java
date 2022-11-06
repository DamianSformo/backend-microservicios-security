package com.dh.userservice.api.controller;

import com.dh.userservice.Exceptions.BadRequestException;
import com.dh.userservice.Exceptions.ResourceNotFoundException;
import com.dh.userservice.api.service.IUserService;
import com.dh.userservice.api.service.UserService;
import com.dh.userservice.domain.dto.UserNotAdminDto;
import com.dh.userservice.domain.dto.UserShowDto;
import com.dh.userservice.domain.model.AuthenticationRequest;
import com.dh.userservice.domain.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    //* ///////// NEW ///////// *//

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserNotAdminDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/name/{name}")
    public List<UserNotAdminDto> findByName(@PathVariable String name){
        return userService.findByName(name);
    }

    @GetMapping("/find")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String find(){
        return "traer usuarios";
    }

    @GetMapping("/test")
    @PreAuthorize("hasRole('ROLE_CLIENT')")
    public String test(){
        return "test";
    }


    //* ///////// POST ///////// *//




}
