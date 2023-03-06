package com.example.restcontrollerswebapi.repositories;

import com.example.restcontrollerswebapi.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
