package com.dh.userservice.domain.mapper;


import com.dh.userservice.domain.dto.response.UserResponseDetailDto;
import com.dh.userservice.domain.dto.response.UserResponseDto;
import org.keycloak.representations.idm.UserRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target= "userName", source = "username")
    public abstract UserResponseDto toUserResponseDto(UserRepresentation userRepresentation);

    @Mapping(target = "userName", source = "username")
    public abstract UserResponseDetailDto userRespresentationToUserResponseDetailDto(UserRepresentation userRepresentation);

}