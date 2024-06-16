package org.technikum.backend.service;

import org.springframework.stereotype.Component;
import org.technikum.backend.dto.BookingDTO;
import org.technikum.backend.model.Booking;

@Component
public class BookingMapper {

    public static BookingDTO toDto(Booking booking) {
        if (booking == null)
            return null;

        return BookingDTO.builder()
                .id(booking.getId())
                .room(RoomMapper.toDto(booking.getRoom()))
                .guest(GuestMapper.toDto(booking.getGuest()))
                .startDate(booking.getStartDate())
                .endDate(booking.getEndDate())
                .breakfast(booking.isBreakfast())
                .build();
    }

    public static Booking toEntity(BookingDTO dto) {
        if (dto == null)
            return null;

        Booking booking = new Booking();
        booking.setId(dto.getId());
        booking.setRoom(RoomMapper.toEntity(dto.getRoom()));
        booking.setGuest(GuestMapper.toEntity(dto.getGuest()));
        booking.setStartDate(dto.getStartDate());
        booking.setEndDate(dto.getEndDate());
        booking.setBreakfast(dto.isBreakfast());

        return booking;
    }
}