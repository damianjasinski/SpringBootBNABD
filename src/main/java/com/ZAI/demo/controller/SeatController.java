package com.ZAI.demo.controller;

import com.ZAI.demo.models.Seance;
import com.ZAI.demo.models.Seat;
import com.ZAI.demo.services.SeanceService;
import com.ZAI.demo.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/seat")
public class SeatController {
    private final SeatService seatService;

    @PostMapping("/get/reserved")
    public ResponseEntity<Map<String, List<Seat>>> getReservedSeats(@Valid @RequestBody Seance seance){
        List<Seat> reservedSeats = seatService.returnReservedSeats(seance);
        return new ResponseEntity<>(Map.of("Seance added succesfully", reservedSeats), HttpStatus.OK);
    }
}
