package com.dh.userservice.domain.repository;

import com.dh.userservice.domain.dto.UserNotAdminDto;
import com.dh.userservice.domain.model.User;
import com.dh.userservice.domain.model.UserRoles;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class KeyCloakUserRepository implements IUserRepository{

    @Autowired
    private Keycloak keycloak;

    @Value("${us.keycloak.server.realm}")
    private String realm;

    @Override
    public List<UserNotAdminDto> findAll() {

        List<UserRepresentation> userRepresentations = keycloak.realm(realm).users().list();
        List<UserRepresentation> userEnable = userRepresentations.stream().filter(userRepresentation -> userRepresentation.getGroups().stream())
        //return userRepresentations.stream().map(this::toUserNotAdminDto).collect(Collectors.toList());
        List<UserNotAdminDto> userNotAdminDto = new ArrayList<>();
        for(UserRepresentation userRepresentation : userRepresentations){
            if(!userRepresentation.getRealmRoles().contains("ROLE_ADMIN")){
                userNotAdminDto.add(toUserNotAdminDto(userRepresentation));
            }
        }
        return userNotAdminDto;
    }

    @Override
    public UserNotAdminDto findById(String id) {
        UserRepresentation user = keycloak.realm(realm).users().get(id).toRepresentation();
        return toUserNotAdminDto(user);
    }

    @Override
    public List<UserNotAdminDto> findByName(String name) {
        List<UserRepresentation> userRepresentations = keycloak.realm(realm).users().search(name);
        return userRepresentations.stream().map(this::toUserNotAdminDto).collect(Collectors.toList());
    }

    private UserNotAdminDto toUserNotAdminDto(UserRepresentation userRepresentation){
        return UserNotAdminDto.builder()
                .userName(userRepresentation.getUsername())
                .email(userRepresentation.getEmail())
                .build();
    }
}
