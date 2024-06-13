package org.technikum.backend.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "room_id")
    private int roomId;

    @Column(name = "guest_id")
    private int guestId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "breakfast")
    private boolean breakfast;

    public Booking() {

    }

    public Booking(int roomId, int guestId, LocalDate startDate, LocalDate endDate, boolean breakfast) {
        this.roomId = roomId;
        this.guestId = guestId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.breakfast = breakfast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", room=" + roomId +
                ", guest=" + guestId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", breakfast=" + breakfast +
                '}';
    }
}
