package org.technikum.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}