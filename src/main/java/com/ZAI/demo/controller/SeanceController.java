package com.ZAI.demo.controller;

import com.ZAI.demo.models.Seance;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.services.SeanceService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Data
@RestController
@RequestMapping("/api/seance")
public class SeanceController {
    private final SeanceService seanceService;

    @PostMapping("/add")
    public void addSeance(@RequestBody Seance seance){
        seanceService.addSeance(seance);
    }

    @PostMapping("/modify")
    public void modifySeance(@RequestBody Seance seance){
        seanceService.modifySeance(seance);
    }

    @PostMapping("/displayAll")
    public List<Seance> displaySeances(){
        return seanceService.displayAll();
    }

}
