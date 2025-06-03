package com.casestudy.searchmicroservice.repository;

import com.casestudy.searchmicroservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findBySourceAndDestinationAndDate(String source, String destination, LocalDate date);
}
