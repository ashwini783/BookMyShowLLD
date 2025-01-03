package com.example.bookmyshowlld.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String name;

    @OneToMany
    private List<Seat> seats;

    @ManyToOne
    private Theatre theatre;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

    private int dimn;
}
//birectional eg Movie and Theatre (Movie is in Theatre and Theatre is present in Movie)
//one to many cardinality of unidirectional RelationShip eg Screen and Seat ..it creat extra table
//how to stop it