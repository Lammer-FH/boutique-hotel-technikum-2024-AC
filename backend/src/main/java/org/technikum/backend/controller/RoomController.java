package org.technikum.backend.controller;

import org.technikum.backend.dto.RoomDTO;
import org.technikum.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomDTO> getRooms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam(required = false) List<String> extras) {

        if (startDate != null && endDate != null && extras != null && !extras.isEmpty()) {
            return roomService.getRoomsByAvailabilityAndExtras(page, size, startDate, endDate, extras);
        } else if (startDate != null && endDate != null) {
            return roomService.getAvailableRooms(page, size, startDate, endDate);
        } else if (extras != null && !extras.isEmpty()) {
            return roomService.getRoomsByExtras(page, size, extras);
        } else {
            return roomService.getAllRooms(page, size);
        }
    }

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.createRoom(roomDTO);
    }
}