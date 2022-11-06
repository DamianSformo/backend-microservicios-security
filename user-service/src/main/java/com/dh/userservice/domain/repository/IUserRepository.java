package com.dh.userservice.domain.repository;

import com.dh.userservice.domain.dto.UserNotAdminDto;
import com.dh.userservice.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository {

    public List<UserNotAdminDto> findAll();
    public UserNotAdminDto findById(String id);

    public List<UserNotAdminDto> findByName(String name);


}
