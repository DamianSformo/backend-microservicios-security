package com.dh.userservice.api.service;

import com.dh.userservice.Exceptions.BadRequestException;
import com.dh.userservice.Exceptions.ResourceNotFoundException;
import com.dh.userservice.domain.dto.UserNotAdminDto;
import com.dh.userservice.domain.dto.UserShowDto;
import com.dh.userservice.domain.model.AuthenticationRequest;
import com.dh.userservice.domain.model.Rol;
import com.dh.userservice.domain.model.User;
import com.dh.userservice.domain.model.UserRoles;
import com.dh.userservice.domain.repository.IUserRepository;
import com.dh.userservice.shared.GenericServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService{

    private final IUserRepository userRepository;

    public List<UserNotAdminDto> findAll(){
        return userRepository.findAll();
    }

    public UserNotAdminDto findById(String id){
        return userRepository.findById(id);
    }

    public List<UserNotAdminDto> findByName(String name){
        return userRepository.findByName(name);
    }

}
