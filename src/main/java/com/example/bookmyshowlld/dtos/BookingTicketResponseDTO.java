package com.example.bookmyshowlld.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingTicketResponseDTO {
    private int bookingId;
    private int amount;
    private ResponseStatus responseStatus;
}
