package com.ZAI.demo.repository;

import com.ZAI.demo.models.Category;
import com.ZAI.demo.models.Titles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository <Category, Long>{
    Optional<Category> findByName(String name);
}
