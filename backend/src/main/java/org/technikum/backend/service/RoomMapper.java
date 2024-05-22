package org.technikum.backend.service;

import org.technikum.backend.dto.RoomDTO;
import org.technikum.backend.model.Room;
import org.springframework.stereotype.Component;

/*
 * Used to convert between the Room Entity and 
 * the RoomDTO. This keeps the conversion logic in one place.
 */

@Component
public class RoomMapper {

    public RoomDTO toDto(Room room) {
        return RoomDTO.builder()
                .id(room.getId())
                .title(room.getTitle())
                .description(room.getDescription())
                .personCapacity(room.getPersonCapacity())
                .sizeSqm(room.getSizeSqm())
                .build();
    }

    public Room toEntity(RoomDTO dto) {
        Room room = new Room();
        room.setId(dto.getId());
        room.setTitle(dto.getTitle());
        room.setDescription(dto.getDescription());
        room.setPersonCapacity(dto.getPersonCapacity());
        room.setSizeSqm(dto.getSizeSqm());
        return room;
    }
}
