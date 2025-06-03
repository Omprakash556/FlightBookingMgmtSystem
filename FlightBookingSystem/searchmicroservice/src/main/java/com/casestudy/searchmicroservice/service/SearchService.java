package com.casestudy.searchmicroservice.service;

import com.casestudy.searchmicroservice.model.Flight;
import com.casestudy.searchmicroservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private FlightRepository flightRepo;

    public List<Flight> searchFlights(String source, String destination, LocalDate date) {
        return flightRepo.findBySourceAndDestinationAndDate(source, destination, date);
    }
}

