package org.technikum.backend.model;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private int room_id;
    private int guest_id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean breakfast;
    private Date startDate;
    private Date endDate;
}
