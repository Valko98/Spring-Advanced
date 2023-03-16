package com.example.securitydemo.model.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
