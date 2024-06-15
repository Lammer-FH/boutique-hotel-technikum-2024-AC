package org.technikum.backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technikum.backend.repository.BookingRepository;
import org.technikum.backend.dto.BookingDTO;
import org.technikum.backend.model.Booking;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setRoomId(bookingDTO.getRoomId());
        booking.setGuestId(bookingDTO.getGuestId());
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());
        booking.setBreakfast(bookingDTO.isBreakfast());

        // Optionally, perform additional validation or business logic here

        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBooking(int id) {
        return bookingRepository.findById(id);
    }
}
