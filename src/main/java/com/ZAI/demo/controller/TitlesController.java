package com.ZAI.demo.controller;

import com.ZAI.demo.models.Titles;
import com.ZAI.demo.services.TitlesService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Data
@RestController
@RequestMapping("/api/titles")
public class TitlesController {
    private final TitlesService titlesService;

    @PostMapping("/add")
    public ResponseEntity<Titles> addTitles(@Valid @RequestBody Titles titles){
        titlesService.addTitles(titles);
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{name}")
    public ResponseEntity<String> removeSeance(@PathVariable String name){
        titlesService.removeTitles(name);
        return new ResponseEntity<>("Title removed succesfully", HttpStatus.OK);
    }

}
