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

    public List<RoomDTO> getAllRooms(int page, int size) {
        return roomRepository.findAll(PageRequest.of(page, size)).stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    public RoomDTO createRoom(RoomDTO roomDTO) {
        Room room = roomRepository.save(RoomMapper.toEntity(roomDTO));
        return RoomMapper.toDto(room);
    }

    public List<RoomDTO> getAvailableRooms(int page, int size, LocalDate startDate, LocalDate endDate) {
        return roomRepository.findAvailableRooms(startDate, endDate, PageRequest.of(page, size)).stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RoomDTO> getRoomsByExtras(int page, int size, List<String> extras) {
        long numExtras = extras.size();
        return roomRepository.findRoomsByExtras(extras, numExtras, PageRequest.of(page, size)).stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<RoomDTO> getRoomsByAvailabilityAndExtras(int page, int size, LocalDate startDate, LocalDate endDate, List<String> extras) {
        long numExtras = extras.size();
        return roomRepository.findRoomsByAvailabilityAndExtras(startDate, endDate, extras, numExtras, PageRequest.of(page, size)).stream()
                .map(RoomMapper::toDto)
                .collect(Collectors.toList());
    }
}