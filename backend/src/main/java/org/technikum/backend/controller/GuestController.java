package org.technikum.backend.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public GuestDTO createGuest(@RequestBody GuestDTO guestDTO) {
        return guestService.createGuest(guestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable int id) {
        Optional<Guest> guest = guestService.getGuestById(id);
        return guest.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}