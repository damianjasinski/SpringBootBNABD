package com.ZAI.demo.controller;

import com.ZAI.demo.models.Seance;
import com.ZAI.demo.models.SeatStatusResponse;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.services.SeanceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/seance")
public class SeanceController implements SecuredController {
    private final SeanceService seanceService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Seance>> addSeance(@Valid @RequestBody Seance seance){
        Seance seance1 = seanceService.addSeance(seance);
        return new ResponseEntity<>(Map.of("Seance added succesfully", seance1), HttpStatus.OK);
    }

    @PostMapping("/modify")
    public ResponseEntity<Seance> modifySeance(@Valid @RequestBody Seance seance){
        Seance mseance = seanceService.modifySeance(seance);
        return new ResponseEntity<>(mseance, HttpStatus.OK);

    }

//    @GetMapping("/get/all")
//    public ResponseEntity<Map<String, List<Seance>>> displaySeances(){
//        List<Seance> seance = seanceService.displayAll();
//        return new ResponseEntity<>(Map.of("seances", seance), HttpStatus.OK);
//    }

    @GetMapping("/get/all/{order}")
    public ResponseEntity<Map<String, List<Seance>>> getAvailableSeats(@PathVariable long order){
        List<Seance> seance = seanceService.displayAll(order);
        return new ResponseEntity<>(Map.of("seances", seance), HttpStatus.OK);
    }

    @GetMapping("/get/current")
    public ResponseEntity<Map<String, List<Seance>>> displayCurrentSeances() {
        List<Seance> seance = seanceService.displayCurrent();
        return new ResponseEntity<>(Map.of("seances", seance), HttpStatus.OK);
    }

}
