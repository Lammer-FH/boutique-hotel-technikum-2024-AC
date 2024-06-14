package org.technikum.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technikum.backend.model.Guest;
import org.technikum.backend.repository.GuestRepository;
import org.technikum.backend.dto.GuestDTO;
import org.technikum.backend.exception.NotFoundException;
import java.util.List;

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

    public GuestDTO updateGuest(int guestId, GuestDTO updatedGuestDTO) {
        Guest existingGuest = guestRepository.findById(guestId)
                .orElseThrow(() -> new NotFoundException("Guest not found with id: " + guestId));

        if (!updatedGuestDTO.getFirstName().equals(existingGuest.getFirstName())) {
            existingGuest.setFirstName(updatedGuestDTO.getFirstName());
        }
        if (!updatedGuestDTO.getLastName().equals(existingGuest.getLastName())) {
            existingGuest.setLastName(updatedGuestDTO.getLastName());
        }
        if (!updatedGuestDTO.getEmail().equals(existingGuest.getEmail())) {
            existingGuest.setEmail(updatedGuestDTO.getEmail());
        }

        // Save the updated guest
        Guest savedGuest = guestRepository.save(existingGuest);
        return mapGuestToGuestDTO(savedGuest);
    }

    private GuestDTO mapGuestToGuestDTO(Guest guest) {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setFirstName(guest.getFirstName());
        guestDTO.setLastName(guest.getLastName());
        guestDTO.setEmail(guest.getEmail());
        return guestDTO;
    }

}