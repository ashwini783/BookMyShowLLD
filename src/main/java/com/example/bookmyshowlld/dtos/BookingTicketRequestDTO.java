package com.example.bookmyshowlld.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookingTicketRequestDTO {
    private List<Integer> showSeatIds;
    private int showId;
    private int userId;
}
