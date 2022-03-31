package com.ZAI.demo.services;

import com.ZAI.demo.models.Room;
import com.ZAI.demo.models.Seance;
import com.ZAI.demo.repository.RoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public void addRoom(Room room){
        roomRepository.save(room);
    }
}
