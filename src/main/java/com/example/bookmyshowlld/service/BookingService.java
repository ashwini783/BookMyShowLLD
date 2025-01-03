package com.example.bookmyshowlld.service;

import com.example.bookmyshowlld.models.*;
import com.example.bookmyshowlld.repositories.BookingRepository;
import com.example.bookmyshowlld.repositories.ShowRepository;
import com.example.bookmyshowlld.repositories.ShowSeatRepository;
import com.example.bookmyshowlld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    @Autowired
    BookingService(UserRepository userRepository, ShowRepository showRepository,
                   ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.userRepository=userRepository;
        this.showRepository=showRepository;
        this.showSeatRepository=showSeatRepository;
        this.bookingRepository=bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
     public Booking bookTicket(List<Integer> showSeatIds,int showId, int userId) {
        //1. get user using userId
        Optional<User>userOptional=userRepository.findById(userId);

        if(userOptional.isEmpty()) {
            throw  new RuntimeException("User not found");
        }
        User user=userOptional.get();

        //2.get show using showId
        Optional<Show> showOptional=showRepository.findById(showId);
        if(showOptional.isEmpty()) {
            throw new RuntimeException("Show not found");
        }
        Show show=showOptional.get();

        //-------Start Transaction--------- //I want one thread to enter this area
        //3. Get ShowSeats via ShowSeatIds
        List<ShowSeat> showSeats=showSeatRepository.findAllById(showSeatIds);

        //4. check for all seats are available
        for(ShowSeat showSeat:showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("Selected Show Seats are not available");
            }
        }
       // if yes mark seat as blocked
        for(ShowSeat showSeat:showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
        }
        showSeatRepository.saveAll(showSeats);
        //-------Stop Transaction---------

        //5. Calculate price
        //Price Calculator Service
        //Using Show get all showSeat types
        //travserse the list based on that, identify the price of your set

        //7.properly create the booking Object , save and return it
        Booking booking =new Booking();
        booking.setBookedBy(user);
        booking.setBookingDate(new Date());
        booking.setBookingStatus(BookingStatus.SUCCESSFUL);
        booking.setAmount(100);
        booking.setShowSeats(showSeats);

        return bookingRepository.save(booking);
        
     }
     // you need to inject the data and get it working
    //try converting it to REST API
    //Run on specific port
    //Try to hit this with multiple booking request to check for locking situation
}

