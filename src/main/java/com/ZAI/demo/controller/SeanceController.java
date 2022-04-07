package com.ZAI.demo.controller;

import com.ZAI.demo.models.Seance;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.services.SeanceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/seance")
public class SeanceController {
    private final SeanceService seanceService;

    @PostMapping("/add")
    public ResponseEntity<String> addSeance(@Valid @RequestBody Seance seance){
        seanceService.addSeance(seance);
        return new ResponseEntity<>("Seance added succesfully", HttpStatus.OK);
    }

    @PostMapping("/modify")
    public ResponseEntity<Seance> modifySeance(@Valid @RequestBody Seance seance){
        Seance mseance = seanceService.modifySeance(seance);
        return new ResponseEntity<>(mseance, HttpStatus.OK);

    }

    @GetMapping("/displayAll")
    public ResponseEntity<List<Seance>> displaySeances(){
        List<Seance> seance = seanceService.displayAll();
        return new ResponseEntity<>(seance, HttpStatus.OK);
    }

}
