package org.technikum.backend.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GuestDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
