package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Category;
import com.ZAI.demo.models.Titles;
import com.ZAI.demo.repository.CategoryRepository;
import com.ZAI.demo.repository.TitlesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class TitlesService {
    private final TitlesRepository titlesRepository;
    private final CategoryRepository categoryRepository;

    public void addTitles(Titles titles){
        List<Category> categories = categoryRepository.findAllById(titles.getCategoriesId());

        if (categories.size() != titles.getCategoriesId().size()){
            throw new NotFoundException("Category not found");
        }else{
            titles.setCategorySet(Set.copyOf(categories));
            titlesRepository.save(titles);
        }

        System.out.println(titles.getCategoriesId());

    }

    public void removeTitles(String name){
        Optional <Titles> titles = titlesRepository.findByName(name);
        if (titles.isPresent()){
            titlesRepository.deleteById(titles.get().getId());
        }else{
            throw new NotFoundException("Title not found");
        }
    }
}
