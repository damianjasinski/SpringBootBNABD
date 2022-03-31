package com.ZAI.demo.controller;

import com.ZAI.demo.models.Category;
import com.ZAI.demo.models.Titles;
import com.ZAI.demo.services.CategoryService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/controller")
public class CategoryController {
    public final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
        return new ResponseEntity<>(category, HttpStatus.OK); // co jak blad?
    }

    @DeleteMapping("/remove")
    public void deleteCategory(String name){ //request body?
        categoryService.removeCategory(name);
    }
}
