package org.technikum.backend.service;

import org.technikum.backend.dto.RoomDTO;
import org.technikum.backend.model.Room;
import org.technikum.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDTO> getAllRooms(int page, int size) {
        List<Room> rooms = roomRepository.findAll(PageRequest.of(page, size)).getContent();
        return rooms.stream().map(RoomMapper::toDto).collect(Collectors.toList());
    }

    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = RoomMapper.toEntity(roomDTO);
        room = roomRepository.save(room);
        return RoomMapper.toDto(room);
    }
}
