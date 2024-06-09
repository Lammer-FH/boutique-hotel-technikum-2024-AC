package org.technikum.backend.service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technikum.backend.repository.BookingRepository;
import org.technikum.backend.model.Booking;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBooking(int id) {
        return bookingRepository.findById(id);
    }
}
