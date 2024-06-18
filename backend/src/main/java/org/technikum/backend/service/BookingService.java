package org.technikum.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technikum.backend.repository.BookingRepository;
import org.technikum.backend.dto.BookingDTO;
import org.technikum.backend.model.Booking;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        try {
            Booking booking = BookingMapper.toEntity(bookingDTO);
            Booking savedBooking = bookingRepository.save(booking);
            return BookingMapper.toDto(savedBooking);
        } catch (Exception e) {
            // Handle any unexpected exceptions or DataIntegrityViolationException
            // Log error or throw a custom exception if needed
            throw new RuntimeException("Failed to create booking: " + e.getMessage(), e);
        }
    }

    public Optional<BookingDTO> getBookingById(int id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.map(BookingMapper::toDto);
    }
}