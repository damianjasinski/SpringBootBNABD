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

import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }
    public void addSeanceToRoom(Seance seance) {
        Optional<Room> room = roomRepository.findById(seance.getRoomId());
        if (room.isPresent()) {
            Room room1 = room.get();
            Set<Seance> seanceSet = room1.getSeanceSet();
            seanceSet.add(seance);
        }
    }
}
