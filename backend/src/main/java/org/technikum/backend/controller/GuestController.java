package org.technikum.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.technikum.backend.exception.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.technikum.backend.model.Guest;
import org.technikum.backend.service.GuestService;
import org.technikum.backend.dto.GuestDTO;

@RestController
@RequestMapping("/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody GuestDTO guestDTO) {
        Guest createdGuest = guestService.createGuest(guestDTO);
        return ResponseEntity.ok(createdGuest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuestDTO> updateGuest(@PathVariable int id, @RequestBody GuestDTO updatedGuestDTO) {
        GuestDTO guestDTO = guestService.updateGuest(id, updatedGuestDTO);
        return ResponseEntity.ok(guestDTO);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}