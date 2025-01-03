package com.example.bookmyshowlld;

import com.example.bookmyshowlld.controllers.UserController;
import com.example.bookmyshowlld.dtos.SignUpRequestDTO;
import com.example.bookmyshowlld.dtos.SignUpResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BookMyShowLldApplication implements CommandLineRunner {
    @Autowired
    UserController userController;
    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDTO requestDTO=new SignUpRequestDTO();
        requestDTO.setEmail("test@gmail.com");
        requestDTO.setPassword("1234");

        SignUpResponseDTO responseDTO=userController.sighUp(requestDTO);
        System.out.println(responseDTO.getMessage());
    }
    public static void main(String[] args) {

        SpringApplication.run(BookMyShowLldApplication.class, args);


    }


}
//Generate table by running the code
//Book Ticket Feature Design