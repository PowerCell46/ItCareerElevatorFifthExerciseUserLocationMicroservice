package ItCareerElevatorFifthExcercise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLocationDTO {

    // TODO: username can be added also

    private String userId;

    private Double latitude;

    private Double longitude;

    private Long timestamp;
}
