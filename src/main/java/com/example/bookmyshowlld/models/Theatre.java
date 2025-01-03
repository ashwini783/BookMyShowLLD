package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel {
    private String name;
    private String address;
//    private List<Screen> screens;
    @ManyToMany
    private List<Movie>movies;

    @ManyToOne
    private Region region;



}
