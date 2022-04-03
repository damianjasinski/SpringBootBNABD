package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Category;
import com.ZAI.demo.models.Titles;
import com.ZAI.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public void removeCategory(String name){
        Optional<Category> category = categoryRepository.findByName(name);
        if (category.isPresent()){
            categoryRepository.deleteById(category.get().getId());
        }else{
            throw new NotFoundException("Category not found exception");
        }
    }

}
