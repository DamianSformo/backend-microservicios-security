package com.dh.userservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"characters"})
public class User{

    private Long id;

    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol rol;
}
