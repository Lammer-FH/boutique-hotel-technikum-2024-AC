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

    /* No annotation necessary as JPA connventions define, 
    that for Strings, Java object and table column are names the same.
    But for clarity they @Column could be added*/
    private String title; 

    private String description;

    @Column(name = "person_capacity")
    private int personCapacity;

    @Column(name = "size_sqm")
    private int sizeSqm;
}
