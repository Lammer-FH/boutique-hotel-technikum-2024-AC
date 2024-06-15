package org.technikum.backend.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookingDTO {
    private int roomId;
    private int guestId;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean breakfast;
}
