package com.dh.userservice.domain.repository;

import com.dh.userservice.domain.dto.response.UserResponseDetailDto;
import com.dh.userservice.domain.dto.response.UserResponseDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {

    public List<UserResponseDto> findNotAdmin();

    public UserResponseDetailDto findById(String id);

    public UserResponseDetailDto findByUserName(String name);

}
