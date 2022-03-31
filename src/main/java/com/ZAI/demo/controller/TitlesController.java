package com.ZAI.demo.controller;

import com.ZAI.demo.models.Titles;
import com.ZAI.demo.services.TitlesService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("/api/titles")
public class TitlesController {
    private final TitlesService titlesService;

    @PostMapping("/add")
    public ResponseEntity<Titles> addTitles(@RequestBody Titles titles){
        titlesService.addTitles(titles);
        return new ResponseEntity<>(titles, HttpStatus.OK); // co jak blad?
    }

    @DeleteMapping("/remove/{name}")
    public void removeSeance(@PathVariable String name){ //request body?
        titlesService.removeTitles(name);
    }

}
