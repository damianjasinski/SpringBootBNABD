package com.ZAI.demo.controller;

import com.ZAI.demo.models.Seat;
import com.ZAI.demo.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/seat")
public class SeatController {
    private final SeatService seatService;

    @GetMapping("/get/reserved/{seanceId}")
    public ResponseEntity<Map<String, List<Seat>>> getAvailableSeats(@PathVariable long seanceId){
        List<Seat> reservedSeats = seatService.getAvailableSeats(seanceId);
        return new ResponseEntity<>(Map.of("available seats", reservedSeats), HttpStatus.OK);
    }
}
