package com.ZAI.demo.controller;

import com.ZAI.demo.models.Seat;
import com.ZAI.demo.models.SeatStatusResponse;
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

    @GetMapping("/get/available/{seanceId}")
    public ResponseEntity<Map<String, List<SeatStatusResponse>>> getAvailableSeats(@PathVariable long seanceId){
        List<SeatStatusResponse> reservedSeats = seatService.getAvailableSeats(seanceId);
        return new ResponseEntity<>(Map.of("seats", reservedSeats), HttpStatus.OK);
    }
}
