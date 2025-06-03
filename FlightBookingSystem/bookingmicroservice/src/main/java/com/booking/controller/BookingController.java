package com.booking.controller;

import com.booking.model.Booking;
import com.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking book(@RequestBody Booking booking) {
        return service.bookFlight(booking);
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAllBookings();
    }

    @GetMapping("/{id}")
    public Booking getById(@PathVariable Long id) {
        return service.getBookingById(id);
    }
}

