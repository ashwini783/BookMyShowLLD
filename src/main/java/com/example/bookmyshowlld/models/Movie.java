package com.example.bookmyshowlld.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String title;
    private String director;
    private String year;
    private String genre;

    @ElementCollection
    private List<String> actors;

    @Enumerated(value= EnumType.STRING)
    @ElementCollection   //it will create separate table due to List
    private List<Language> languages;
    private Date releaseDate;
    private double length;

}
