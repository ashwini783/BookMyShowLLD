package com.example.bookmyshowlld.controllers;

import com.example.bookmyshowlld.dtos.BookingTicketRequestDTO;
import com.example.bookmyshowlld.dtos.BookingTicketResponseDTO;
import com.example.bookmyshowlld.dtos.ResponseStatus;
import com.example.bookmyshowlld.models.Booking;
import com.example.bookmyshowlld.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    BookingTicketResponseDTO bookTicket(BookingTicketRequestDTO request){
        BookingTicketResponseDTO response =new BookingTicketResponseDTO();

        try{
            Booking booking= bookingService.bookTicket(request.getShowSeatIds(),request.getShowId(),request.getUserId());
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            response.setResponseStatus(ResponseStatus.FAILED);
        }
        return response;
    }
}
