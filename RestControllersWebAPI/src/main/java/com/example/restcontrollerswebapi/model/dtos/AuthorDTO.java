package com.example.restcontrollerswebapi.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class AuthorDTO {

    private String name;


    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                ", name='" + name + '\'' +
                '}';
    }

}
