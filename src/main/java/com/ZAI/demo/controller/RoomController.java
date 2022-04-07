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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/room")
public class RoomController{
    private final RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<String> addRoom(@Valid @RequestBody Room room){
        roomService.addRoom(room);
        return new ResponseEntity<>("Room added succesfully", HttpStatus.OK);
    }

}
