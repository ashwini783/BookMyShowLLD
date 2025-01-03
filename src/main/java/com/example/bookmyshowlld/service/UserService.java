package com.example.bookmyshowlld.service;

import com.example.bookmyshowlld.models.User;
import com.example.bookmyshowlld.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UserService {
        private UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository=userRepository;
        }

    public User signUp(String email, String password){
        //check if the email is already registered
           Optional<User> userOptional=userRepository.findByEmail(email);
           if(userOptional.isPresent()){
               throw new RuntimeException("User already exists");
           }
           User user=new User();
           user.setEmail(email);
           user.setPassword(password);
//           user.setPassword("Temp User");
           user.setLastName("");
           user.setUserName(email);
           user.setBookings(new ArrayList<>());
           return userRepository.save(user);
    }
}
