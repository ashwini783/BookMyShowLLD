package com.example.bookmyshowlld.models;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity

public class Region extends BaseModel{
    private String name;
    //Region and Theatre Relation is 1:M
    @OneToMany
    private List<Theatre> theatreList;
}
