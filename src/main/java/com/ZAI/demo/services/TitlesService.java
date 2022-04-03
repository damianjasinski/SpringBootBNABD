package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Titles;
import com.ZAI.demo.repository.TitlesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class TitlesService {
    private final TitlesRepository titlesRepository;

    public void addTitles(Titles titles){
        titlesRepository.save(titles);
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
