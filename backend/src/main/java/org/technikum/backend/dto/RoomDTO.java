package org.technikum.backend.dto;

import lombok.Builder;
import lombok.Value;


/*
 * DTO is used to transfer data from the Controller to the client and vice versa
 * Only contains the data that needs to be exposed and can include validation rules
 */
@Value
@Builder
public class RoomDTO {
    int id;
    String title;
    String description;
    int personCapacity;
    int sizeSqm;
}
