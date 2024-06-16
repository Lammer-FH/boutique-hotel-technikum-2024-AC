package org.technikum.backend.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "breakfast")
    private boolean breakfast;

    public Booking() {

    }

    public Booking(Room room, Guest guest, LocalDate startDate, LocalDate endDate, boolean breakfast) {
        this.room = room;
        this.guest = guest;
        this.startDate = startDate;
        this.endDate = endDate;
        this.breakfast = breakfast;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", room=" + room +
                ", guest=" + guest +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", breakfast=" + breakfast +
                '}';
    }
}
