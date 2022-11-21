package com.dh.userservice.api.service;

import com.dh.userservice.Exceptions.ResourceNotFoundException;
import com.dh.userservice.domain.dto.UserResponseDetailDto;
import com.dh.userservice.domain.dto.UserResponseDto;
import com.dh.userservice.domain.mapper.UserMapper;
import com.dh.userservice.domain.model.User;
import com.dh.userservice.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    private final IUserRepository userRepository;

    public List<UserResponseDto> findNotAdmin(){
        return userRepository.findNotAdmin();
    }

    public UserResponseDetailDto findById(String id){
        return userRepository.findById(id);
    }

    public UserResponseDetailDto findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public void delete(Long aLong) throws ResourceNotFoundException {
    }
}
