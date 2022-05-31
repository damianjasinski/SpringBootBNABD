package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Category;
import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Seat;
import com.ZAI.demo.models.Titles;
import com.ZAI.demo.repository.CategoryRepository;
import com.ZAI.demo.repository.TitlesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class TitlesService {
    private final TitlesRepository titlesRepository;
    private final CategoryRepository categoryRepository;

    public Titles addTitles(Titles titles) {
        List<Category> categories = categoryRepository.findAllById(titles.getCategoriesId());
        if (categories.size() == 0) {
            throw new NotFoundException("Category not found");
        }
        if (categories.size() != titles.getCategoriesId().size()) {
            throw new NotFoundException("Category not found");
        } else {
            Set<Category> categorySet = titles.getCategorySet();
            if (categorySet == null) {
                categorySet = new HashSet<>();
            }
            categorySet.addAll(categories);
            titles.setCategorySet(categorySet);
            return titlesRepository.save(titles);
        }

    }

    public Titles removeTitles(String name) {
        Optional<Titles> titles = titlesRepository.findByName(name);
        if (titles.isPresent()) {
            titlesRepository.deleteById(titles.get().getId());
            return titles.get();
        } else {
            throw new NotFoundException("Title not found");
        }
    }
}
