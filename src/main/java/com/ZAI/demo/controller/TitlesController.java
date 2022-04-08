package com.ZAI.demo.controller;

import com.ZAI.demo.models.Titles;
import com.ZAI.demo.services.TitlesService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/titles")
public class TitlesController {
    private final TitlesService titlesService;

    @PostMapping("/add")
    public ResponseEntity<Titles> addTitles(@Valid @RequestBody Titles titles){
        Titles titles1 = titlesService.addTitles(titles);
        return new ResponseEntity<>(titles1, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{name}")
    public ResponseEntity<Map<String, Titles>> removeSeance(@PathVariable String name){
        Titles titles = titlesService.removeTitles(name);
        return new ResponseEntity<>(Map.of("Title removed succesfully", titles), HttpStatus.OK);
    }

}
