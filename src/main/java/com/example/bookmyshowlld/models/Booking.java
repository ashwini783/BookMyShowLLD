package com.example.bookmyshowlld.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Setter
@Getter
@Entity
public class Booking extends BaseModel {
    private int amount;

    @OneToMany(mappedBy = "booking")  //for bidirectional relationship .ie booking side owns the relationship
    private List<Payment> payments;

    @ManyToOne
    private User bookedBy;
    private Date bookingDate;

    //EnumType.STRING will store as it is as STRing
    @Enumerated(value= EnumType.STRING)   //no table is created for Enum ..EnumType.ORDINAL can store in the form of Integer
    private BookingStatus bookingStatus;

    @OneToMany    @JoinColumn(name="booking_id")  //to void extra table creation, booking_id is primary key
    private List<ShowSeat> showSeats;

}
