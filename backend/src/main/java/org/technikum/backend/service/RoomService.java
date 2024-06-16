package org.technikum.backend.service;

import org.technikum.backend.dto.RoomDTO;
import org.technikum.backend.model.Room;
import org.technikum.backend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomMapper roomMapper;

    public List<RoomDTO> getAllRooms(int page, int size) {
        List<Room> rooms = roomRepository.findAll(PageRequest.of(page, size)).getContent();
        return rooms.stream().map(roomMapper::toDto).collect(Collectors.toList());
    }

    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = roomMapper.toEntity(roomDTO);
        room = roomRepository.save(room);
        return roomMapper.toDto(room);
    }

    public List<RoomDTO> getAvailableRooms(int page, int size, LocalDate startDate, LocalDate endDate) {
        List<Room> availableRooms = roomRepository.findAvailableRooms(startDate, endDate, PageRequest.of(page, size));
        return availableRooms.stream().map(roomMapper::toDto).collect(Collectors.toList());
    }
}