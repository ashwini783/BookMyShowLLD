package com.example.bookmyshowlld.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor

@MappedSuperclass  //this parent class is not actual entity or separate table, this is to ensure that I don't have redundant code
// this is just to ensure that I dont have redundant code, this class is not going to be separate table
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id //this if for primary key for all entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) //strategy to generate uniqueid
    private int id;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
