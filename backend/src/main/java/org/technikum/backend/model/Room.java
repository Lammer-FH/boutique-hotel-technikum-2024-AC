package org.technikum.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/* 
File is an entity which represents the table 'rooms' in the database.
It's a JPA model that maps the table columns to Java fields
*/ 

@Getter
@Setter
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    @Column(name = "guest_capacity")
    private int guestCapacity;

    @Column(name = "size_sqm")
    private int sizeSqm;
}
