package com.dh.userservice.domain.repository;

import com.dh.userservice.domain.dto.UserResponseDetailDto;
import com.dh.userservice.domain.dto.UserResponseDto;

import com.dh.userservice.domain.mapper.UserMapper;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class KeyCloakUserRepository implements IUserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Keycloak keycloak;

    @Value("${us.keycloak.server.realm}")
    private String realm;

    @Override
    public List<UserResponseDto> findNotAdmin() {

        List<UserRepresentation> usersRepresentation = keycloak.realm(realm).users().list();

        List<UserResponseDto> usersResponse = new ArrayList<>();

        for (UserRepresentation userRepresentation : usersRepresentation ) {
            List<GroupRepresentation> groupsRepresentation = keycloak.realm(realm).users().get(userRepresentation.getId()).groups();
            List<String> groups = new ArrayList<>();
            for (GroupRepresentation groupRepresentation : groupsRepresentation) {
                groups.add(groupRepresentation.getName());
            }

            if (!groups.contains("admin")){
                    usersResponse.add(userMapper.toUserResponseDto(userRepresentation));
            }
        }
        return usersResponse;
    }

    @Override
    public UserResponseDetailDto findById(String id) {
        UserRepresentation user = keycloak.realm(realm).users().get(id).toRepresentation();
        return userMapper.userRespresentationToUserResponseDetailDto(user);
    }

    @Override
    public UserResponseDetailDto findByUserName(String userName) {
        UserRepresentation userRepresentation = keycloak.realm(realm).users().search(userName).get(0);
        return userMapper.userRespresentationToUserResponseDetailDto(userRepresentation);
    }

}
