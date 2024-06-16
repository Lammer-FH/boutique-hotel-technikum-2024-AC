package org.technikum.backend.service;

import org.springframework.stereotype.Component;
import org.technikum.backend.dto.GuestDTO;
import org.technikum.backend.model.Guest;

@Component
public class GuestMapper {

    public static GuestDTO toDto(Guest guest) {
        if (guest == null)
            return null;

        return GuestDTO.builder()
                .id(guest.getId())
                .firstName(guest.getFirstName())
                .lastName(guest.getLastName())
                .email(guest.getEmail())
                .build();
    }

    public static Guest toEntity(GuestDTO dto) {
        if (dto == null)
            return null;

        Guest guest = new Guest();
        guest.setId(dto.getId());
        guest.setFirstName(dto.getFirstName());
        guest.setLastName(dto.getLastName());
        guest.setEmail(dto.getEmail());

        return guest;
    }
}
