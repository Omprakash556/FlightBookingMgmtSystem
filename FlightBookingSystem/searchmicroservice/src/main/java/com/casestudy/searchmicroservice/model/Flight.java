package com.casestudy.searchmicroservice.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "flights")
@Getter
@Setter
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Airline is required")
    private String airline;

    @NotBlank(message = "Source is required")
    private String source;

    @NotBlank(message = "Destination is required")
    private String destination;

    @NotBlank(message = "Date is required")
    private LocalDate date;

    @NotBlank(message = "Departure time is required")
    private String departureTime;

    @NotBlank(message = "Arrival time is required")
    private String arrivalTime;

    @NotBlank(message = "Fare is required")
    @Positive(message = "Fare must be positive")
    private Double fare;

    @Positive(message = "Seat capacity must be zero or positive")
    private int seatCapacity;

    public void setDefaultSeatCapacity(){
        if(this.seatCapacity==0){
            this.seatCapacity=300;
        }
    }
}

