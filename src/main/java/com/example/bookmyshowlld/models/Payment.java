package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends  BaseModel{
    private int amount;
    private String refNumber;
    private Date paymentDate;

    @Enumerated(value= EnumType.STRING)
    private PaymentMode paymentMode;

    @Enumerated(value= EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(value= EnumType.STRING)
    private PaymentGateway paymentGateway;

    @ManyToOne
    private Booking booking;


}
