package com.ZAI.demo.controller;

import com.ZAI.demo.models.Room;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.services.RoomService;
import com.ZAI.demo.services.UsersService;
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
@RequestMapping("/api/room")
public class RoomController implements SecuredController {
    private final RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Room>> addRoom(@Valid @RequestBody Room room){
        Room room1 = roomService.addRoom(room);
        return new ResponseEntity<>(Map.of("Room added succesfully", room1), HttpStatus.OK);
    }

}
