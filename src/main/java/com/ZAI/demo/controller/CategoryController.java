package com.ZAI.demo.controller;

import com.ZAI.demo.models.Category;
import com.ZAI.demo.models.Titles;
import com.ZAI.demo.services.CategoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    public final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<String> addCategory(@Valid @RequestBody Category category){
        categoryService.addCategory(category);
        return new ResponseEntity<>("Category added succesfully", HttpStatus.OK);
    }

    @DeleteMapping("/remove/{category_name}")
    public ResponseEntity<String> deleteCategory(@PathVariable String category_name){
        categoryService.removeCategory(category_name);
        return new ResponseEntity<>("Category removed", HttpStatus.OK);
    }
}
