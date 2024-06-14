package org.technikum.backend.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.technikum.backend.exception.NotFoundException;
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

    public BookingDTO updateBooking(int bookingId, BookingDTO updatedBookingDTO) {
        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NotFoundException("Booking not found with id: " + bookingId));

        if (updatedBookingDTO.getRoomId() != existingBooking.getRoomId()) {
            existingBooking.setRoomId(updatedBookingDTO.getRoomId());
        }
        if (updatedBookingDTO.getGuestId() != existingBooking.getGuestId()) {
            existingBooking.setGuestId(updatedBookingDTO.getGuestId());
        }
        if (updatedBookingDTO.getStartDate() != null
                && !updatedBookingDTO.getStartDate().equals(existingBooking.getStartDate())) {
            existingBooking.setStartDate(updatedBookingDTO.getStartDate());
        }
        if (updatedBookingDTO.getEndDate() != null
                && !updatedBookingDTO.getEndDate().equals(existingBooking.getEndDate())) {
            existingBooking.setEndDate(updatedBookingDTO.getEndDate());
        }
        if (updatedBookingDTO.isBreakfast() != existingBooking.isBreakfast()) {
            existingBooking.setBreakfast(updatedBookingDTO.isBreakfast());
        }

        // Save the updated booking
        return mapBookingToBookingDTO(bookingRepository.save(existingBooking));
    }

    private BookingDTO mapBookingToBookingDTO(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setRoomId(booking.getRoomId());
        bookingDTO.setGuestId(booking.getGuestId());
        bookingDTO.setStartDate(booking.getStartDate());
        bookingDTO.setEndDate(booking.getEndDate());
        bookingDTO.setBreakfast(booking.isBreakfast());
        return bookingDTO;
    }

    public Optional<Booking> getBooking(int id) {
        return bookingRepository.findById(id);
    }
}
