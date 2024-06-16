package org.technikum.backend.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookingDTO {
    private int id;
    private RoomDTO room;
    private GuestDTO guest;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean breakfast;
}
