package com.casestudy.usermicroservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    @Column(unique = true)
    @Getter
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Getter
    private String password;


}
