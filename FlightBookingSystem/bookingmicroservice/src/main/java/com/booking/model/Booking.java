package com.booking.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String passengerName;
    private String email;
    private String flightNumber;
    private LocalDate travelDate;
    private String seatNumber;
    private Double amount;
}

