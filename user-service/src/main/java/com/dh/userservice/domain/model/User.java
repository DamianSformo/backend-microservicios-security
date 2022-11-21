package com.dh.userservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User{

    @Id
    @SequenceGenerator(name = "expenseSequence",sequenceName = "expenseSequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenseSequence")
    private Long id;

    private String userName;

    private String avatar;

    private String firstName;

    private String lastName;

}
