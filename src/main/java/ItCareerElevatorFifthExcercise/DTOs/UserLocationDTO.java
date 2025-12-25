package ItCareerElevatorFifthExcercise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLocationDTO {

    private String userId; // TODO: username can be added also

    private Double latitude;

    private Double longitude;

    private Long timestamp;
}
