package com.dh.userservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"users"})
public class Rol {

    private Long id;

    private UserRoles name;

    @ToString.Exclude
    private Set<User> users;

}
