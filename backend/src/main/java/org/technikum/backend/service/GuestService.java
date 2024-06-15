package org.technikum.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technikum.backend.model.Guest;
import org.technikum.backend.repository.GuestRepository;
import org.technikum.backend.dto.GuestDTO;
import java.util.List;
import java.util.Optional;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest createGuest(GuestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setFirstName(guestDTO.getFirstName());
        guest.setLastName(guestDTO.getLastName());
        guest.setEmail(guestDTO.getEmail());

        return guestRepository.save(guest);
    }

    public Optional<Guest> getGuestById(int id) {
        return guestRepository.findById(id);
    }

}