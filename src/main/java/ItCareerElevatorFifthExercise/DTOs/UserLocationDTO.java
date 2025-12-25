package ItCareerElevatorFifthExercise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserLocationDTO {

    private String userId;

    private String username;

    private Double latitude;

    private Double longitude;

    private Long timestamp;
}
