package com.booking.service;


import com.booking.model.Booking;
import com.booking.repo.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repo;

    public BookingService(BookingRepository repo) {
        this.repo = repo;
    }

    public Booking bookFlight(Booking booking) {
        return repo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return repo.findAll();
    }

    public Booking getBookingById(Long id) {
        return repo.findById(id).orElse(null);
    }
}

