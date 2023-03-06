package com.example.restcontrollerswebapi.repositories;

import com.example.restcontrollerswebapi.model.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,  Long> {

    Optional<Author> findAuthorByName(String name);
}
