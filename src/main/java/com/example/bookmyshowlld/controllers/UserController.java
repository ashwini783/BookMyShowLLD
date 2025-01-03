package com.example.bookmyshowlld.controllers;

import com.example.bookmyshowlld.dtos.ResponseStatus;
import com.example.bookmyshowlld.dtos.SignUpRequestDTO;
import com.example.bookmyshowlld.dtos.SignUpResponseDTO;
import com.example.bookmyshowlld.models.User;
import com.example.bookmyshowlld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDTO sighUp(SignUpRequestDTO request) {

        SignUpResponseDTO response = new SignUpResponseDTO();
        try{
            User user =userService.signUp(request.getEmail(), request.getPassword());
            response.setStatus(ResponseStatus.SUCCESS);
            response.setMessage("User Signed Up Successfully");
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILED);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
