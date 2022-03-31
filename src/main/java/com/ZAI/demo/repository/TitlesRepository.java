package com.ZAI.demo.repository;

import com.ZAI.demo.models.Titles;
import com.ZAI.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitlesRepository extends JpaRepository<Titles, Long> {
    Optional<Titles> findByName(String name);
}
