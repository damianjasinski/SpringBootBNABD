package com.ZAI.demo.services;

import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.models.Room;
import com.ZAI.demo.models.Seance;
import com.ZAI.demo.repository.RoomRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }
}
