package com.casestudy.searchmicroservice.controller;

import com.casestudy.searchmicroservice.model.Flight;
import com.casestudy.searchmicroservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService service;

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getFlights(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        List<Flight> flights = service.searchFlights(source, destination, date);
        return ResponseEntity.ok(flights);
    }
}

